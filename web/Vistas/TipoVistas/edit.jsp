<%-- 
    Document   : edit
    Created on : 7/08/2020, 07:39:08 PM
    Author     : Estiven
--%>
<%@page import="Modelo.Tipo"%>
<%@page import="ModeloDao.TipoDAO"%>
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/Personalizado/new.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
         <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-toggler" href="./Principal.jsp"><span class="navbar-toggler-icon"></span>Home</a>

            <div class="dropdown">
                <a href="./index.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: wheat">Cerrar Sesion</a>

            </div>
        </nav>
       <div class="container col-lg-6">
            
            <%
            TipoDAO dao = new TipoDAO();
            int id = Integer.parseInt((String)request.getAttribute("idTipo"));
            Tipo tipo = dao.list(id);
            
            %>
            <h1 class="text-center">Editar Tipo</h1>
            
            <form action="ControladorTipo">
                <div class="form-group">
                    <center>
                       <label>Nombre</label>  
                    </center>
                   
                    <input class="form-control" class="form-control" type="text" name="txtDescripcionTipo" value="<%= tipo.getDescripcionTipo()%>" required>
                    <input type="hidden" name="txtIdTipo" value="<%= tipo.getIdTipo()%>">
                </div>      
                <br>
                <center>
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-warning btn-lg">
                </center>
            </form>
                <a href="ControladorTipo?accion=listar" class="btn btn-info">Regresar</a>
        </div>
    </body>
</html>
