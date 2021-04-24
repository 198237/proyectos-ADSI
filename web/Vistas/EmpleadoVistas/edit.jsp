<%-- 
    Document   : edit
    Created on : 10/08/2020, 09:11:14 PM
    Author     : Estiven
--%>
<%@page import="Modelo.Empleado"%>
<%@page import="ModeloDao.EmpleadoDAO"%>
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/Personalizado/new.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Empleado</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-toggler" href="./Principal.jsp"><span class="navbar-toggler-icon"></span>Home</a>
            
            <div class="dropdown">
                <a href="./index.jsp" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: wheat">Cerrar Sesion</a>
  
            </div>
        </nav>
        <h1 class="text-center">Actualizar Empleado</h1>
        <div class="container col-lg-6">
            <%
            EmpleadoDAO dao = new EmpleadoDAO();
            int id = Integer.parseInt((String)request.getAttribute("idEmpleado"));
            Empleado empleado = dao.list(id);
            %>
            <form action="ControladorEmpleado" class="">
                <div class="form-group">
                     <center>
                         <label class="text-center">Nombres</label>
                    </center>
                   
                    <input type="text" name="txtNombreEmpleado" value="<%=empleado.getNombreEmpleado()%>" class="form-control" required>
                    <input name="txtIdEmpleado" value="<%=empleado.getIdEmpleado()%>" type="hidden">
                </div>
                <br>
                <div class="form-group">
                    <center>
                    <label class="text-center">Apellidos</label>
                    </center>
                    <input type="text" name="txtApellidoEmpleado" value="<%=empleado.getApellidoEmpleado()%>" class="form-control" required>
                </div >
                <br>
                <div class="form-group">
                     <center>
                        <label class="text-center">Edad</label>
                    </center>
                    
                    <input type="text" name="txtEdadEmpleado" value="<%=empleado.getEdadEmpleado()%>" class="form-control" required>
                </div>
                <br>
                <div class="form-group">
                     <center>
                        <label class="text-center">Salario</label>
                    </center>
                    
                    <input type="number" name="txtSalarioEmpleado" value="<%=empleado.getSalarioEmpleado()%>" class="form-control col-1" required placeholder="Solo números">
                </div>
                <br>
                 <div class="form-group">
                     <center>
                        <label class="text-center">Correo</label>
                    </center>
                    
                     <input type="email" name="txtCorreoEmpleado" value="<%=empleado.getCorreoEmpleado()%>" class="form-control col-1" required >
                </div>
                <br>
                <input type="submit" name="accion" value="Actualizar" class="btn btn-lg btn-warning btn-block">
            </form>
        </div>
         <a href="ControladorEmpleado?accion=listar" class="btn btn-info">Regresar</a>
    </body>
</html>
