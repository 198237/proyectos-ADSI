<%-- 
    Document   : add
    Created on : 8/08/2020, 11:26:19 AM
    Author     : Estiven
--%>
<%@page import="Modelo.Proveedor"%>
<%@page import="Modelo.Tipo"%>
<%@page import="java.util.List"%>
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/Personalizado/new.css" rel="stylesheet" type="text/css"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-toggler" href="./Principal.jsp"><span class="navbar-toggler-icon"></span>Home</a>

            <div class="dropdown">
                <a href="./index.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: wheat">Cerrar Sesion</a>

            </div>
        </nav>
        <h1 class="text-break text-center">Agregar Nuevo Producto</h1>
        <div class="container col-lg-6">

            <form action="ControladorProducto" >
                <div class="form-group">
                    <center>
                        <label>Nombre</label>
                    </center>
                    <input name="txtNombreProducto" type="text" class="form-control" required>
                </div>
                <div class="form-group">
                    <center>
                        <label>Peso</label>
                    </center>
                    <input  class="form-control" name="txtPesoProducto" type="number" required>
                </div>
                <div class="form-group">
                    <center>
                        <label for="cboProveedor">
                            Proveedor
                        </label>
                    </center>
                    <select id="cboProveedor" name="cboProveedorProducto" class="form-control" required>
                        <%List<Proveedor> listaProveedorProducto = (List<Proveedor>) request.getAttribute("proveedorProducto");
                            if (listaProveedorProducto != null)
                                for (Proveedor proveedor : listaProveedorProducto) {%>
                        <option value="<%= proveedor.getIdProveedor()%>"><%=proveedor.getNombreProveedor()%></option>
                        <%}%>

                    </select>
                </div>
                <div class="form-group">
                    <center>
                        <label for="cboTipoProducto">
                            Tipo
                        </label>
                    </center>
                    <select id="cboTipoProducto" name="cboTipoProducto" class="form-control" required>
                        <%List<Tipo> listaTipoProducto = (List<Tipo>) request.getAttribute("tipoProducto");
                            if (listaTipoProducto != null)
                                for (Tipo tipo : listaTipoProducto) {%>
                        <option value="<%= tipo.getIdTipo()%>"><%=tipo.getDescripcionTipo()%></option>
                        <%}%>

                    </select>
                </div>

                <div class="form-group">
                    <center>
                        <label>Precio</label>
                    </center>
                    <input name="txtPrecioProducto" type="text" class="form-control" required>
                </div>
                <br>
                <center> <input type="submit" name="accion" value="Agregar" class="btn btn-lg btn-success"></center>
            </form>
        </div>
        <div class="container-fluid">
            <a href="ControladorProducto?accion=listar" class="btn btn-sm btn-info">Regresar</a>
        </div>
    </body>
</html>
