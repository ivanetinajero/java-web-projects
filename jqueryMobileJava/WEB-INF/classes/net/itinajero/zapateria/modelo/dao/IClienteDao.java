package net.itinajero.zapateria.modelo.dao;

import java.sql.SQLException;

import net.itinajero.zapateria.modelo.dto.Cliente;

public interface IClienteDao {
	Cliente getById(int id) throws SQLException;
}
