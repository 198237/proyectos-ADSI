<%-- 
    Document   : edit
    Created on : 4/08/2020, 04:02:31 PM
    Author     : Estiven
--%>
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/Personalizado/new.css" rel="stylesheet" type="text/css"/>
<%@page import="Modelo.Proveedor"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDao.ProveedorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Proveedor</title>
    </head>
    <body>
        <div class="container col-lg-6">
            
            <%
            ProveedorDAO dao = new ProveedorDAO();
            int id = Integer.parseInt((String)request.getAttribute("idProveedor"));
            Proveedor proveedor = dao.list(id);
            
            %>
            <h1 class="text-center">Editar Proveedor</h1>
            
            <form action="ControladorProveedor">
                <div class="form-group">
                    <center>
                       <label>Nombre</label>  
                    </center>
                   
                    <input class="form-control" class="form-control" type="text" name="txtNombreProveedor" value="<%= proveedor.getNombreProveedor()%>" required>
                    <input type="hidden" name="txtIdProveedor" value="<%= proveedor.getIdProveedor()%>">
                </div>
                <div class="form-group">
                    <center>
                        <label>RUT</label>
                    </center>
                    
                    <input class="form-control" type="text" name="txtRUTProveedor" value="<%= proveedor.getRUTProveedor()%>" required>
                </div>
                <div class="form-group">
                    <center>
                         <label>Telefono</label>
                    </center>
                   
                    <input type="text" class=" form-control" name="txtTelefonoProveedor" value="<%= proveedor.getTelefonoProveedor()%>" required>
                </div>
                <div class="form-group">
                    <center>
                       <label>Direccion</label> 
                    </center>
                    
                    <input type="text" class="form-control" class="form-control" name="txtDireccionProveedor" value="<%= proveedor.getDireccionProveedor()%>" required>
                </div>
                <br>
                <center>
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-warning btn-lg">
                </center>
            </form>
                <a href="ControladorProveedor?accion=listar" class="btn btn-info">Regresar</a>
        </div>
    </body>
</html>
