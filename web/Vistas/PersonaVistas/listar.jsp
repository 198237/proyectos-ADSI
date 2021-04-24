

<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDao.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container ">
            <div class=" ">
                <h1 class="text-center">
                Listado de personas
            </h1>
            <a href="ControladorPersona?accion=add" class="btn btn-success">Agregar Nuevo</a>
            <div>
                <br>
            </div>
            <table class="table table-hover table-bordered border-dark ">
                <thead class="thead-dark bg-dark text-light">
                    <tr>
                        <th class="text-center">Id</th>
                        <th class="text-center">DNI</th>
                        <th class="text-center">Nombres</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <%
                PersonaDAO dao = new PersonaDAO();
                List<Persona>list = dao.listar();
                Iterator<Persona> iterator = list.iterator();
                Persona persona = null;
                while (iterator.hasNext()) {                        
                       persona = iterator.next();
                       persona.getIdPersona();
                       persona.getDniPersona();
                       persona.getNombrePersona();
                   
                %>
                <tbody>
                    <tr>
                        <td><%= persona.getIdPersona()%></td>
                        <td><%= persona.getDniPersona()%></td>
                        <td><%= persona.getNombrePersona()%></td>
                        <td class="text-center">
                            
                            <a href="ControladorPersona?accion=editar&idPersona=<%= persona.getIdPersona()%>" class="btn btn-info">Editar</a>
                            <a href="ControladorPersona?accion=eliminar&idPersona=<%= persona.getIdPersona()%>" class="btn btn-danger">Eliminar</a>
                        </td>
                    </tr>
                    
                    <%}%>
                </tbody>
            </table>
            </div>

        </div>
    </body>
</html>
