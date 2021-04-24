<%-- 
    Document   : listar
    Created on : 12/08/2020, 03:19:10 PM
    Author     : Estiven
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Auditoria"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDao.AuditoriaDAO"%>
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auditoria</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-toggler" href="./Principal.jsp"><span class="navbar-toggler-icon"></span>Home</a>

            <div class="dropdown">
                <a href="./index.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: wheat">Cerrar Sesion</a>

            </div>
        </nav>

        <div class="container-fluid">
            <h1 class="text-center">Auditoria</h1>

           

            <table class=" table table-hover border-dark table-bordered ">
                <thead class="bg-dark text-light border">
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Usuario</th>
                        <th class="text-center">Descripcion</th>
                        <th class="text-center">Fecha</th>
                       
                    </tr>
                </thead>

                <%
                    AuditoriaDAO hola = new AuditoriaDAO();
                    List<Auditoria> list = hola.listar();
                    Iterator<Auditoria> iterAuditoria = list.iterator();
                    Auditoria auditoria = null;
                    while (iterAuditoria.hasNext()) {                            
                            auditoria = iterAuditoria.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= auditoria.getIdAuditoria()%></td>
                        <td class="text-center"><%= auditoria.getUsuarioAuditoria()%></td>
                        <td class="text-center"><%= auditoria.getDescripcionAuditoria()%></td>
                        <td class="text-center"><%= auditoria.getFechaAuditoria()%></td>
                   
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
