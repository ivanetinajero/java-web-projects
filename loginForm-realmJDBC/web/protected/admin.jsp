<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>ADMINISTRACION</title>
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
        <h3 class="text-muted">My Sitio de Noticias | Administración</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="#">Crear Noticia</a></li>            
            <li><a href="#">Crear Video</a></li>            
            <li><a href="#">Crear Servicio</a></li>                                                
            <li><a href="${pageContext.request.contextPath}/logout">Salir</a></li>            
          </ul>
        </nav>
      </div>
      <br>

      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Bienvenido al Sistema: ${usuario.nombre}</h3>          
        </div>
        <div class="panel-body">
          <h3 class="panel-title">Perfil Editor: ${usuario.editor}<br><br></h3>          
          <h3 class="panel-title">Perfil Gerente: ${usuario.gerente}<br><br></h3>          
        </div>
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2017 My Company, Inc.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>