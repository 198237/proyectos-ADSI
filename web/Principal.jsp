<%-- 
    Document   : Principal
    Created on : 3/08/2020, 11:14:20 AM
    Author     : Estiven
--%>
<link href="Bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="Bootstrap/Personalizado/principal.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
    </head>
    <body>

        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-toggler"><span class="navbar-toggler-icon"></span>Home</a>


            <div class="dropdown" >
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: wheat">Cerrar Sesion</a>

                <div class="dropdown-menu text-center">
                    <a><img src="img/user-avatar-red-icon-vector-8825308.jpg" height="80" width="80" id="iconor" ></a><br>
                    <a>${nombre}</a>
                    <a>${correo}</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item "  href="UserController?accion=salir">Salir</a>
                </div>

            </div>
        </nav>
        <br>
        <h1 class="text-center">Bienvenida(o) ${nombre}</a></h1>
    <br>
    <%
        HttpSession unaSession = request.getSession();
        Object rol = unaSession.getAttribute("idRol");
        String id = rol.toString();
        int idRol = Integer.parseInt(id);
        if (idRol == 2) {
    %>
    <div class="container-lg w-auto  hiperro">
        <a href="ControladorProveedor?accion=listar" class="btn btn-danger btn-lg">Proveedor</a>
        <a href="ControladorProducto?accion=listar" class="btn btn-danger btn-lg">Producto</a>
        <a href="ControladorTipo?accion=listar" class="btn btn-danger btn-lg">Tipo</a>
        <a href="ControladorPedido?accion=listar" class="btn btn-danger btn-lg">Pedido</a>
        <a href="ControladorBodega?accion=listar" class="btn btn-danger btn-lg">Bodega</a>

    </div>
    <%
    } else if (idRol == 1) {
    %>

    
    <div class="container-lg w-auto  hiperro">
        <a href="ControladorProveedor?accion=listar" class="btn btn-danger btn-lg">Proveedor</a>
        <a href="ControladorProducto?accion=listar" class="btn btn-danger btn-lg">Producto</a>
        <a href="ControladorTipo?accion=listar" class="btn btn-danger btn-lg">Tipo</a>
        <a href="ControladorPedido?accion=listar" class="btn btn-danger btn-lg">Pedido</a>
        <a href="ControladorBodega?accion=listar" class="btn btn-danger btn-lg">Bodega</a>
        <a href="ControladorEmpleado?accion=listar" class="btn btn-danger btn-lg">Empleado</a>
        <a href="ControladorAuditoria?accion=listar" class="btn btn-danger btn-lg">Auditoria</a>
        <a href="UserController?accion=listar" class="btn btn-danger btn-lg">Usuarios</a>
        <a href="UserController?accion=agregarUsuario" class="btn btn-danger btn-lg">
            Añadir Usuario
        </a>
    </div>

    <%
    } else if (idRol == 3) {
    %>

    <div class="container divider bd-dark" style="background-color: #000">

        <div id="demo" class="carousel slide" data-ride="carousel">
            <!-- Indicators --> 
            <ul class="carousel-indicators"> 
                <li data-target="#demo" data-slide-to="0" class="active"></li>   
                <li data-target="#demo" data-slide-to="1"></li>
                <li data-target="#demo" data-slide-to="2"></li> 
            </ul> 
            <!-- The slideshow -->
            <div class="carousel-inner">

                <div class="carousel-item active">  
                    <img src="img/category-3.jpg" alt="Los Angeles">
                    <div class="carousel-caption bg-gradient">
                        <h1>El Sabor De Mi Campo</h1>
                        <h3>tenemos los mejores productos para ti!</h3>
                        <a href="UserController?accion=verProductos" class="btn btn-sm">Ver</a>
                    </div>
                </div>   

                <div class="carousel-item ">
                    <img src="img/category-2.jpg" alt="Chicago"> 
                     <div class="carousel-caption bg-gradient">
                        <h1>El Sabor De Mi Campo</h1>
                        <h3>tenemos los mejores productos para ti!</h3>
                        <a href="UserController?accion=verProductos" class="btn btn-sm">Ver</a>
                    </div>
                </div>  

                <div class="carousel-item">   
                    <img src="img/durazno.jpg" alt="New York"> 
                     <div class="carousel-caption bg-gradient">
                        <h1>El Sabor De Mi Campo</h1>
                        <h3>tenemos los mejores productos para ti!</h3>
                        <a href="UserController?accion=verProductos" class="btn btn-sm ">Ver</a>
                    </div>
                </div> 

            </div> 
            <!-- Left and right controls --> 
            <a class="carousel-control-prev" href="#demo" data-slide="prev"> 
                <span class="carousel-control-prev-icon"></span> 
            </a> 
            <a class="carousel-control-next" href="#demo" data-slide="next"> 
                <span class="carousel-control-next-icon">

                </span> 
            </a>
        </div>
    </div>
    <%
        }
    %>
    <script src="Bootstrap/js/popper.min.js" type="text/javascript"></script>
    <script src="Bootstrap/js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="Bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

</body>

</html>
