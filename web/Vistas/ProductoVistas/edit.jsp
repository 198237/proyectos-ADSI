<%-- 
    Document   : edit
    Created on : 8/08/2020, 11:26:47 AM
    Author     : Estiven
--%>
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDao.ProductoDAO"%>
<%@page import="Modelo.Tipo"%>
<%@page import="Modelo.Proveedor"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/Personalizado/new.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-toggler" href="./Principal.jsp"><span class="navbar-toggler-icon"></span>Home</a>

            <div class="dropdown">
                <a href="./index.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: wheat">Cerrar Sesion</a>

            </div>
        </nav>
        <h1 class="text-break text-center">Actualizar Producto</h1>
        <div class="container col-lg-6">
            <%
            ProductoDAO dao = new ProductoDAO();
            int id = Integer.parseInt((String)request.getAttribute("idProducto"));
            Producto producto = dao.list(id);
            
            %>
            <form action="ControladorProducto" >
                <div class="form-group">
                    <center>
                        <label>Nombre</label>
                    </center>
                    <input name="txtNombreProducto" type="text" class="form-control" value="<%=producto.getNombreProducto()%>">
                    <input type="hidden" name="txtIdProducto" value="<%=producto.getIdProducto()%>">
                </div>
                <div class="form-group">
                    <center>
                        <label>Peso</label>
                    </center>
                    <input  class="form-control" name="txtPesoProducto" type="number" value="<%=producto.getPesoProducto()%>">
                </div>
                <div class="form-group">
                     <center>
                    <label for="cboProveedor">
                       Proveedor
                    </label>
                     </center>
                    <select id="cboProveedor" name="cboProveedorProducto" class="form-control">
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
                    <select id="cboTipoProducto" name="cboTipoProducto" class="form-control">
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
                            <input name="txtPrecioProducto" type="number" class="form-control" value="<%=producto.getPrecioProducto()%>">
                </div>
                        <br>
                <center> <input type="submit" name="accion" value="Actualizar" class="btn btn-lg btn-success"></center>
            </form>
                <a href="ControladorProducto?accion=listar" class="btn btn-success btn-sm" role="button">Regresar</a>
        </div>
    </body>
</html>
