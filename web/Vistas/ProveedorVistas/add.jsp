<%-- 
    Document   : add
    Created on : 4/08/2020, 04:02:04 PM
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
        <title>Insertar Proveedor</title>
    </head>
    <body>
        
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-toggler" href="./Principal.jsp"><span class="navbar-toggler-icon"></span>Home</a>
            
            <div class="dropdown">
                <a href="./index.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: wheat">Cerrar Sesion</a>
  
            </div>
        </nav>
        <h1 class="text-center">Agregar Nuevo Proveedor</h1>
        <div class="container col-lg-6">
            
            <form action="ControladorProveedor" class="">
                <div class="form-group">
                     <center>
                         <label class="text-center">Nombre</label>
                    </center>
                   
                    <input type="text" name="txtNombreProveedor" required class="form-control">
                </div>
                <div class="form-group">
                    <center>
                    <label class="text-center">RUT</label>
                    </center>
                    <input type="text" name="txtRUTProveedor" required class="form-control">
                </div >
                <div class="form-group">
                     <center>
                        <label class="text-center">Telefono</label>
                    </center>
                    
                    <input type="text" name="txtTelefonoProveedor" required class="form-control">
                </div>
                <div class="form-group">
                     <center>
                        <label class="text-center">Direccion</label>
                    </center>
                    
                    <input type="text" name="txtDireccionProveedor" required class="form-control col-1">
                </div>
                <br>
                <input type="submit" name="accion" value="Agregar" class="btn btn-lg btn-success btn-block">
            </form>
        </div>
         <a href="ControladorProveedor?accion=listar" class="btn btn-info">Regresar</a>
    </body>
</html>
