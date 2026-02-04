package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;

import excepciones.AnimalEnCuarentenaException;
import modelo.Animal;
import modelo.EstadoSalud;
import modelo.Gato;
import modelo.Otro;
import modelo.Perro;
import modelo.Tamanio;
import utilidades.ObjectOutputStreamSinCabecera;
import utilidades.Util;

public class Main {

	public static void main(String[] args) {
		int opc;

		do {
			menu();
			switch (opc = Util.leerInt("👉 Seleccione una opción: ")) {
			case 1:
				AltaA();
				break;
			case 2:
				GestionAdoptantesAdopciones();
				break;
			case 3:
				EstadisticasOcup();
				break;
			case 4:
				AceptarTramites();
				break;
			case 5:
				VerAdoptantesAdopciones();
				break;
			case 6:
				ModificarAnimal();
				break;
			case 7:
				BajaAnimal();
				break;
			case 8:
				System.out.println("Gracias por usar el programa...");
				break;
			default:

				break;
			}
		} while (opc != 8);
	}

	private static void AltaA() {
		int opc;
	    boolean valido = false;

	    do {
	        System.out.println("======================================");
	        System.out.println("1. PERRO");
	        System.out.println("2. GATO");
	        System.out.println("3. OTROS");
	        System.out.println("======================================");

	        opc = Util.leerInt("Introduce una opción");

	        switch (opc) {
	            case 1:
	                altaPerro();
	                valido = true;
	                break;
	            case 2:
	                altaGato();
	                valido = true;
	                break;
	            case 3:
	                altaOtros();
	                valido = true;
	                break;
	            default:
	                System.out.println("❌ Opción incorrecta, inténtalo de nuevo.");
	        }
	    } while (!valido);
	}

	private static void altaOtros() {
	    String chip;
	    String nombre;
	    String personalidad;
	    LocalDate fechaIngreso;
	    LocalDate fechaNac;
	    EstadoSalud estadoSalud = null;
	    Tamanio tamanio = null;
	    String especie;
	    boolean necesitaTerrario;
	    boolean exotico;

	    File fichero = new File("animales.obj");
	    ArrayList<Animal> lista = new ArrayList<>();

	    if (fichero.exists()) {
	        lista = leerObjeto(fichero);
	    }

	    int contador = lista.size() + 1;
	    chip = String.format("otr-%03d", contador);

	    System.out.println("Código generado: " + chip);

	    nombre = Util.introducirCadena("Nombre del animal: ");
	    personalidad = Util.introducirCadena("Personalidad: ");
	    fechaIngreso = LocalDate.now();
	    fechaNac = Util.pidoFechaDMA("Fecha de nacimiento (dd-mm-yyyy): ");

	    boolean correcto = false;

	    do {
	        try {
	            estadoSalud = EstadoSalud.valueOf(
	                Util.introducirCadena(
	                    "Estado de salud (SANO, EN_TRATAMIENTO, CUARENTENA): "
	                ).toUpperCase()
	            );
	            correcto = true;
	        } catch (IllegalArgumentException e) {
	            System.out.println("❌ Estado no válido. Inténtalo otra vez.");
	        }
	    } while (!correcto);

	    correcto = false;

	    do {
	        try {
	            tamanio = Tamanio.valueOf(
	                Util.introducirCadena(
	                    "Tamaño (PEQUEÑO/MEDIANO/GRANDE): "
	                ).toUpperCase()
	            );
	            correcto = true;
	        } catch (IllegalArgumentException e) {
	            System.out.println("❌ Tamaño no válido. Inténtalo otra vez.");
	        }
	    } while (!correcto);

	    especie = Util.introducirCadena("Especie: ");
	    necesitaTerrario = Util.leerRespuesta("¿Necesita terrario?: (Si/No)");
	    exotico = Util.leerRespuesta("¿Es un animal Exotico?: (Si/No)");

	    Otro otro = new Otro(especie, chip, nombre, personalidad, fechaIngreso, fechaNac, estadoSalud, tamanio, necesitaTerrario, exotico);

	    lista.add(otro);

	    if (guardarObjeto(lista, fichero)) {
	        System.out.println("✅ Animal registrado correctamente.");
	    } else {
	        System.out.println("❌ No se pudo registrar el animal.");
	    }
	}

