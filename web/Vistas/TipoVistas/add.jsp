<%-- 
    Document   : add
    Created on : 7/08/2020, 07:39:40 PM
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
        <title>ADD TIPO</title>
    </head>
    <body>
         <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-toggler" href="./Principal.jsp"><span class="navbar-toggler-icon"></span>Home</a>

            <div class="dropdown">
                <a href="./index.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: wheat">Cerrar Sesion</a>

            </div>
        </nav>
         <div class="container bg-light ">

            <center>
                 
                <div class="col-lg-3">

                    <h1 class="text-center ">Agregar Tipo ${nombre}</h1>
                    <br>
               
                    <form action="ControladorTipo" class="border border-dark">
                        <input type="hidden" name="user" value="${nombre}"> 
                        <div class="form-group">
                            <center>
                                <label from="dni" class=" text-center">Descripcion</label>
                            </center>
                            <input type="text" name="txtDescripcionTipo" class="form-control" id="dni" required><br>
                        </div>
                       
                        <div>
                            <center> 
                                <input  type="submit" name="accion" value="Agregar" class="btn btn-success btn-lg">
                            </center>
                        </div>
                        
                    </form>

            </center>
            <a href="ControladorTipo?accion=listar" class="btn btn-info btn-sm  shadow">Regresar<a/>
        </div>
    </div>
    </body>
</html>
