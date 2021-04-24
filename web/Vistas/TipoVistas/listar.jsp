<%-- 
    Document   : listar
    Created on : 7/08/2020, 07:39:28 PM
    Author     : Estiven
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Tipo"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDao.TipoDAO"%>
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
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

        <div class="container-fluid">
            <h1 class="text-center">Listado de Tipos</h1>

            <a class="btn bg-success btn-lg" href="ControladorTipo?accion=add">Agregar Nuevo</a>

            <table class=" table table-hover table-bordered ">
                <thead class="bg-dark text-light">
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Descripcion</th>
                        <th class="text-center">Opciones</th>
                       
                    </tr>
                </thead>

                <%
                    TipoDAO dao = new TipoDAO();
                    List<Tipo> list = dao.listar();
                    Iterator<Tipo> iterTipo = list.iterator();
                    Tipo tipo = null;
                    while (iterTipo.hasNext()) {
                        tipo = iterTipo.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= tipo.getIdTipo()%></td>
                        <td class="text-center"><%= tipo.getDescripcionTipo()%></td>
                       
                        <td class="text-center">
                            <a href="ControladorTipo?accion=editar&id=<%= tipo.getIdTipo()%>" class="btn btn-warning ">Editar</a>
                            <a href="ControladorTipo?accion=eliminar&id=<%= tipo.getIdTipo()%>" class="btn btn-danger ">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
    <script src="../../Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../../Bootstrap/js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="../../Bootstrap/js/popper.min.js" type="text/javascript"></script>
    </body>
</html>
