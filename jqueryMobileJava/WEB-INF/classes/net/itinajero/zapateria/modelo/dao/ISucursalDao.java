package net.itinajero.zapateria.modelo.dao;

import java.sql.SQLException;

import net.itinajero.zapateria.modelo.dto.Sucursal;

public interface ISucursalDao {
	Sucursal getById(int id) throws SQLException;
}
