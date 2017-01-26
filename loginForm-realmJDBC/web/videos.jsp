<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>VIDEOS</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/justified-nav.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
        <h3 class="text-muted">My Sitio de Noticias</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="${pageContext.request.contextPath}">Inicio</a></li>            
            <li><a href="${pageContext.request.contextPath}/services.jsp">Servicios</a></li>                        
            <li class="active"><a href="${pageContext.request.contextPath}/videos.jsp">Videos</a></li>                        
            <li><a href="${pageContext.request.contextPath}/protected/admin">Administrador</a></li>                                  
          </ul>
        </nav>
      </div>
      <br>

      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">SECCION DE VIDEOS</h3>          
        </div>
        <div class="panel-body">
          <h2 class="panel-title">
            <b>Video 1</b><br>
            <b>Video 2</b><br>
            <b>Video 3</b><br>
          </h2>          
        </div>
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2017 My Company, Inc.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>