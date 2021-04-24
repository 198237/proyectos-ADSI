<%-- 
    Document   : listar
    Created on : 10/08/2020, 09:11:23 PM
    Author     : Estiven
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDao.EmpleadoDAO"%>
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listar Empleados</title>
    </head>
    <body>
         <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-toggler" href="./Principal.jsp"><span class="navbar-toggler-icon"></span>Home</a>
            
            <div class="dropdown">
                <a href="./index.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: wheat">Cerrar Sesion</a>
  
            </div>
        </nav>

        <div class="container-fluid">
            <h1 class="text-center">Listado de Empleados</h1>

            <a class="btn bg-success btn-lg" href="ControladorEmpleado?accion=add">Agregar Nuevo</a>

            <table class=" table table-hover table-bordered ">
                <thead class="bg-dark text-light">
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Apellido</th>
                        <th class="text-center">Edad</th>
                        <th class="text-center">Salario</th>
                         <th class="text-center">Correo</th>
                        <th class="text-center">Opciones</th>
                    </tr>
                </thead>

                <%
                   EmpleadoDAO dao = new EmpleadoDAO();
                    List<Empleado> list = dao.listar();
                    Iterator<Empleado> iterProveedor = list.iterator();
                    Empleado empleado = null;
                    while (iterProveedor.hasNext()) {
                        empleado = iterProveedor.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= empleado.getIdEmpleado()%></td>
                        <td class="text-center"><%= empleado.getNombreEmpleado()%></td>
                        <td class="text-center"><%= empleado.getApellidoEmpleado()%></td>
                        <td class="text-center"><%= empleado.getEdadEmpleado()%></td>
                        <td class="text-center"><%= empleado.getSalarioEmpleado()%></td>
                        <td class="text-center"><%= empleado.getCorreoEmpleado()%> </td>
                        <td class="text-center">
                            <a href="ControladorEmpleado?accion=editar&id=<%= empleado.getIdEmpleado()%>" class="btn btn-warning ">Editar</a>
                            <a href="ControladorEmpleado?accion=eliminar&id=<%= empleado.getIdEmpleado()%>" class="btn btn-danger ">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
