-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-01-2019 a las 05:09:51
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemacontable`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `idpartida` int(11) NOT NULL,
  `numpartida` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `concepto` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `partida`
--

INSERT INTO `partida` (`idpartida`, `numpartida`, `fecha`, `concepto`) VALUES
(1, 1, '2019-01-05 00:33:27', 'v/ por inicio de operaciones'),
(2, 2, '2019-01-05 00:39:08', 'v/ por venta al credito'),
(3, 3, '2019-01-05 01:09:20', 'v/ por compra 40% con cheque'),
(4, 4, '2019-01-05 01:12:09', 'v/ por pago de gastos s/compras'),
(5, 5, '2019-01-05 01:31:20', 'v/ como provision de incobrabilidad'),
(6, 6, '2019-01-05 01:37:10', 'v/ por devolucion de mercaderia'),
(7, 7, '2019-01-05 01:41:16', 'v/ por devolucion de mercaderia'),
(8, 8, '2019-01-05 01:43:15', 'v/ por compra a vostro'),
(9, 9, '2019-01-05 01:48:02', 'v/ por pago a vostro a condicion 2/10 neto 60\n'),
(10, 10, '2019-01-05 01:49:55', 'v/por rebaja cedida por el proveedor'),
(11, 11, '2019-01-05 01:53:52', 'v/ abono a banco y robo a vendedor'),
(12, 12, '2019-01-05 02:04:22', 'v/por compra de patente'),
(13, 13, '2019-01-05 02:06:35', 'v/por determinar incobrabilidad'),
(14, 14, '2019-01-05 02:07:53', 'v/ por venta al contado'),
(15, 15, '2019-01-05 02:09:56', 'v/ popr cliente que devolvio mercaderia'),
(16, 16, '2019-01-05 02:12:58', 'v/ por pago de cliente mediante cheque'),
(17, 17, '2019-01-05 02:16:41', 'v/ por pago de publicidad\n'),
(18, 18, '2019-01-05 02:17:57', 'v/ por pago de viaticos por capacitacion'),
(19, 19, '2019-01-05 02:20:51', 'v/pago de comision por tramites bancarios'),
(20, 20, '2019-01-05 02:25:16', 'v/ por pago de intereses de parte del banco'),
(21, 21, '2019-01-05 02:26:31', 'v/ por pago de recibos '),
(22, 22, '2019-01-05 02:33:19', 'v/ por retiro de dinero de Irochi Inoue');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`idpartida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `idpartida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
