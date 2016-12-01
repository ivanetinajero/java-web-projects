<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${(usuario==null)}"> 	                
       <c:redirect url="/index.jsp"/>
</c:if>    
<!doctype html>
<html>
	<head>
		<title>Zapateria POS - Menu</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.mobile-1.4.4.min.css">
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.mobile-1.4.4.min.js"></script>		
	</head>
	<body>	
		<div data-role="page">
			
			<div data-role="header" data-position="fixed" data-theme="b">
				<h1>Bienvenid@ - ${usuario.nombre}</h1>
				<div data-role="navbar">
		            <ul>		               
		               <li><a href="${pageContext.request.contextPath}/venta" data-icon="calendar" data-ajax="false">Reporte del dia</a></li>	                
		               <c:if test="${(usuario.tipo=='vendedor')}"> 	                
				            <li><a href="${pageContext.request.contextPath}/Vista/frmVenta.jsp" data-icon="shop" data-ajax="false">Capturar Venta</a></li>				            
				       </c:if>  
				       <li><a href="${pageContext.request.contextPath}/logout" data-icon="power" data-ajax="false">Salir</a></li>		                       
		            </ul>
       			</div><!-- /navbar -->
			</div><!-- /header -->
		
			<div data-role="content">				
				<b>Perfil:</b><br/>${usuario.tipo}<br/><br/>
				<b>Sucursal:</b><br/>${usuario.sucursal.nombre}	
			</div><!-- /content -->
		
			<div data-role="footer"  data-position="fixed" data-theme="b">
				<div data-role="navbar">
		            <ul>
		               <li><a href="${pageContext.request.contextPath}/Vista/frmAcerca.jsp" data-icon="info" data-ajax="false">Acerca</a></li>        
		            </ul>
        		</div><!-- /navbar -->
			</div><!-- /footer -->
		
		</div><!-- /page -->
	</body>
</html>