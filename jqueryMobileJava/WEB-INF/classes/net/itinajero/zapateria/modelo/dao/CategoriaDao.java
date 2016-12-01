package net.itinajero.zapateria.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.itinajero.zapateria.modelo.dto.Categoria;


public class CategoriaDao implements ICategoriaDao {
	
	private DbConnection cn;

	public CategoriaDao(DbConnection cn) {		
		this.cn = cn;
	}

	@Override
	public Categoria getById(int id) throws SQLException {
		String sql ="select * from categoria where idCategoria=?";
		PreparedStatement preparedStatement = cn.getConnection().prepareStatement(sql);
		preparedStatement.setInt(1, id); 		
		ResultSet rs = preparedStatement.executeQuery();
		Categoria categoria= new Categoria(0);
		if (rs.next()) {
			categoria.setIdCategoria(rs.getInt("idCategoria"));
			categoria.setDescripcion(rs.getString("descripcion"));			
		}
				
		return categoria;
	}

}
