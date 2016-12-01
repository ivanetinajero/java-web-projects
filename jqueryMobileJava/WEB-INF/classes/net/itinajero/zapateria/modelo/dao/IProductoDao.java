package net.itinajero.zapateria.modelo.dao;

import java.sql.SQLException;

import net.itinajero.zapateria.modelo.dto.Producto;

public interface IProductoDao {
	Producto getByCodigo(String codigo) throws SQLException;
	Producto getById(int idProducto) throws SQLException;
}
