<%-- 
    Document   : listar
    Created on : 21/08/2020, 02:58:14 PM
    Author     : Estiven
--%>
<link href="./Bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDao.UsuarioDAO"%>
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
            <h1 class="text-center">Listado de Usuario</h1>

            <a class="btn bg-success btn-lg" href="UserController?accion=agregarUsuario">Agregar Nuevo</a>

            <table class=" table table-hover table-bordered ">
                <thead class="bg-dark text-light">
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Correo</th>
                        <th class="text-center">Cargo</th>
                        <th class="text-center">Opciones</th>
                    </tr>
                </thead>

                <%
                    UsuarioDAO dao = new UsuarioDAO();
                    List<Usuario> list = dao.listar();
                    Iterator<Usuario> iterUsuario = list.iterator();
                    Usuario usuario = null;
                    while (iterUsuario.hasNext()) {
                        usuario = iterUsuario.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= usuario.getIdUsuario()%></td>
                        <td class="text-center"><%= usuario.getNombreUsuario()%></td>
                        <td class="text-center"><%= usuario.getCorreoUsuario()%></td>
                        <td class="text-center"><%= usuario.getNombreRol()%></td>
                        <td class="text-center">
                            <%
                                if (usuario.getRol_idRol() == 1) {
                            %> 
                            <h4>No puedes Eliminar</h4>
                            <%
                            } else {
                            %>
                            <a href="UserController?accion=eliminar&id=<%= usuario.getIdUsuario()%>" class="btn btn-danger ">Eliminar</a>
                            <%}%>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
