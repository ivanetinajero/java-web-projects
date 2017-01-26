<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>LOGIN | WEB DASHBOARD</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">
      <center><img src="${pageContext.request.contextPath}/img/login.png" width="136" height="136"><br>
      <img src="${pageContext.request.contextPath}/img/error.png" width="48" height="48">      
      </center>      
      <form class="form-signin" action="j_security_check" method="post"> 
        <font style="color: red;"><h4 class="form-signin-heading">Acceso denegado</h4></font> 
        <h2 class="form-signin-heading">ADMINISTRADOR</h2>        
        <label for="j_username" class="sr-only">Usuario</label>
        <input type="text" id="j_username" name="j_username" class="form-control" placeholder="Usuario" required autofocus>
        <label for="j_password" class="sr-only">Contraseña</label>
        <input type="password" id="password" name="j_password" class="form-control" placeholder="Contraseña" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      </form>

    </div> <!-- /container -->

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
