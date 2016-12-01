package net.itinajero.zapateria.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.itinajero.zapateria.modelo.dto.Cliente;

public class ClienteDao implements IClienteDao {
	
	private DbConnection cn;

	public ClienteDao(DbConnection cn) {		
		this.cn = cn;
	}

	@Override
	public Cliente getById(int id) throws SQLException {
		String sql ="select * from cliente where idCliente=?";
		PreparedStatement preparedStatement = cn.getConnection().prepareStatement(sql);
		preparedStatement.setInt(1, id); 		
		ResultSet rs = preparedStatement.executeQuery();
		Cliente cliente= new Cliente(0);
		if (rs.next()) {
			cliente.setIdCliente(rs.getInt("idCliente"));
			cliente.setNombre(rs.getString("nombre"));
			cliente.setDireccion(rs.getString("direccion"));
			cliente.setTelefono(rs.getString("telefono"));
		}
				
		return cliente;
	}

}
