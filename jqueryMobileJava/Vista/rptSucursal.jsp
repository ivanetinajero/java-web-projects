<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<c:if test="${(usuario==null)}"> 	                
       <c:redirect url="/index.jsp"/>
</c:if>
<!doctype html>
<html>
	<head>
		<title>Ventas por Sucursal</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.mobile-1.4.4.min.css">
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.mobile-1.4.4.min.js"></script>	
	</head>
	<body>
		<div data-role="page">
			
			<div data-role="header" data-position="fixed" data-theme="b">
				<div data-role="navbar">
		            <ul>		                            
		               <li><a href="${pageContext.request.contextPath}/venta" data-icon="calendar" data-ajax="false">Reporte del dia</a></li>  
		               <c:if test="${(usuario.tipo=='vendedor')}"> 	                
				            <li><a href="${pageContext.request.contextPath}/Vista/frmVenta.jsp" data-icon="shop" data-ajax="false">Capturar Venta</a></li>				            
				       </c:if>  
				       <li><a href="${pageContext.request.contextPath}/logout" data-icon="power" data-ajax="false">Salir</a></li>		                       
		            </ul>
       			</div><!-- /navbar -->
			</div>
			<!-- /header -->
		
			<div data-role="content">
				<h4>Listado de ventas</h4>
				<table data-role="table" id="table-custom-2" data-mode="columntoggle" class="ui-body-d ui-shadow table-stripe ui-responsive" data-column-btn-theme="b" data-column-btn-text="Columns to display..." data-column-popup-theme="a">
		         <thead>
		           <tr class="ui-bar-d">
		             <th>Sucursal</th>		             
		             <th>Fecha</th>
		             <th data-priority="3">Producto</th>
		             <th data-priority="1">Cantidad</th>
		             <th data-priority="5">Precio</th>
		             <th data-priority="5">Total</th>
		           </tr>
		         </thead>
		         <tbody>
		          <c:set var="total" value="0" scope="page" />
		          <c:forEach items="${listaVentas}" var="venta" varStatus="status">
			           <tr>
			             <th>${venta.sucursal.nombre}</th>
			             <th>${venta.fecha}</th>
			             <td>${venta.producto.descripcion}</td>
			             <td>${venta.cantidad}</td>
			             <td>${venta.precio}</td>
			             <td>$${(venta.cantidad*venta.precio)}</td>			             
			           </tr>	
		           </c:forEach>	           	       		             
		         </tbody>
		       </table>
			 
			</div>
			<!-- /content -->
		
			<div data-role="footer"  data-position="fixed" data-theme="b">
				<div data-role="navbar">
			         <ul>
			            <li><a href="${pageContext.request.contextPath}/Vista/frmAcerca.jsp" data-icon="info" data-ajax="false"  >Acerca</a></li>        
			    	  </ul>
            	</div><!-- /navbar -->
			</div>
			<!-- /footer -->
		
		</div><!-- /page -->
	</body>
</html>