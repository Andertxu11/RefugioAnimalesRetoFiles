package modelo;

import java.time.LocalDate;

public class Gato extends Animal {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// variables
	private String raza;
	private String color;

	// getters y setters
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Gato(String raza, String color, String chip, String nombre, String personalidad, LocalDate fechaIngreso,
			LocalDate fechaNac, EstadoSalud estadoSalud, Tamanio tamanio) {

		super(chip, nombre, personalidad, fechaIngreso, fechaNac, estadoSalud, tamanio);
		this.raza = raza;
		this.color = color;
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
		System.out.println("COLOR: " + color);
		System.out.println("---------------------------");
	}
}