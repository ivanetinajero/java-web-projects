package net.itinajero.zapateria.modelo.dto;

import java.io.Serializable;

public class Sucursal implements Serializable {
	private int idSucursal;
	private String nombre;
	private String direccion;

	public Sucursal() {
		
	}

	
	public Sucursal(int idSucursal) {
		super();
		this.idSucursal = idSucursal;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Sucursal [idSucursal=" + idSucursal + ", nombre=" + nombre
				+ ", direccion=" + direccion + "]";
	}
	
}
