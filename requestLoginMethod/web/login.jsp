<!DOCTYPE html>
<html>
  <head>
    <title>Ingreso al sistema</title>
  </head>
  <body>
  <center>
    <img src="${pageContext.request.contextPath}/img/lock.png">
    <h1>My company</h1>
    <h2>Sistema de Noticias</h2>			
    <form name='form' action='${pageContext.request.contextPath}/login' method='POST'>
      <br>
      <table>
        <tr>
          <td>Usuario:</td>
          <td><input type='text' name='txtUserName'></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><input type='password' name='txtPassword' /></td>
        </tr>
        <tr>
          <td colspan='2'><input name="submit" type="submit" value="Ingresar" /></td>
        </tr>
      </table>
    </form>
  </center>
</body>
</html>
