<%-- 
    Document   : listar
    Created on : 10/08/2020, 06:19:46 PM
    Author     : Estiven
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Bodega"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDao.BodegaDAO"%>
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

        <div class="container-fluid">
            <h1 class="text-center">Listado De Bodegas</h1>

            <a class="btn bg-success btn-lg" href="ControladorBodega?accion=add">Agregar Nuevo</a>

            <table class=" table table-hover table-bordered border-dark ">
                <thead class="bg-dark text-light">
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Codigo</th>
                        <th class="text-center">Producto</th>
                        <th class="text-center">Cantidad</th>                       
                        <th class="text-center">Opciones</th>
                    </tr>
                </thead>

                <%
                    String usuario = request.getParameter("nombre");
                    BodegaDAO dao = new BodegaDAO();
                    List<Bodega> list = dao.listar();
                    Iterator<Bodega> iterBodega= list.iterator();
                    Bodega bodega = null;
                    while (iterBodega.hasNext()) {
                     bodega = iterBodega.next();
                     

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= bodega.getIdBodega()%></td>
                        <td class="text-center"><%= bodega.getCodigoBodega()%></td>
                        <td class="text-center"><%=bodega.getNombreProducto()%></td>
                        <td class="text-center"><%= bodega.getCantidadBodega()%></td>
                        
                        <td class="text-center">
                            <a href="ControladorBodega?accion=editar&id=<%= bodega.getIdBodega()%>" class="btn btn-warning ">Editar</a>
                            <a href="ControladorBodega?accion=eliminar&id=<%=bodega.getIdBodega()%>" class="btn btn-danger ">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
