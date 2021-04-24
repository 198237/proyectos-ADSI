
<link href="./Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./Bootstrap/css/styles.css" rel="stylesheet" type="text/css"/>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar</title>
    </head>
    <body>
        <div class="container bg-light ">

            <center>

                <div class="col-lg-3">

                    <h1 class="text-center ">Agregar Persona</h1>
                    <br>

                    <form action="ControladorPersona" class="border border-dark">

                        <div class="form-group">
                            <center>
                                <label from="dni" class=" text-center">DNI</label>
                            </center>
                            <input type="text" name="txtDNIPersona" class="form-control" id="dni" required><br>
                        </div>
                        <center>
                            <label from="nombre" class=" text-center">Nombres</label>
                        </center>
                        <input type="text" name="txtNombrePersona" id="nombre" class="form-control col-md-9 " required>
                        <br> 
                        <div>
                            <center> 
                                <input  type="submit" name="accion" value="Agregar" class="btn btn-success btn-lg">
                            </center>
                        </div>
                        
                    </form>

            </center>
            <a href="ControladorPersona?accion=listar" class="btn btn-info btn-sm  shadow">Regresar<a/>
        </div>
    </div>
</body>
</html>
