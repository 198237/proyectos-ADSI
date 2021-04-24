<%-- 
    Document   : edit
    Created on : 2/08/2020, 05:03:59 PM
    Author     : Estiven
--%>

<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>


<%@page import="Modelo.Persona"%>
<%@page import="ModeloDao.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar</title>
    </head>
    <body>

        <div  class="container ">

            <center> 
                <div class="col-6">
                    <%
                        PersonaDAO dao = new PersonaDAO();
                        int id = Integer.parseInt((String) request.getAttribute("idPer"));
                        Persona persona = (Persona) dao.list(id);


                    %>
                    <h1 class="text-center">Modificar Persona</h1>

                    <form action="ControladorPersona" class="border border-dark">

                        <div class="form-group ">

                            <center>
                                <label>Ingrese Su DNI</lavel>      
                            </center>
                            <input class="form-control  col-sm-8" type="text" name="txtDNIPersona" value="<%= persona.getDniPersona()%>"><br>

                        </div>

                        <div class="form-group">
                            <center>
                                <label>Ingrese Su Nombre</lavel>      
                            </center>
                            <input type="text" name="txtNombrePersona" value="<%= persona.getNombrePersona()%>" class="form-control col-md-6" required>
                            <input type="hidden" name="txtIdPersona"  value="<%= persona.getIdPersona()%>">
                        </div>
                        <br> 
                        <center>

                            <input  type="submit" name="accion" value="Actualizar" class="btn btn-warning btn-lg"><br> 

                        </center>



                    </form>
                </div>
            </center> 
            <a href="ControladorPersona?accion=listar" class="btn btn-info btn-sm  shadow">Regresar<a/>
        </div>

    </body>
</html>
