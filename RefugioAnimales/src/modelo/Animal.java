package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Animal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// variables
	protected String chip;
	protected String nombre;
	protected String personalidad;
	protected LocalDate fechaIngreso;
	protected LocalDate fechaNac;
	protected EstadoSalud estadoSalud;
	protected Tamanio tamanio;

	// constructor
	public Animal(String chip, String nombre, String personalidad, LocalDate fechaIngreso, LocalDate fechaNac,
			EstadoSalud estadoSalud, Tamanio tamanio) {

		this.chip = chip;
		this.nombre = nombre;
		this.personalidad = personalidad;
		this.fechaIngreso = fechaIngreso;
		this.fechaNac = fechaNac;
		this.estadoSalud = estadoSalud;
		this.tamanio = tamanio;
	}

	// getters y setters
	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPersonalidad() {
		return personalidad;
	}

	public void setPersonalidad(String personalidad) {
		this.personalidad = personalidad;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public EstadoSalud getEstadoSalud() {
		return estadoSalud;
	}

	public void setEstadoSalud(EstadoSalud estadoSalud) {
		this.estadoSalud = estadoSalud;
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	// metodo visualizar
	public abstract void visualizar();

}