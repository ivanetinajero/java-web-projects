package net.itinajero.zapateria.modelo.dto;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private int idUsuario;
	private Sucursal sucursal;
	private String usuario;
	private String nombre;
	private String password;
	private String tipo;
	private int activo=1;
	
	public Usuario() {
		
	}
	
	public Usuario(int idUsuario) {
		super();
		this.idUsuario = idUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", sucursal=" + sucursal
				+ ", usuario=" + usuario + ", nombre=" + nombre + ", password="
				+ password + ", tipo=" + tipo + ", activo=" + activo + "]";
	}

	
	
}
