package net.itinajero.zapateria.modelo.dao;

import java.sql.SQLException;
import java.util.List;

import net.itinajero.zapateria.modelo.dto.Venta;

public interface IVentaDao {
	int insert(Venta venta) throws SQLException;
	List<Venta> getByFecha (int idSucursal) throws SQLException;
}
