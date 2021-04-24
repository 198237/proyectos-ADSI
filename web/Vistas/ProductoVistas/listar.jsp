<%-- 
    Document   : listar
    Created on : 8/08/2020, 11:26:34 AM
    Author     : Estiven
--%>
<%@page import="ModeloDao.TipoDAO"%>
<%@page import="Modelo.Tipo"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Producto"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDao.ProductoDAO"%>
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/Personalizado/new.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>list producto</title>
    </head>
    <body>
         <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-toggler" href="./Principal.jsp"><span class="navbar-toggler-icon"></span>Home</a>
            
            <div class="dropdown">
                <a href="./index.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: wheat">Cerrar Sesion</a>
  
            </div>
        </nav>
         
        <div class="container-fluid">
            <h1 class="text-center">Listado De Productos</h1>

            <a class="btn bg-success btn-lg" href="ControladorProducto?accion=add">Agregar Nuevo</a>

            <table class=" table table-hover table-bordered border-dark">
                <thead class="bg-dark text-light">
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Peso gr.</th>
                        <th class="text-center">Proveedor</th>
                         <th class="text-center">Tipo</th>
                        <th class="text-center">Precio</th>
                        <th class="text-center">Opciones</th>
                    </tr>
                </thead>

                <%
                    ProductoDAO dao = new ProductoDAO();
                    List<Producto> list = dao.listar();
                    Iterator<Producto> iterProducto = list.iterator();
                    Producto producto = null;
                    while (iterProducto.hasNext()) {
                     producto = iterProducto.next();
                     

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= producto.getIdProducto()%></td>
                        <td class="text-center"><%= producto.getNombreProducto()%></td>
                        <td class="text-center"><%= producto.getPesoProducto()%></td>
                        <td class="text-center"><%= producto.getNombreProveedor()%></td>
                         <td class="text-center"><%= producto.getNombreTipo()%></td>
                        <td class="text-center"><%= producto.getPrecioProducto()%></td>
                        <td class="text-center">
                            <a href="ControladorProducto?accion=editar&id=<%= producto.getIdProducto()%>" class="btn btn-warning ">Editar</a>
                            <a href="ControladorProducto?accion=eliminar&id=<%= producto.getIdProducto()%>" class="btn btn-danger ">Eliminar</a>
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
</html>
