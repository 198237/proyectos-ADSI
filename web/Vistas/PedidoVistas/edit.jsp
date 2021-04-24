<%-- 
    Document   : editPedido
    Created on : 9/08/2020, 07:03:51 PM
    Author     : Estiven
--%>
<%@page import="Modelo.Pedido"%>
<%@page import="ModeloDao.PedidoDAO"%>
<%@page import="Modelo.Producto"%>
<%@page import="Modelo.Proveedor"%>
<%@page import="Modelo.Proveedor"%>
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
        <h1 class="text-break text-center">Actualizar Pedido</h1>
        <div class="container col-lg-6">

            <%
                PedidoDAO dao = new PedidoDAO();
                int id = Integer.parseInt((String) request.getAttribute("idPedido"));
                Pedido pedido = dao.list(id);
            %>
            <form action="ControladorPedido" >
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

                <div class="form-group">
                    <center>
                        <label>Observacion</label>
                    </center>
                    <input name="txtIdPedido" type="hidden" value="<%=pedido.getIdPedido()%>">
                    <input name="txtObservacion" type="text" class="form-control" value="<%=pedido.getObservacionPedido()%>">
                </div>
                <br>
                <center> <input type="submit" name="accion" value="Actualizar" class="btn btn-lg btn-success"></center>
            </form>
        </div>
        <div class="container-fluid">
            <a href="ControladorProducto?accion=listar" class="btn btn-sm btn-info">Regresar</a>
        </div>
    </body>
</html>
