<%-- 
    Document   : registro
    Created on : 18/08/2020, 09:41:08 AM
    Author     : Estiven
--%>
<link href="./Bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/Personalizado/registro.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <div class="container-md">
            <header class="header ">
            <nav class="navbar navbar-expand-lg navbar-light bg-light nav-static">
             

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link btn btn-lg btn-block text-dark" href="login.jsp">
                                Inicio de sesion
                            </a>
                        </li>
                                    
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link btn btn-lg btn-block text-dark" href="UserController?accion=salir">
                                Salir
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        </div>
        
        <div class="container-sm">
        <%
            HttpSession registro = request.getSession();
            Object rol = registro.getAttribute("opcionAlerta");
            String alertaOpcion = rol.toString();
            int alerta = Integer.parseInt(alertaOpcion);
            if (alerta == 5) {
        %>
        <div class="alert alert-danger alert-dismissable">  
            <button type="button" class="close" datadismiss="alert">&times;</button> 
            <strong>Error!</strong> El correo de usuario ya existe
        </div>
        <%
        }else if(alerta == 6){
        %>
        <div class="alert alert-danger alert-dismissable">  
            <button type="button" class="close" datadismiss="alert">&times;</button> 
            <strong>Error!</strong>  las contraseñas no coinciden
        </div>
        <%}%>
        </div>
        
        <h1 class="text-center">Registro normal</h1>
        <div class="container col-lg-4">
            <form action="UserController">
                
                 <div class="form-group text-center">
                    <img src="./img/png-transparent-computer-icons-login-icon-design-others-logo-silhouette-share-icon.png" alt="" height="80" width="130"/>
                    
                    <p><strong>Por Favor Ingrese
                        los Siguientes datos</strong></p>
                </div> 
                <div class="form-group">
                    <center><label>Nombre:</label></center>
                    <input type="text" name="txtNombreUsuario" class="form-control">
                </div>
                <div class="form-group">
                    <center><label>Email:</label></center>
                    <input type="email" name="txtCorreoUsuario" class="form-control" required>
                </div>
                 <div class="form-group">
                    <center><label>Contraseña:</label></center>
                    <input type="password" name="txtContrasenaUsuario" class="form-control" required>
                </div>
                <div class="form-group">
                    <center><label>Confirme Contraseña:</label></center>
                    <input type="password" name="txtContrasenaUsuarioConfirmacion" class="form-control" required>
                    <input type="hidden" value="3" name="txtRolUsuario">
                </div>
                <br>
                <center>
                <input type="submit" name="accion" Value="Registrar" class="btn btn-success btn-block " id="pincheBoton">
                </center>
            </form>
        </div>
    </body>
</html>
