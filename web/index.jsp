<%-- 
    Document   : index
    Created on : 17/08/2020, 08:28:07 PM
    Author     : Estiven
--%>
<link href="Bootstrap/Personalizado/styles.css" rel="stylesheet" type="text/css"/>
<link href="Bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>index</title>
        <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/Personalizado/styles.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/Personalizado/otro.css" rel="stylesheet" type="text/css"/>
        

    </head>
    <body>
        <header>
             <!-- Esto es otra cosa-->
        <div class="container bg-info text-dark">
            <div>Bievenido</div> 
            <div> 
                <span>El Sabor de mi campo</span>
            </div>
        </div>
        </header>
        
        <nav>
            <ul>

                <li><a href="UserController?accion=loguearse" class="btn"><span style="font-size: 230%;">Login</span></a></li>
                <li><a href="UserController?accion=registrarse" class="btn"><span style="font-size: 230%;">Registro</span></a></li>
                <li><span>Nosotros</span></li>

            </ul>
        </nav>

        <canvas>

        </canvas>
       

    </body>

</html>