	private static void altaGato() {
	    String chip;
	    String nombre;
	    String personalidad;
	    LocalDate fechaIngreso;
	    LocalDate fechaNac;
	    EstadoSalud estadoSalud = null;
	    Tamanio tamanio = null;
	    String raza;
	    String color;

	    File fichero = new File("animales.obj");
	    ArrayList<Animal> lista = new ArrayList<>();

	    if (fichero.exists()) {
	        lista = leerObjeto(fichero);
	    }

	    int contador = lista.size() + 1;
	    chip = String.format("gat-%03d", contador);

	    System.out.println("Código generado: " + chip);

	    nombre = Util.introducirCadena("Nombre del gato: ");
	    personalidad = Util.introducirCadena("Personalidad: ");
	    fechaIngreso = LocalDate.now();
	    fechaNac = Util.pidoFechaDMA("Fecha de nacimiento (dd-mm-yyyy): ");

	    boolean correcto = false;

	    do {
	        try {
	            estadoSalud = EstadoSalud.valueOf(
	                Util.introducirCadena(
	                    "Estado de salud (SANO, EN_TRATAMIENTO, CUARENTENA): "
	                ).toUpperCase()
	            );
	            correcto = true;
	        } catch (IllegalArgumentException e) {
	            System.out.println("❌ Estado no válido. Inténtalo otra vez.");
	        }
	    } while (!correcto);

	    correcto = false;

	    do {
	        try {
	            tamanio = Tamanio.valueOf(
	                Util.introducirCadena(
	                    "Tamaño (PEQUEÑO/MEDIANO/GRANDE): "
	                ).toUpperCase()
	            );
	            correcto = true;
	        } catch (IllegalArgumentException e) {
	            System.out.println("❌ Tamaño no válido. Inténtalo otra vez.");
	        }
	    } while (!correcto);

	    raza = Util.introducirCadena("Raza: ");
	    color = Util.introducirCadena("Color: ");

	    Gato gato = new Gato(raza, color, chip, nombre, personalidad, fechaIngreso, fechaNac, estadoSalud, tamanio);

	    lista.add(gato);

	    if (guardarObjeto(lista, fichero)) {
	        System.out.println("✅ Gato registrado correctamente.");
	    } else {
	        System.out.println("❌ No se pudo registrar el animal.");
	    }
	}

	private static void altaPerro() {
	    String chip;
	    String nombre;
	    String personalidad;
	    LocalDate fechaIngreso;
	    LocalDate fechaNac;
	    EstadoSalud estadoSalud = null;
	    Tamanio tamanio = null;
	    String raza;
	    String pelaje;

	    File fichero = new File("animales.obj");
	    ArrayList<Animal> lista = new ArrayList<>();

	    if (fichero.exists()) {
	        lista = leerObjeto(fichero);
	    }

	    int contador = lista.size() + 1;
	    chip = String.format("per-%03d", contador);

	    System.out.println("Código generado: " + chip);

	    nombre = Util.introducirCadena("Nombre del perro: ");
	    personalidad = Util.introducirCadena("Personalidad: ");
	    fechaIngreso = LocalDate.now();
	    fechaNac = Util.pidoFechaDMA("Fecha de nacimiento (dd-mm-yyyy): ");

	    boolean correcto = false;

	    do {
	        try {
	            estadoSalud = EstadoSalud.valueOf(
	                Util.introducirCadena(
	                    "Estado de salud (SANO, EN_TRATAMIENTO, CUARENTENA): "
	                ).toUpperCase()
	            );
	            correcto = true;
	        } catch (IllegalArgumentException e) {
	            System.out.println("❌ Estado no válido. Inténtalo otra vez.");
	        }
	    } while (!correcto);

	    correcto = false;

	    do {
	        try {
	            tamanio = Tamanio.valueOf(
	                Util.introducirCadena(
	                    "Tamaño (PEQUENIO/MEDIANO/GRANDE): "
	                ).toUpperCase()
	            );
	            correcto = true;
	        } catch (IllegalArgumentException e) {
	            System.out.println("❌ Tamaño no válido. Inténtalo otra vez.");
	        }
	    } while (!correcto);

	    raza = Util.introducirCadena("Raza: ");
	    pelaje = Util.introducirCadena("Tipo de pelaje: ");

	    Perro perro = new Perro(raza, pelaje, chip, nombre, personalidad, fechaIngreso, fechaNac, estadoSalud, tamanio);

	    lista.add(perro);

	    if (guardarObjeto(lista, fichero)) {
	        System.out.println("✅ Perro registrado correctamente.");
	    } else {
	        System.out.println("❌ No se pudo registrar el animal.");
	    }
	}
	
