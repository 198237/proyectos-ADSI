<%-- 
    Document   : listarPedido
    Created on : 9/08/2020, 07:04:03 PM
    Author     : Estiven
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDao.PedidoDAO"%>
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/Personalizado/new.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-toggler" href="./Principal.jsp"><span class="navbar-toggler-icon"></span>Home</a>
            
            <div class="dropdown">
                <a href="./index.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: wheat">Cerrar Sesion</a>
  
            </div>
        </nav>

        <div class="container-fluid">
            <h1 class="text-center">Listado De Pedidos</h1>

            <a class="btn bg-success btn-lg" href="ControladorPedido?accion=add">Agregar Nuevo</a>

            <table class=" table table-hover table-bordered border-dark ">
                <thead class="bg-dark text-light">
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Proveedor</th>
                        <th class="text-center">Producto</th>
                        <th class="text-center">Fecha</th>
                         <th class="text-center">Observacion</th>
                        
                        <th class="text-center">Opciones</th>
                    </tr>
                </thead>

                <%
                    PedidoDAO dao = new PedidoDAO();
                    List<Pedido> list = dao.listar();
                    Iterator<Pedido> iterPedido= list.iterator();
                    Pedido pedido = null;
                    while (iterPedido.hasNext()) {
                     pedido = iterPedido.next();
                     

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= pedido.getIdPedido()%></td>
                        <td class="text-center"><%= pedido.getNombreProveedor()%></td>
                        <td class="text-center"><%= pedido.getNombreProducto()%></td>
                        <td class="text-center"><%= pedido.getFechaPedido()%></td>
                         <td class="text-center"><%= pedido.getObservacionPedido()%></td>
                        
                        <td class="text-center">
                            <a href="ControladorPedido?accion=editar&id=<%= pedido.getIdPedido()%>" class="btn btn-warning ">Editar</a>
                            <a href="ControladorPedido?accion=eliminar&id=<%= pedido.getIdPedido()%>" class="btn btn-danger ">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
