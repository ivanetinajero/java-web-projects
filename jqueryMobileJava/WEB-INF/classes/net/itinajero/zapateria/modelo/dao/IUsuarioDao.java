package net.itinajero.zapateria.modelo.dao;

import java.sql.SQLException;

import net.itinajero.zapateria.modelo.dto.Usuario;

public interface IUsuarioDao {
	Usuario getLogin(Usuario usuario) throws SQLException;
}
