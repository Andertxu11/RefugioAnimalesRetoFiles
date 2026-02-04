package modelo;

import java.time.LocalDate;

public class Perro extends Animal {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// variables
	private String raza;
	private String pelaje;

	// getters y setters
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getPelaje() {
		return pelaje;
	}

	public void setPelaje(String pelaje) {
		this.pelaje = pelaje;
	}

	// constructor
	public Perro(String raza, String pelaje, String chip, String nombre, String personalidad, LocalDate fechaIngreso,
			LocalDate fechaNac, EstadoSalud estadoSalud, Tamanio tamanio) {

		super(chip, nombre, personalidad, fechaIngreso, fechaNac, estadoSalud, tamanio);
		this.raza = raza;
		this.pelaje = pelaje;
	}

	// metodo visualizar
	public void visualizar() {
		System.out.println("NOMBRE: " + nombre);
		System.out.println("CHIP: " + chip);
		System.out.println("PERSONALIDAD: " + personalidad);
		System.out.println("FECHA INGRESO: " + fechaIngreso);
		System.out.println("FECHA NACIMIENTO: " + fechaNac);
		System.out.println("ESTADO DE SALUD: " + estadoSalud);
		System.out.println("TAMAÑO " + tamanio);
		System.out.println("RAZA: " + raza);
		System.out.println("PELAJE: " + pelaje);
		System.out.println("---------------------------");
	}
}