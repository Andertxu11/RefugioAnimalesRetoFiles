package modelo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Adoptante {
	// variables
	private String dni;
	private String nombre;
	private String apellido;
	private LocalDate fechaNac;
	private Map<String, Animal> animalesAdoptados = new HashMap<>();

	// getters and setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Map<String, Animal> getAnimalesAdoptados() {
		return animalesAdoptados;
	}

	public void setAnimalesAdoptados(Map<String, Animal> animalesAdoptados) {
		this.animalesAdoptados = animalesAdoptados;
	}

	// constructor
	public Adoptante(String dni, String nombre, String apellido, LocalDate fechaNac,
			Map<String, Animal> animalesAdoptados) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.animalesAdoptados = animalesAdoptados;
	}

	// metodo visualizar
	public void visualizar() {
	    System.out.println("=== DATOS DEL ADOPTANTE ===");
	    System.out.println("DNI: " + dni);
	    System.out.println("Nombre: " + nombre);
	    System.out.println("Apellido: " + apellido);
	    System.out.println("Fecha de nacimiento: " + fechaNac);

	    System.out.println("\n=== ANIMALES ADOPTADOS ===");

	    if (animalesAdoptados.isEmpty()) {
	        System.out.println("No ha adoptado ningún animal.");
	    } else {
	        for (String clave : animalesAdoptados.keySet()) {
	            Animal animal = animalesAdoptados.get(clave);
	            System.out.println("Clave: " + clave);
	            System.out.println(animal);
	            System.out.println("-------------------------");
	        }
	    }
	}


}
