package net.itinajero.zapateria.modelo.dto;

import java.io.Serializable;

public class Cliente implements Serializable{
	private int idCliente;
	private String nombre;
	private String direccion;
	private String telefono;
	
	public Cliente() {
	}
	
	public Cliente(int idCliente) {
		super();
		this.idCliente = idCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre
				+ ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}


}
