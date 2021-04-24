-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-08-2020 a las 01:48:30
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `copia_proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditoria`
--

CREATE TABLE `auditoria` (
  `idAuditoria` int(11) NOT NULL,
  `usuarioAuditoria` varchar(45) NOT NULL,
  `descripcionAuditoria` varchar(45) NOT NULL,
  `fechaAuditoria` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `auditoria`
--

INSERT INTO `auditoria` (`idAuditoria`, `usuarioAuditoria`, `descripcionAuditoria`, `fechaAuditoria`) VALUES
(1, 'Felipe', 'Ingresó al sistema', '2020-08-23 23:34:54'),
(2, 'Felipe', 'Insertó Producto', '2020-08-23 23:35:23'),
(3, 'Felipe', 'Editó Producto', '2020-08-23 23:35:35'),
(4, 'Felipe', 'Editó Tipo', '2020-08-23 23:35:53'),
(5, 'Felipe', 'Editó Tipo', '2020-08-23 23:35:58'),
(6, 'Felipe', 'Insertó Tipo', '2020-08-23 23:36:20'),
(7, 'Felipe', 'Editó Producto', '2020-08-23 23:36:35'),
(8, 'Felipe', 'Editó Producto', '2020-08-23 23:36:42'),
(9, 'Felipe', 'Editó Producto', '2020-08-23 23:36:51'),
(10, 'Felipe', 'Editó Producto', '2020-08-23 23:37:12'),
(11, 'Felipe', 'Editó Producto', '2020-08-23 23:37:24'),
(12, 'Felipe', 'Editó Producto', '2020-08-23 23:37:35'),
(13, 'Felipe', 'Insertó Producto', '2020-08-23 23:38:04'),
(14, 'Felipe', 'Insertó Pedido', '2020-08-23 23:38:33'),
(15, 'Felipe', 'Insertó En Bodgea', '2020-08-23 23:38:54');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bodega`
--

CREATE TABLE `bodega` (
  `idBodega` int(11) NOT NULL,
  `codigoBodega` varchar(45) DEFAULT NULL,
  `idProductoBodega` int(11) NOT NULL,
  `cantidadBodega` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `bodega`
--

INSERT INTO `bodega` (`idBodega`, `codigoBodega`, `idProductoBodega`, `cantidadBodega`) VALUES
(1, '12A', 1, 3456),
(2, '23A', 7, 3000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombreCliente` varchar(45) DEFAULT NULL,
  `documentoCliente` varchar(45) DEFAULT NULL,
  `direccionCliente` varchar(45) DEFAULT NULL,
  `celularCliente` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL,
  `idClienteCompra` int(11) NOT NULL,
  `idProductoCompra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `nombreEmpleado` varchar(45) NOT NULL,
  `apellidoEmpleado` varchar(45) DEFAULT NULL,
  `edadEmpledo` varchar(45) NOT NULL,
  `salarioEmpleado` int(11) NOT NULL,
  `correoEmpleado` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idEmpleado`, `nombreEmpleado`, `apellidoEmpleado`, `edadEmpledo`, `salarioEmpleado`, `correoEmpleado`) VALUES
(1, 'Juan Alberto', 'Andropocio', '45', 1500000, 'andro@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL,
  `idProveedorPedido` int(11) NOT NULL,
  `idProductoPedido` int(11) NOT NULL,
  `fechaPedido` timestamp NULL DEFAULT current_timestamp(),
  `observacionPedido` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`idPedido`, `idProveedorPedido`, `idProductoPedido`, `fechaPedido`, `observacionPedido`) VALUES
(1, 1, 1, '2020-08-18 23:44:21', 'eee'),
(2, 1, 5, '2020-08-23 23:38:33', '--');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(45) NOT NULL,
  `pesoProducto` int(11) NOT NULL,
  `idProveedor_Producto` int(11) NOT NULL,
  `idTipo_Producto` int(11) NOT NULL,
  `precioProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `pesoProducto`, `idProveedor_Producto`, `idTipo_Producto`, `precioProducto`) VALUES
(1, 'Lenteja', 2323, 1, 3, 3000),
(3, 'Tomate', 4000, 1, 2, 4000),
(4, 'Garbanzo', 2000, 1, 3, 2000),
(5, 'Papa', 25000, 1, 2, 13000),
(6, 'Cebolla', 1000, 1, 2, 1000),
(7, 'Banano', 0, 1, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `nombreProveedor` varchar(45) NOT NULL,
  `RUTProveedor` varchar(45) NOT NULL,
  `telefonoProveedor` varchar(45) NOT NULL,
  `direccionProveedor` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `nombreProveedor`, `RUTProveedor`, `telefonoProveedor`, `direccionProveedor`) VALUES
(1, 'Carlos Simisterra', '23', '232323232323', 'VÃ©lez - Santander');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL,
  `nombreRol` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nombreRol`) VALUES