	public static ArrayList<Animal> leerObjeto(File fichero) {
	    ArrayList<Animal> lista = new ArrayList<>();

	    if (!fichero.exists()) return lista;

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {

	        Object obj = ois.readObject();

	        if (obj instanceof ArrayList<?>) {
	            for (Object o : (ArrayList<?>) obj) {
	                if (o instanceof Animal) {
	                    lista.add((Animal) o);
	                }
	            }
	        }

	    } catch (Exception e) {
	        System.out.println("❌ Error leyendo animales.obj (archivo corrupto o vacío)");
	    }

	    return lista;
	}

	public static boolean guardarObjeto(ArrayList<Animal> lista, File fichero) {
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
	        oos.writeObject(lista);
	        return true;
	    } catch (Exception e) {
	        System.out.println("❌ Error guardando animales.obj");
	        e.printStackTrace();
	        return false;
	    }
	}

	@SuppressWarnings("unchecked")
	private static void GestionAdoptantesAdopciones() {

	    File ficheroAnimales = new File("animales.obj");
	    File ficheroPendientes = new File("pendientes.obj");

	    ArrayList<Animal> animales = new ArrayList<>();
	    ArrayList<String> pendientes = new ArrayList<>();

	    if (ficheroAnimales.exists()) {
	        animales = leerObjeto(ficheroAnimales);
	    }

	    if (animales.isEmpty()) {
	        System.out.println("No hay animales disponibles.");
	        return;
	    }

	    if (ficheroPendientes.exists()) {
	        try (ObjectInputStream ois =
	                new ObjectInputStream(new FileInputStream(ficheroPendientes))) {

	            pendientes = (ArrayList<String>) ois.readObject();

	        } catch (Exception e) {
	            pendientes = new ArrayList<>();
	        }
	    }

	    System.out.println("ANIMALES DISPONIBLES:");
	    for (Animal a : animales) {
	        System.out.println(a.getChip() + " - " + a.getNombre());
	    }

	    System.out.println("Introduce DNI del adoptante (8 números): ");
	    String dni = Util.leerDNI();

	    String chip = Util.introducirCadena("Introduce el chip del animal: ");

	    Animal seleccionado = null;

	    for (Animal a : animales) {
	        if (a.getChip().equalsIgnoreCase(chip)) {
	            seleccionado = a;
	            break;
	        }
	    }

	    if (seleccionado == null) {
	        System.out.println("Animal no encontrado.");
	        return;
	    }

	    try {
	        if (seleccionado.getEstadoSalud() == EstadoSalud.CUARENTENA) {
	            throw new AnimalEnCuarentenaException(
	                "❌ No se puede gestionar la adopción: animal en cuarentena."
	            );
	        }

	        String tramite = dni + ";" + chip;
	        pendientes.add(tramite);

	    } catch (AnimalEnCuarentenaException e) {
	        System.out.println(e.getMessage());
	        return;
	    }

	    try {
	        ObjectOutputStream oos;

	        if (ficheroPendientes.exists()) {
	            oos = new ObjectOutputStreamSinCabecera(
	                    new FileOutputStream(ficheroPendientes));
	        } else {
	            oos = new ObjectOutputStream(
	                    new FileOutputStream(ficheroPendientes));
	        }

	        oos.writeObject(pendientes);
	        oos.close();

	        System.out.println("Solicitud de adopción registrada correctamente.");

	    } catch (Exception e) {
	        System.out.println("Error al guardar el trámite.");
	    }
	}

	private static void EstadisticasOcup() {
	    File ficheroAnimales = new File("animales.obj");
	    ArrayList<Animal> lista = leerObjeto(ficheroAnimales);

	    if (lista.isEmpty()) {
	        System.out.println("❌ No hay animales en el refugio para mostrar estadísticas.");
	        return;
	    }

	    System.out.println("\n--- 📊 ESTADÍSTICAS Y OCUPACIÓN ---");
	    System.out.println("1. Listado por tiempo en el refugio (Mayor a Menor)");
	    System.out.println("2. Listado por edad (Menor a Mayor)");
	    int opcion = Util.leerInt("Seleccione una opción: ");

	    switch (opcion) {
	        case 1:
	            mostrarPorEstancia(lista);
	            break;
	        case 2:
	            mostrarPorEdad(lista);
	            break;
	        default:
	            System.out.println("Opción no válida.");
	            break;
	    }
	}

	private static void mostrarPorEstancia(ArrayList<Animal> lista) {
	    lista.sort(Comparator.comparing(Animal::getFechaIngreso));

	    long totalDias = 0;
	    System.out.println("\n--- LISTADO POR TIEMPO DE ESTANCIA ---");

	    for (Animal a : lista) {
	        long dias = ChronoUnit.DAYS.between(a.getFechaIngreso(), LocalDate.now());
	        totalDias += dias;

	        a.visualizar();
	        System.out.println("DÍAS EN EL REFUGIO: " + dias);
	        System.out.println();
	    }

	    double media = (double) totalDias / lista.size();
	    System.out.println("Media de estancia: " + media);
	    System.out.println("Total adopciones con éxito: " + contarAdopcionesExitosas());
	}

	private static void mostrarPorEdad(ArrayList<Animal> lista) {
	    lista.sort(Comparator.comparing(Animal::getFechaNac).reversed());

	    int sumaEdades = 0;
	    System.out.println("\n--- LISTADO POR EDAD ---");

	    for (Animal a : lista) {
	        int edad = Period.between(a.getFechaNac(), LocalDate.now()).getYears();
	        sumaEdades += edad;

	        a.visualizar();
	        System.out.println("EDAD: " + edad + " años");
	        System.out.println();
	    }

	    double mediaEdad = (double) sumaEdades / lista.size();
	    System.out.println("Media de edad: " + mediaEdad);
	    System.out.println("Total adopciones con éxito: " + contarAdopcionesExitosas());
	}

	private static int contarAdopcionesExitosas() {
	    File fAdopciones = new File("adopciones.obj");
	    if (!fAdopciones.exists()) return 0;
	    
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fAdopciones))) {
	        ArrayList<?> realizadas = (ArrayList<?>) ois.readObject();
	        return realizadas.size();
	    } catch (Exception e) {
	        return 0;
	    }
}

	private static void AceptarTramites() {
		// TODO Auto-generated method stub

	}

	private static void VerAdoptantesAdopciones() {
		// TODO Auto-generated method stub

	}

	private static void ModificarAnimal() {
	    File ficheroOriginal = new File("animales.obj");
	    File ficheroNuevo = new File("animales_temp.obj");

	    ArrayList<Animal> lista = leerObjeto(ficheroOriginal);

	    if (lista.isEmpty()) {
	        System.out.println("❌ No hay animales registrados para modificar.");
	        return;
	    }

	    String chipBusqueda = Util.introducirCadena("Introduce el chip del animal a modificar: ");
	    boolean encontrado = false;

	    for (Animal a : lista) {
	        if (a.getChip().equalsIgnoreCase(chipBusqueda)) {
	            encontrado = true;
	            System.out.println("Animal encontrado: " + a.getNombre());

	            String nuevoNombre = Util.introducirCadena("Nuevo nombre (deja vacío para no cambiar): ");
	            if (!nuevoNombre.isBlank()) a.setNombre(nuevoNombre);

	            String nuevaPerso = Util.introducirCadena("Nueva personalidad (deja vacío para no cambiar): ");
	            if (!nuevaPerso.isBlank()) a.setPersonalidad(nuevaPerso);

	            try {
	                String estadoStr = Util.introducirCadena("Nuevo estado (SANO, EN_TRATAMIENTO, CUARENTENA) o ENTER para omitir: ").toUpperCase();
	                if (!estadoStr.isBlank()) {
	                    a.setEstadoSalud(EstadoSalud.valueOf(estadoStr));
	                }
	            } catch (Exception e) {
	                System.out.println("Estado no válido, se mantiene el anterior.");
	            }
	            break;
	        }
	    }

	    if (encontrado) {
	        if (guardarObjeto(lista, ficheroNuevo)) {
	            if (ficheroOriginal.delete()) {
	                ficheroNuevo.renameTo(ficheroOriginal);
	                System.out.println("✅ Animal modificado y fichero actualizado correctamente.");
	            }
	        }
	    } else {
	        System.out.println("❌ No se encontró ningún animal con ese chip.");
	    }
	}

	private static void BajaAnimal() {
		// TODO Auto-generated method stub

	}

	private static void menu() {
		System.out.println("======================================");
		System.out.println("        🐾  MENÚ PRINCIPAL  🐾        ");
		System.out.println("======================================");
		System.out.println(" 1️.  Alta de animal");
		System.out.println(" 2.️  Gestión de adoptantes y adopciones");
		System.out.println(" 3️.  Estadísticas y ocupación");
		System.out.println(" 4️.  Aceptar trámites pendientes");
		System.out.println(" 5️.  Ver adoptantes y adopciones pendientes");
		System.out.println(" 6️.  Modificar datos de un animal");
		System.out.println(" 7️.  Baja de animal");
		System.out.println(" 8.  Salir");
		System.out.println("======================================");
	}

}