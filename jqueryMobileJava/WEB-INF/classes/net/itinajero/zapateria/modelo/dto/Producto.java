package net.itinajero.zapateria.modelo.dto;

import java.io.Serializable;

public class Producto implements Serializable{
	private int idProducto;
	private String codigo;
	private String descripcion;
	private double precioVenta;
	private double precioCosto;
	private Categoria categoria;
	
	public Producto() {
	
	}
	
	public Producto(int idProducto) {
		super();
		this.idProducto = idProducto;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getPrecioCosto() {
		return precioCosto;
	}

	public void setPrecioCosto(double precioCosto) {
		this.precioCosto = precioCosto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", codigo=" + codigo
				+ ", descripcion=" + descripcion + ", precioVenta="
				+ precioVenta + ", precioCosto=" + precioCosto + ", categoria="
				+ categoria + "]";
	}
	
	
}
