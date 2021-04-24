<%-- 
    Document   : listar
    Created on : 4/08/2020, 04:02:44 PM
    Author     : Estiven
--%>
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Proveedor"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDao.ProveedorDAO"%>
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
            <h1 class="text-center">Listado de Proveedores</h1>

            <a class="btn bg-success btn-lg" href="ControladorProveedor?accion=add">Agregar Nuevo</a>

            <table class=" table table-hover table-bordered ">
                <thead class="bg-dark text-light">
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">RUT</th>
                        <th class="text-center">Telefono</th>
                        <th class="text-center">Direccion</th>
                        <th class="text-center">Opciones</th>
                    </tr>
                </thead>

                <%
                    ProveedorDAO dao = new ProveedorDAO();
                    List<Proveedor> list = dao.listar();
                    Iterator<Proveedor> iterProveedor = list.iterator();
                    Proveedor proveedor = null;
                    while (iterProveedor.hasNext()) {
                        proveedor = iterProveedor.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= proveedor.getIdProveedor()%></td>
                        <td class="text-center"><%= proveedor.getNombreProveedor()%></td>
                        <td class="text-center"><%= proveedor.getRUTProveedor()%></td>
                        <td class="text-center"><%= proveedor.getTelefonoProveedor()%></td>
                        <td class="text-center"><%= proveedor.getDireccionProveedor()%> </td>
                        <td class="text-center">
                            <a href="ControladorProveedor?accion=editar&id=<%= proveedor.getIdProveedor()%>" class="btn btn-warning ">Editar</a>
                            <a href="ControladorProveedor?accion=eliminar&id=<%= proveedor.getIdProveedor()%>" class="btn btn-danger ">Eliminar</a>
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

