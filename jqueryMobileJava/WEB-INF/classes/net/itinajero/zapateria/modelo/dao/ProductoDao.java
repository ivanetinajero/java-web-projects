package net.itinajero.zapateria.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.itinajero.zapateria.modelo.dto.Categoria;
import net.itinajero.zapateria.modelo.dto.Producto;

public class ProductoDao implements IProductoDao {
	
	private DbConnection cn;

	public ProductoDao(DbConnection cn) {		
		this.cn = cn;
	}

	@Override
	public Producto getByCodigo(String codigo) throws SQLException {
		String sql ="select * from producto where codigo=?";
		PreparedStatement preparedStatement = cn.getConnection().prepareStatement(sql);
		preparedStatement.setString(1, codigo); 		
		ResultSet rs = preparedStatement.executeQuery();
		Producto producto= new Producto(0);
		if (rs.next()) {
			producto.setIdProducto(rs.getInt("idProducto"));
			producto.setCodigo(codigo);
			producto.setDescripcion(rs.getString("descripcion"));
			producto.setPrecioCosto(rs.getDouble("precioCosto"));
			producto.setPrecioVenta(rs.getDouble("precioVenta"));
			
			//Buscamos la categoria
			ICategoriaDao categoriaDao = new CategoriaDao(cn);
			Categoria categoria= categoriaDao.getById(rs.getInt("idCategoria"));
			producto.setCategoria(categoria);
			
		}
		//System.out.println("Encontrando producto: "+producto);
		return producto;
	}

	@Override
	public Producto getById(int idProducto) throws SQLException {
		String sql ="select * from producto where idProducto=?";
		PreparedStatement preparedStatement = cn.getConnection().prepareStatement(sql);
		preparedStatement.setInt(1, idProducto); 		
		ResultSet rs = preparedStatement.executeQuery();
		Producto producto= new Producto(0);
		if (rs.next()) {
			producto.setIdProducto(rs.getInt("idProducto"));
			producto.setCodigo(rs.getString("codigo"));
			producto.setDescripcion(rs.getString("descripcion"));
			producto.setPrecioCosto(rs.getDouble("precioCosto"));
			producto.setPrecioVenta(rs.getDouble("precioVenta"));
			
			//Buscamos la categoria
			ICategoriaDao categoriaDao = new CategoriaDao(cn);
			Categoria categoria= categoriaDao.getById(rs.getInt("idCategoria"));
			producto.setCategoria(categoria);
			
		}
		//System.out.println("Encontrando producto: "+producto);
		return producto;
	}

}
