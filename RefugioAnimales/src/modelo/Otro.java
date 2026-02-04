package modelo;

import java.time.LocalDate;

public class Otro extends Animal {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Variables
	private String especie;
	private boolean necesitaTerrario;
	private boolean exotico;

	// getters y setters
	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public boolean isNecesitaTerrario() {
		return necesitaTerrario;
	}

	public void setNecesitaTerrario(boolean necesitaTerrario) {
		this.necesitaTerrario = necesitaTerrario;
	}

	public boolean isExotico() {
		return exotico;
	}

	public void setExotico(boolean exotico) {
		this.exotico = exotico;
	}

	// constructor
	public Otro(String especie, String chip, String nombre, String personalidad, LocalDate fechaIngreso,
			LocalDate fechaNac, EstadoSalud estadoSalud, Tamanio tamanio, boolean necesitaTerrario, boolean exotico) {

		super(chip, nombre, personalidad, fechaIngreso, fechaNac, estadoSalud, tamanio);
		this.especie = especie;
		this.necesitaTerrario = necesitaTerrario;
		this.exotico = exotico;
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
		System.out.println("NECESITA TERRARIO: " + (necesitaTerrario ? "Sí" : "No"));
		System.out.println("ES EXÓTICO: " + (exotico ? "Sí" : "No"));
		System.out.println("---------------------------");
	}
}