(1, 'Administrador'),
(2, 'Empleado'),
(3, 'Cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `idTipo` int(11) NOT NULL,
  `descripcionTipo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`idTipo`, `descripcionTipo`) VALUES
(1, 'Fruta'),
(2, 'Verdura'),
(3, 'Empaquetado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usario`
--

CREATE TABLE `usario` (
  `idUsuario` int(11) NOT NULL,
  `nombreUsuario` varchar(45) DEFAULT NULL,
  `correoUsuario` varchar(45) DEFAULT NULL,
  `contrasena` varchar(45) DEFAULT NULL,
  `rol_idRol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usario`
--

INSERT INTO `usario` (`idUsuario`, `nombreUsuario`, `correoUsuario`, `contrasena`, `rol_idRol`) VALUES
(4, 'Dayana', 'dayana@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 2),
(6, 'Carlos', 'Carlos@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 3),
(7, 'Felipe', 'duvanfelipe@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 2),
(8, 'Matias Jeronimo Barbosa', 'mati@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 3),
(9, 'Felipe', 'dublas-2000@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 1),
(10, 'Alberto', 'berto@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 3),
(11, 'clodomiro', 'clodomiro@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 3),
(12, 'Duvan Felipe Barbosa', 'duvan@gmail.com', '1f6419b1cbe79c71410cb320fc094775', 3),
(14, 'Felipe', 'das-2000@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 3),
(17, 'Laura', 'Laura@gmail.com', '81dc9bdb52d04dc20036dbd8313ed055', 3),
(18, 'Carlos', 'adfadfaasdfadfdf@zfgsa', 'e708864855f3bb69c4d9a213b9108b9f', 2),
(19, 'Duvan Felipe Barbosa', 'pipebar@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 2),
(20, 'Dayana', 'yaya@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 3),
(21, 'Felipe', 'voley@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `auditoria`
--
ALTER TABLE `auditoria`
  ADD PRIMARY KEY (`idAuditoria`);

--
-- Indices de la tabla `bodega`
--
ALTER TABLE `bodega`
  ADD PRIMARY KEY (`idBodega`),
  ADD KEY `fk_bodega_producto1_idx` (`idProductoBodega`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`idCompra`),
  ADD KEY `fk_compra_producto1_idx` (`idClienteCompra`),
  ADD KEY `fk_compra_cliente1_idx` (`idProductoCompra`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idEmpleado`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `fk_pedido_producto1_idx` (`idProductoPedido`),
  ADD KEY `fk_pedido_proveedor1_idx` (`idProveedorPedido`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `fk_producto_tipoProducto_idx` (`idTipo_Producto`),
  ADD KEY `fk_producto_proveedor1_idx` (`idProveedor_Producto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`idTipo`);

--
-- Indices de la tabla `usario`
--
ALTER TABLE `usario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `fk_usario_rol1_idx` (`rol_idRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `auditoria`
--
ALTER TABLE `auditoria`
  MODIFY `idAuditoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `bodega`
--
ALTER TABLE `bodega`
  MODIFY `idBodega` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `idCompra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `idTipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usario`
--
ALTER TABLE `usario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bodega`
--
ALTER TABLE `bodega`
  ADD CONSTRAINT `fk_bodega_producto1` FOREIGN KEY (`idProductoBodega`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `fk_compra_cliente1` FOREIGN KEY (`idProductoCompra`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_compra_producto1` FOREIGN KEY (`idClienteCompra`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_pedido_producto1` FOREIGN KEY (`idProductoPedido`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_proveedor1` FOREIGN KEY (`idProveedorPedido`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_proveedor1` FOREIGN KEY (`idProveedor_Producto`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_producto_tipoProducto` FOREIGN KEY (`idTipo_Producto`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usario`
--
ALTER TABLE `usario`
  ADD CONSTRAINT `fk_usario_rol1` FOREIGN KEY (`rol_idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
