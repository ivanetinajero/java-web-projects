package net.itinajero.zapateria.modelo.dao;

import java.sql.SQLException;

import net.itinajero.zapateria.modelo.dto.Categoria;

public interface ICategoriaDao {
	Categoria getById(int id) throws SQLException;
}
