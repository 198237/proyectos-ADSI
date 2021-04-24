<%-- 
    Document   : index
    Created on : 2/08/2020, 01:04:11 PM
    Author     : Estiven
--%>
<script src="Bootstrap/js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="Bootstrap/js/popper.min.js" type="text/javascript"></script>
<script src="Bootstrap/js/bootstrap.js" type="text/javascript"></script>
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="Bootstrap/Personalizado/estilos.css" rel="stylesheet" type="text/css"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>

        <div class="container-md">
            <header class="header ">
                <nav class="navbar navbar-expand-lg navbar-light bg-light nav-static">


                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item">
                                <a class="nav-link btn btn-lg btn-block text-dark" href="UserController?accion=registrarse">
                                    Registro
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

        <%
            HttpSession holaPerros = request.getSession();
            Object rol = holaPerros.getAttribute("opcionAlerta");
            String alertaOpcion = rol.toString();
            int alerta = Integer.parseInt(alertaOpcion);
            if (alerta == 1) {
        %>
        <div class="alert alert-success alert-dismissable">  
            <button type="button" class="close" datadismiss="alert">&times;</button> 
            <strong>Bienvenido!</strong> Ya puedes acceder al sistema 
        </div>
        <%
        } else if (alerta == 4) {
        %>
        <div class="container-sm">
            <div class="alert alert-danger alert-dismissable">  
                <button type="button" class="close" datadismiss="alert">&times;</button> 
                <strong>Error!</strong> Sus datos no coinciden
            </div>
        </div>
        <%
        } else if (alerta == 3) {
        %>
        <div class="container-sm">

        </div>
        <%}%>


        <div class="container col-lg-4">
            <form action="UserController">
                <div class="form-group text-center">
                    <img src="img/profile_llama@4x.png" alt="" height="80" width="130" id="logo"/>
                    <p><strong>Bienvenido al sistema de Login</strong></p>
                </div> 

                <div class="form-group">
                    <center><label>Nombre:</label></center>
                    <input type="text" name="txtNombreUsuario" class="form-control" id="nombre">
                </div>
                <br>
                <div class="form-group">

                    <center><label for="correo">Email:</label></center>
                    <input type="email" id="correo" name="txtCorreoUsuario" class="form-control" required >
                </div>
                <br>
                <div class="form-group">
                    <center><label>Contraseña:</label></center>
                    <input type="password" name="txtContrasenaUsuario" class="form-control" required id="password">
                </div>
                <br>
                <center>
                    <input type="submit" name="accion" Value="Ingresar" class="btn btn-danger btn-block  " id="boton">
                </center>
            </form>
        </div>
    </body>

</html>
