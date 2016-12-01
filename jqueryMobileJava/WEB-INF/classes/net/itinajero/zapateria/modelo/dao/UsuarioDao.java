package net.itinajero.zapateria.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.itinajero.zapateria.modelo.dto.Usuario;

public class UsuarioDao implements IUsuarioDao{
	
	private DbConnection cn;

	public UsuarioDao(DbConnection cn) {		
		this.cn = cn;
	}

	@Override
	public Usuario getLogin(Usuario usuario) throws SQLException {
		
		String sql ="select * from usuario where usuario=? and password=md5(?) and activo=1 limit 1";
		PreparedStatement preparedStatement = cn.getConnection().prepareStatement(sql);
		preparedStatement.setString(1, usuario.getUsuario()); 
		preparedStatement.setString(2, usuario.getPassword()); 
		ResultSet rs = preparedStatement.executeQuery();
		Usuario oUsuario= new Usuario(0);
		if (rs.next()) {
			oUsuario.setIdUsuario(rs.getInt("idUsuario"));
			oUsuario.setUsuario(rs.getString("usuario"));
			oUsuario.setNombre(rs.getString("nombre"));
			oUsuario.setPassword(rs.getString("password"));
			oUsuario.setTipo(rs.getString("tipo"));
			oUsuario.setActivo(rs.getInt("activo"));
			// Buscamos los datos de la sucursal.
			ISucursalDao sucursalDao = new SucursalDao(cn);
			int idSucursal=rs.getInt("idSucursal");
			oUsuario.setSucursal(sucursalDao.getById(idSucursal));
		}
		//System.out.println(oUsuario);
				
		return oUsuario;
	}

}
