<%-- 
    Document   : add
    Created on : 10/08/2020, 09:10:58 PM
    Author     : Estiven
--%>
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/Personalizado/new.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-toggler" href="./Principal.jsp"><span class="navbar-toggler-icon"></span>Home</a>
            
            <div class="dropdown">
                <a href="./index.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: wheat">Cerrar Sesion</a>
  
            </div>
        </nav>
        <h1 class="text-center">Agregar Nuevo Empleado</h1>
        <div class="container col-lg-6">
            
            <form action="ControladorEmpleado" class="">
                <div class="form-group">
                     <center>
                         <label class="text-center">Nombre</label>
                    </center>
                   
                    <input type="text" name="txtNombreEmpleado" required class="form-control" required>
                </div>
                <br>
                <div class="form-group">
                    <center>
                    <label class="text-center">Apellido</label>
                    </center>
                    <input type="text" name="txtApellidoEmpleado" required class="form-control" required>
                </div >
                <br>
                <div class="form-group">
                     <center>
                        <label class="text-center">Edad</label>
                    </center>
                    
                    <input type="text" name="txtEdadEmpleado" required class="form-control" required>
                </div>
                <br>
                <div class="form-group">
                     <center>
                        <label class="text-center">Salario</label>
                    </center>
                    
                    <input type="number" name="txtSalarioEmpleado" required class="form-control col-1" required placeholder="Solo números">
                </div>
                <br>
                 <div class="form-group">
                     <center>
                        <label class="text-center">Correo</label>
                    </center>
                    
                    <input type="email" name="txtCorreoEmpleado" required class="form-control col-1" required >
                </div>
                <br>
                <input type="submit" name="accion" value="Agregar" class="btn btn-lg btn-success btn-block">
            </form>
        </div>
         <a href="ControladorEmpleado?accion=listar" class="btn btn-info">Regresar</a>
    </body>
</html>
