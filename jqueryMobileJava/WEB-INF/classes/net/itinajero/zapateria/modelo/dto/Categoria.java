package net.itinajero.zapateria.modelo.dto;

import java.io.Serializable;

public class Categoria implements Serializable {
	private int idCategoria;
	private String descripcion;
	
	public Categoria() {
	
	}
	
	public Categoria(int idCategoria) {
		super();
		this.idCategoria = idCategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", descripcion="
				+ descripcion + "]";
	}
	
	
	
}
