<%-- 
    Document   : add
    Created on : 10/08/2020, 06:19:27 PM
    Author     : Estiven
--%>
<%@page import="Modelo.Producto"%>
<%@page import="java.util.List"%>
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
        <h1 class="text-break text-center">Agregar Productos A Bodega</h1>
        <div class="container col-lg-6">

            <form action="ControladorBodega" >

                <div class="form-group">
                    <center>
                        <label>Codigo</label>
                    </center>
                    <input name="txtCodigoBodega" type="text" class="form-control">
                </div>
                <br>
                <div class="form-group">
                    <center>
                        <label for="cboElProducto">
                            Producto
                        </label>
                    </center>
                    <select id="cboElProducto" name="cboProducto" class="form-control">
                        <%List<Producto> listaProducto = (List<Producto>) request.getAttribute("productoPedido");
                            if (listaProducto != null)
                                for (Producto producto : listaProducto) {%>
                        <option value="<%= producto.getIdProducto()%>"><%=producto.getNombreProducto()%></option>
                        <%}%>

                    </select>
                </div>
                <br>
                <div class="form-group">
                    <center>
                        <label>Cantidad</label>
                    </center>
                    <input name="txtCantidadBodega" type="number" class="form-control" required placeholder="Solo números">
                </div>
                <br>
                <center> <input type="submit" name="accion" value="Agregar" class="btn btn-lg btn-success"></center>
            </form>
        </div>
        <div class="container-fluid">
            <a href="ControladorBodega?accion=listar" class="btn btn-sm btn-info">Regresar</a>
        </div>
    </body>
</html>
