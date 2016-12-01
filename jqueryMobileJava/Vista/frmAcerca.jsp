<!doctype html>
<html>
	<head>
		<title>Acerca</title>
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
		                <li><a href="" data-rel= "back" data-icon="back" data-ajax="false">Regresar</a></li>	                		              	                      
		            </ul>
       			</div><!-- /navbar -->
			</div>
			<!-- /header -->
		
			<div data-role="content">
				<center><img src="${pageContext.request.contextPath}/images/cimat.png"/><br/><br/>
				<h1>Maestria en Ingenieria de Software<br/>
				Tutor: Dr. Jos&eacute Arturo Mora Mora<br/> 
				Alumno: Ivan Eliseo Tinajero Diaz.</h1>
				</center>
				
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
