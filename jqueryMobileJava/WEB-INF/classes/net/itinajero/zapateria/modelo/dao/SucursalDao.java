package net.itinajero.zapateria.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.itinajero.zapateria.modelo.dto.Sucursal;

public class SucursalDao implements ISucursalDao{
	
	private DbConnection cn;

	public SucursalDao(DbConnection cn) {		
		this.cn = cn;
	}

	@Override
	public Sucursal getById(int id) throws SQLException {
		String sql ="select * from sucursal where idSucursal=?";
		PreparedStatement preparedStatement = cn.getConnection().prepareStatement(sql);
		preparedStatement.setInt(1, id); 		
		ResultSet rs = preparedStatement.executeQuery();
		Sucursal sucursal= new Sucursal(0);
		if (rs.next()) {
			sucursal.setIdSucursal(rs.getInt("idSucursal"));
			sucursal.setNombre(rs.getString("nombre"));
			sucursal.setDireccion(rs.getString("direccion"));
		}
				
		return sucursal;
	}

}
