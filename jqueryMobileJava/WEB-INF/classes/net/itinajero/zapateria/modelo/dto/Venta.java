package net.itinajero.zapateria.modelo.dto;

import java.io.Serializable;

public class Venta implements Serializable{
	private int idVenta;
	private String fecha;
	private int cantidad;
	private double precio;
	private Sucursal sucursal;
	private Cliente cliente;
	private Producto producto;
	
	public Venta() {
		
	}
	
	public Venta(int idVenta) {
		super();
		this.idVenta = idVenta;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", fecha=" + fecha + ", cantidad="
				+ cantidad + ", precio=" + precio + ", sucursal=" + sucursal
				+ ", cliente=" + cliente + ", producto=" + producto + "]";
	}

	
}
