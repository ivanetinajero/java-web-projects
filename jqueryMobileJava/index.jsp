<!doctype html>
<html>
<head>
	<title>Zapateria POS</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.mobile-1.4.4.min.css">
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.mobile-1.4.4.min.js"></script>	
	<script type="text/javascript">
	         function validarFormulario(){
	            if (document.form.txtName.value==""){
	               alert("Escriba el nombre de usuario.");
	               return;
	            }
	            if (document.form.txtPass.value==""){
	               alert("Escriba el password.");
	               return;
	            }                                      
	            document.form.submit();
	         }
     </script>
</head>
<body>
	<div data-role="page">
		
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>Zapateria POS</h1>
		</div>
		<!-- /header -->
	
		<div data-role="content">
		<center>
			<h1>Mobile POS v1.0 CIMAT&copy</h1><img src="${pageContext.request.contextPath}/images/logo.png"/></center>
			<h5>${msg}</h5>			
				<form class="userform" action="${pageContext.request.contextPath}/login" name="form" method="post">
				     <label for="txtName">Usuario</label>
	    			 <input data-clear-btn="true" name="txtName" id="txtName" value="" type="text">
				     <label for="txtPass">Password</label>
				     <input data-clear-btn="true" name="txtPass" id="txtPass" value="" autocomplete="off" type="password">
				     <input type="button" onclick="validarFormulario()" name="Submit" value="Entrar" />
				</form>	
						
		</div>
		<!-- /content -->
	
		<div data-role="footer"  data-position="fixed" data-theme="b">
			<div data-role="navbar">
		         <ul>
		            <li><a href="${pageContext.request.contextPath}/Vista/frmAcerca.jsp" data-icon="info" data-ajax="false">Acerca</a></li>        
		    	  </ul>
            </div><!-- /navbar -->
           
		</div>
		<!-- /footer -->
	
	</div><!-- /page -->
</body>
</html>