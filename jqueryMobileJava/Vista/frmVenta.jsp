<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<c:if test="${(usuario==null)}"> 	                
       <c:redirect url="/index.jsp"/>
</c:if>
<!doctype html>
<html>
	<head>
		<title>Capturar Venta</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.mobile-1.4.4.min.css">		
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.mobile-1.4.4.min.js"></script>	
		<script>
			// Tramemos los datos del articulo
			$(document).on('keypress','#txtCodigo',function(e){ 
		      if(e.which == 13) { // You press enter			   
				   var codigo = $(this).val(); // Text content	
				   getDatosArticulo(codigo);	   
				   return false; // Cancel submit
			  }
			});
			// Calculamos el total si cambia la cantidad
			$(document).on('blur','#txtCantidad',function(e){ 
			      //if(e.which == 13) { // You press enter			   
					   var cantidad = $(this).val(); // Text content	
					   if(isNaN(cantidad)){
						   alert("La cantidad no es un numero valido");
						   $('#txtTotal').val("0");
						   return;
					   }else{
						   var precioUnitario =  $('#txtPrecio').val();
						   $('#txtTotal').val(precioUnitario*$(this).val());
					   }
				 // }
			});
			
			function validar(){
				if (document.form.txtIdProducto.value==0 || document.form.txtTotal.value==0 || isNaN(document.form.txtCantidad.value)){
					alert("Los datos de la venta son incorrectos.");
					return;
				}
				if (confirm("¿Datos correctos?")){
					document.form.submit();
				}
			}
			
			function getDatosArticulo(codigoBarras)
			{  
			  $.ajax({            
			    type: "POST",     
			    url: "${pageContext.request.contextPath}/getProducto",    
			    dataType: "xml",    
			    data: "codigo="+codigoBarras,                           
			    success: function(xml) {
			      var id=0;
			      var descripcion="";
			      var precio="";
			      var categoria="";
			      // Contamos si se encontro el producto
			      var count=$(xml).find("producto").length;

			      if (count==1){      
				      $(xml).find('producto').each(function(){                
				         id = $(this).attr("idProducto");   
				         descripcion = $(this).attr("descripcion");
				         precio = $(this).attr("precioVenta");
				         categoria = $(this).attr("categoria");         
				         // Mostramos los datos del producto
				         $('#txtDescripcion').val(descripcion);
				         $('#txtCategoria').val(categoria);
				         $('#txtPrecio').val(precio);
				         $('#txtCantidad').val("1");
				         $('#txtTotal').val(precio);
				         $('#txtIdProducto').val(id);
				         	       
				      });       
			      }
			      else{
			    	  alert("Producto no encontrado");
			    	  // Mostramos los datos del producto
				      $('#txtDescripcion').val("");
				      $('#txtCategoria').val("");
				      $('#txtPrecio').val("0");
				      $('#txtCantidad').val("0");
				      $('#txtTotal').val("0");
				      $('#txtIdProducto').val("0");
			    	  return;
			      }
			    	  
			    },
			    // Funcion que controla los errores en caso de ocurrir alguno
			    error: function(jqXHR, exception) {
			        if (jqXHR.status === 0) {
			            alert('Not connect.\n Verify Network.');
			        } else if (jqXHR.status == 404) {
			            alert('Requested page not found. [404]');
			        } else if (jqXHR.status == 500) {
			            alert('Internal Server Error [500].');
			        } else if (exception === 'parsererror') {
			            alert('Requested JSON parse failed.');
			        } else if (exception === 'timeout') {
			            alert('Time out error.');
			        } else if (exception === 'abort') {
			            alert('Ajax request aborted.');
			        } else {
			            alert('Uncaught Error.\n' + x.responseText);
			        }
			    }  
			  });
			} 
			
		</script>
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
			</div><!-- /header -->
		
			<div data-role="content">
			<h5>${msg}</h5>
				<form class="userform" action="${pageContext.request.contextPath}/saveProducto" name="form" method="post" >
				     <div class="ui-field-contain">
					    <label for="txtCodigo">CODIGO PRODUCTO</label>
					    <input name="txtCodigo" id="txtCodigo" placeholder="Escriba el codigo del producto y presione [ENTER]" value="" type="text">
					    <label for="txtIdCliente" class="select">CLIENTE</label>
						<select name="txtIdCliente" id="txtIdCliente" data-native-menu="false">						   
						    <option value="1">PUBLICO GENERAL</option>						  
						    <option value="2">Felipe Gonzalez Lopez</option>
						    <option value="3">Marcela Diaz</option>
						    <option value="4">Marisol Martinez Esparza</option>						    
						</select>					   				  
					    <label for="txtDescripcion">NOMBRE PRODUCTO</label>
					    <input type="text" disabled="disabled" name="txtDescripcion" id="txtDescripcion" value="">
					    <label for="txtCategoria">CATEGORIA</label>
					    <input type="text" data-clear-btn="true" disabled="disabled" name="txtCategoria" id="txtCategoria" value="">
					    <label for="txtPrecio">PRECIO VENTA</label>
					    <input type="text" data-clear-btn="true" readonly name="txtPrecio" id="txtPrecio" value="0">
					    <label for="txtCantidad">CANTIDAD</label>
					    <input type="text" data-clear-btn="true" name="txtCantidad" id="txtCantidad" value="0">
					    <label for="txtTotal">TOTAL</label>
					    <input type="text" data-clear-btn="true" readonly name="txtTotal" id="txtTotal" value="0">
					    <input name="txtIdProducto" id="txtIdProducto" value="0" type="hidden">	
					  </div>	
					<input type="button" onclick="validar()" name="Submit" value="Guardar" />					
				</form>			
			</div><!-- /content -->
		
			<div data-role="footer"  data-position="fixed" data-theme="b">
				<div data-role="navbar">
			         <ul>
			            <li><a href="${pageContext.request.contextPath}/Vista/frmAcerca.jsp" data-icon="info" data-ajax="false"  >Acerca</a></li>        
			    	  </ul>
            	</div><!-- /navbar -->
			</div><!-- /footer -->
		
		</div><!-- /page -->
	</body>
</html>