package net.itinajero.zapateria.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.itinajero.zapateria.modelo.dto.Categoria;
import net.itinajero.zapateria.modelo.dto.Venta;

public class VentaDao implements IVentaDao {
	
	private DbConnection cn;

	public VentaDao(DbConnection cn) {		
		this.cn = cn;
	}

	@Override
	public int insert(Venta venta) throws SQLException {
		 String sql = "insert into venta values (?,?,?,?,?,?,?)";                 
         PreparedStatement preparedStatement = cn.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         preparedStatement.setInt(1, venta.getIdVenta());
         preparedStatement.setString(2, venta.getFecha());
         preparedStatement.setInt(3, venta.getCantidad());
         preparedStatement.setDouble(4, venta.getPrecio());
         preparedStatement.setInt(5, venta.getSucursal().getIdSucursal());
         preparedStatement.setInt(6, venta.getCliente().getIdCliente());
         preparedStatement.setInt(7, venta.getProducto().getIdProducto());
         preparedStatement.executeUpdate();            
         ResultSet rs = preparedStatement.getGeneratedKeys();
         int idVenta=0;
         if (rs.next()){
        	 idVenta=rs.getInt(1);
         }            
         return idVenta;   
	}

	@Override
	public List<Venta> getByFecha(int idSucursal) throws SQLException {
		String sql="";
		if (idSucursal>0){
			sql ="select * from venta where idSucursal=? order by fecha desc"; // Ventas por sucursal
		}
		else{
			sql ="select * from venta order by fecha desc"; // Todas las ventas
		}
		PreparedStatement preparedStatement = cn.getConnection().prepareStatement(sql);	
		if (idSucursal>0)
			preparedStatement.setInt(1, idSucursal);
		ResultSet rs = preparedStatement.executeQuery();		
		List<Venta> lista = new ArrayList<Venta>();
		while (rs.next()) {
			Venta venta= new Venta(0);
			venta.setIdVenta(rs.getInt("idVenta"));
			venta.setFecha(rs.getString("fecha"));
			venta.setCantidad(rs.getInt("cantidad"));
			venta.setPrecio(rs.getDouble("precio"));
			//Objecto Sucursal
			ISucursalDao sucursalDao = new SucursalDao(cn);
			venta.setSucursal(sucursalDao.getById(rs.getInt("idSucursal")));
			//Objeto Cliente
			IClienteDao clienteDao = new ClienteDao(cn);
			venta.setCliente(clienteDao.getById(rs.getInt("idCliente")));
			//Objecto Producto
			IProductoDao productoDao = new ProductoDao(cn);
			venta.setProducto(productoDao.getById(rs.getInt("idProducto")));			
			lista.add(venta);
		}
		
		return lista;		
	}

}
