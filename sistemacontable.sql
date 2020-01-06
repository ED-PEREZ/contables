-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-01-2019 a las 19:22:10
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
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `idcuenta` int(11) NOT NULL,
  `codigo` varchar(11) CHARACTER SET utf16 COLLATE utf16_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) CHARACTER SET utf16 COLLATE utf16_spanish_ci DEFAULT NULL,
  `tiposaldo` varchar(11) CHARACTER SET utf16 COLLATE utf16_spanish_ci DEFAULT NULL,
  `saldo` double DEFAULT NULL,
  `idorden` int(11) DEFAULT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  `nivel` int(11) DEFAULT NULL,
  `tipocuenta` varchar(20) CHARACTER SET utf16 COLLATE utf16_spanish_ci DEFAULT NULL,
  `movimiento` varchar(5) CHARACTER SET utf16 COLLATE utf16_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`idcuenta`, `codigo`, `nombre`, `tiposaldo`, `saldo`, `idorden`, `descripcion`, `nivel`, `tipocuenta`, `movimiento`) VALUES
(17, '1', 'ACTIVO', 'Deudor', NULL, NULL, NULL, 1, 'ACTIVO', 'no'),
(18, '11', 'Activos Corrientes', 'Deudor', NULL, 17, NULL, 2, 'ACTIVO', 'no'),
(19, '1101', 'Efectivo Y Equivalentes', 'Deudor', NULL, 18, NULL, 3, 'ACTIVO', 'no'),
(27, '1103', 'Instrumentos Financieros', 'Deudor', NULL, 18, NULL, 3, 'ACTIVO', 'no'),
(28, '1105', 'Cuentas y Documentos por Cobrar', 'Deudor', NULL, 18, NULL, 3, 'ACTIVO', 'no'),
(29, '1107', 'IVA credito Fiscal', 'Deudor', NULL, 18, NULL, 3, 'ACTIVO', 'no'),
(30, '1108', 'Inventario', 'Deudor', NULL, 18, NULL, 3, 'ACTIVO', 'no'),
(31, '1110', 'Otros Activos Corrientes', 'Deudor', NULL, 18, NULL, 3, 'ACTIVO', 'no'),
(32, '12', 'Activos no Corrientes', 'Deudor', NULL, 17, NULL, 2, 'ACTIVO', 'no'),
(33, '1201', 'Efectivo Restringido', 'Deudor', NULL, 32, NULL, 3, 'ACTIVO', 'no'),
(34, '1202', 'Inversiones Financieras', 'Deudor', NULL, 32, NULL, 3, 'ACTIVO', 'no'),
(35, '1204', 'Inversiones en Propiedades', 'Deudor', NULL, 32, NULL, 3, 'ACTIVO', 'no'),
(36, '1205', 'Inversiones en Bienes Muebles', 'Deudor', NULL, 32, NULL, 3, 'ACTIVO', 'no'),
(37, '1207', 'Reevaluacion', 'Deudor', NULL, 32, NULL, 3, 'ACTIVO', 'no'),
(38, '1208', 'Inversiones en Intangibles', 'Deudor', NULL, 32, NULL, 3, 'ACTIVO', 'no'),
(39, '1209', 'Amortizacion', 'Deudor', NULL, 32, NULL, 3, 'ACTIVO', 'no'),
(40, '1210', 'Minusvalia Compradra', 'Deudor', NULL, 32, NULL, 3, 'ACTIVO', 'no'),
(41, '1211', 'Plusvalia Compradra', 'Deudor', NULL, 32, NULL, 3, 'ACTIVO', 'no'),
(42, '2', 'PASIVO', 'Acreedor', NULL, NULL, NULL, 1, 'PASIVO', 'no'),
(43, '21', 'Pasivos Corrientes', 'Acreedor', NULL, 42, NULL, 2, 'PASIVO', 'no'),
(44, '2101', 'Cuentas y Documentos Por Pagar', 'Acreedor', NULL, 43, NULL, 3, 'PASIVO', 'no'),
(45, '2102', 'Prestamos Bancarios', 'Acreedor', NULL, 43, NULL, 3, 'PASIVO', 'no'),
(46, '2103', 'Retenciones', 'Acreedor', NULL, 43, NULL, 3, 'PASIVO', 'no'),
(47, '2104', 'Provisiones', 'Acreedor', NULL, 43, NULL, 3, 'PASIVO', 'no'),
(48, '2105', 'IVA Debito Fiscal', 'Acreedor', NULL, 43, NULL, 3, 'PASIVO', 'no'),
(49, '22', 'Pasivos no Corrientes', 'Acreedor', NULL, 42, NULL, 2, 'PASIVO', 'no'),
(50, '2201', 'Cuentas y Documentos por Pagar a Largo Plazo', 'Acreedor', NULL, 49, NULL, 3, 'PASIVO', 'no'),
(51, '2202', 'Prestamos Bancarios a Largo Plazo', 'Acreedor', NULL, 49, NULL, 3, 'PASIVO', 'no'),
(52, '2203', 'Provisiones a Largo Plazo', 'Acreedor', NULL, 49, NULL, 3, 'PASIVO', 'no'),
(53, '3', 'PATRIMONIO', 'Acreedor', NULL, NULL, NULL, 1, 'PATRIMONIO', 'no'),
(54, '31', 'Capital Social', 'Acreedor', NULL, 53, NULL, 2, 'PATRIMONIO', 'no'),
(55, '3101', 'Capital Social', 'Acreedor', NULL, 54, NULL, 3, 'PATRIMONIO', 'no'),
(56, '3102', 'Capital Social Pendiente de Suscripcion', 'Acreedor', NULL, 54, NULL, 3, 'PATRIMONIO', 'no'),
(57, '32', 'Reservas de Capital', 'Acreedor', NULL, 53, NULL, 2, 'PATRIMONIO', 'no'),
(58, '3201', 'Reserva Legal', 'Acreedor', NULL, 57, NULL, 3, 'PATRIMONIO', 'no'),
(59, '3202', 'Otras Reservas', 'Acreedor', NULL, 57, NULL, 3, 'PATRIMONIO', 'no'),
(60, '33', 'Superavit ', 'Acreedor', NULL, 53, NULL, 2, 'PATRIMONIO', 'no'),
(61, '3301', 'Superavit por Reevaluacion', 'Acreedor', NULL, 60, NULL, 3, 'PATRIMONIO', 'no'),
(62, '34', 'Ajustes', 'Acreedor', NULL, 53, NULL, 2, 'PATRIMONIO', 'no'),
(63, '3401', 'Ajustes por Valoracion', 'Acreedor', NULL, 62, NULL, 3, 'PATRIMONIO', 'no'),
(64, '35', 'Resultados', 'Acreedor', NULL, 53, NULL, 2, 'PATRIMONIO', 'no'),
(65, '3501', 'Resultado Acumulado', 'Acreedor', NULL, 64, NULL, 3, 'PATRIMONIO', 'no'),
(66, '3502', 'Resultados del Ejercicio', 'Acreedor', NULL, 64, NULL, 3, 'PATRIMONIO', 'no'),
(67, '4', 'INGRESOS', 'Acreedor', NULL, NULL, NULL, 1, 'INGRESOS', 'no'),
(68, '41', 'Ingresos de Actividades Ordinarias', 'Acreedor', NULL, 67, NULL, 2, 'INGRESOS', 'no'),
(69, '4101', 'Ventas', 'Acreedor', NULL, 68, NULL, 3, 'INGRESOS', 'no'),
(70, '4102', 'Ingresso por Servicios', 'Acreedor', NULL, 68, NULL, 3, 'INGRESOS', 'no'),
(71, '4103R', 'Devoluciones sobre Ventas', 'Acreedor', NULL, 68, NULL, 3, 'INGRESOS', 'no'),
(72, '4104R', 'Rebajas Sobre Ventas', 'Acreedor', NULL, 68, NULL, 3, 'INGRESOS', 'no'),
(73, '4105', 'Otros Ingresos Operativos', 'Acreedor', NULL, 68, NULL, 3, 'INGRESOS', 'no'),
(74, '42', 'Ingresos de Inversiones Financieras', 'Acreedor', NULL, 67, NULL, 2, 'INGRESOS', 'no'),
(75, '4202', 'Dividendos', 'Acreedor', NULL, 74, NULL, 3, 'INGRESOS', 'no'),
(76, '4203', 'Descuentos Sobre Compras', 'Acreedor', NULL, 74, NULL, 3, 'INGRESOS', 'no'),
(77, '4204', 'Fluctuaciones en Inversiones Financieras', 'Acreedor', NULL, 74, NULL, 3, 'INGRESOS', 'no'),
(78, '5', 'COSTOS', 'Deudor', NULL, NULL, NULL, 1, 'COSTOS', 'no'),
(79, '51', 'Costos', 'Deudor', NULL, 78, NULL, 2, 'COSTOS', 'no'),
(80, '5101', 'Costo de Ventas', 'Deudor', NULL, 79, NULL, 3, 'COSTOS', 'no'),
(81, '5102', 'Compras', 'Deudor', NULL, 79, NULL, 3, 'COSTOS', 'no'),
(82, '5103', 'Gastos de compras', 'Deudor', NULL, 79, NULL, 3, 'COSTOS', 'no'),
(83, '5104R', 'Devoluciones sobre compras', 'Deudor', NULL, 79, NULL, 3, 'COSTOS', 'no'),
(84, '5105R', 'Rebajas sobre compras', 'Deudor', NULL, 79, NULL, 3, 'COSTOS', 'no'),
(85, '6', 'GASTOS', 'Deudor', NULL, NULL, NULL, 1, 'GASTOS', 'no'),
(86, '61', 'Gastos de operacion', 'Deudor', NULL, 85, NULL, 2, 'GASTOS', 'no'),
(87, '6101', 'Gastos de administracion', 'Deudor', NULL, 86, NULL, 3, 'GASTOS', 'no'),
(88, '6102', 'Gastos de ventas', 'Deudor', NULL, 86, NULL, 3, 'GASTOS', 'no'),
(89, '6103', 'Otros gastos operativos', 'Deudor', NULL, 86, NULL, 3, 'GASTOS', 'no'),
(90, '62', 'Gastos financieros', 'Deudor', NULL, 85, NULL, 2, 'GASTOS', 'no'),
(91, '6201', 'Gastos financieros', 'Deudor', NULL, 90, NULL, 3, 'GASTOS', 'no'),
(92, '7', 'CUENTAS DE CONTROL', 'Deudor', NULL, NULL, NULL, 1, 'CUENTAS DE CONTROL', 'no'),
(93, '71', 'Cuentas liquidadoras', 'Deudor', NULL, 92, NULL, 2, 'CUENTAS DE CONTROL', 'no'),
(94, '7101', 'Perdidas y ganancias', 'Deudor', NULL, 93, NULL, 3, 'CUENTAS DE CONTROL', 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `id` int(11) NOT NULL,
  `ventas` double NOT NULL,
  `devventas` double NOT NULL,
  `compras` double NOT NULL,
  `gastcompras` double NOT NULL,
  `devcompras` double NOT NULL,
  `inventarioinicial` double NOT NULL,
  `inventariofinal` double NOT NULL,
  `gastoadmini` double NOT NULL,
  `gastoventa` double NOT NULL,
  `gastofinanciero` double NOT NULL,
  `otrogasto` double NOT NULL,
  `otroingreso` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id`, `ventas`, `devventas`, `compras`, `gastcompras`, `devcompras`, `inventarioinicial`, `inventariofinal`, `gastoadmini`, `gastoventa`, `gastofinanciero`, `otrogasto`, `otroingreso`) VALUES
(27, 97345.13274336283, 2654.867256637168, 100000, 1700, 13200, 150000, 200000, 2980, 4596.25, 0, 0, 0);

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
(4, 1, '2019-01-07 00:36:21', 'v/por inicio de operaciones'),
(5, 2, '2019-01-07 00:38:54', 'v/por venta realizada'),
(6, 3, '2018-12-31 20:44:16', 'v/por venta realizada'),
(7, 4, '2018-12-31 20:46:53', 'v/por devolucion de mercaderia por venta'),
(8, 5, '2018-12-31 20:48:48', 'v/por rebaja concedida'),
(9, 6, '2018-12-31 20:51:48', 'V/por compra realizada'),
(10, 7, '2018-12-31 20:53:11', 'v/por gastos sobre compras'),
(11, 8, '2018-12-31 20:56:05', 'v/por devolucion de mercaderia comprada'),
(12, 9, '2018-12-31 20:57:15', 'v/por rebaja de compra realizada'),
(13, 10, '2018-12-31 20:59:58', 'V/por compra de mobiliario y equipo'),
(14, 11, '2018-12-31 21:02:26', 'V/por pago de alquiler'),
(15, 12, '2018-12-31 21:03:38', 'v/por pago de sueldos'),
(16, 13, '2018-12-31 21:04:35', 'v/por pago de salarios'),
(17, 14, '2018-12-31 21:05:51', 'v/por provision de cuota patronal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE `transaccion` (
  `idtransaccion` int(11) NOT NULL,
  `monto` double NOT NULL,
  `operacion` double NOT NULL,
  `idcuenta` int(11) NOT NULL,
  `idpartida` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `transaccion`
--

INSERT INTO `transaccion` (`idtransaccion`, `monto`, `operacion`, `idcuenta`, `idpartida`) VALUES
(14, 60000, 1, 19, 4),
(15, 150000, 1, 30, 4),
(16, 210000, 2, 55, 4),
(17, 35000, 1, 19, 5),
(18, 15000, 1, 28, 5),
(19, 44247.78761061947, 2, 69, 5),
(20, 5752.212389380532, 2, 48, 5),
(21, 60000, 1, 19, 6),
(22, 53097.345132743365, 2, 69, 6),
(23, 6902.654867256638, 2, 48, 6),
(24, 884.9557522123894, 1, 71, 7),
(25, 115.04424778761064, 1, 48, 7),
(26, 1000, 2, 28, 7),
(27, 1769.9115044247787, 1, 72, 8),
(28, 230.0884955752213, 1, 48, 8),
(29, 2000, 2, 28, 8),
(30, 100000, 1, 81, 9),
(33, 13000, 1, 29, 9),
(34, 63000, 2, 19, 9),
(35, 50000, 2, 44, 9),
(36, 1700, 1, 82, 10),
(37, 221, 1, 29, 10),
(38, 1921, 2, 19, 10),
(39, 13560, 1, 44, 11),
(40, 12000, 2, 83, 11),
(41, 1560, 2, 29, 11),
(42, 1356, 1, 44, 12),
(43, 1200, 2, 84, 12),
(44, 156, 2, 29, 12),
(45, 3000, 1, 36, 13),
(46, 390, 1, 29, 13),
(47, 3390, 2, 19, 13),
(48, 750, 1, 87, 14),
(49, 97.5, 1, 29, 14),
(50, 750, 1, 88, 14),
(51, 97.5, 1, 29, 14),
(52, 1695, 2, 19, 14),
(53, 3500, 1, 88, 15),
(54, 3216.25, 2, 19, 15),
(55, 283.75, 2, 44, 15),
(56, 2000, 1, 87, 16),
(57, 1825, 2, 19, 16),
(58, 175, 2, 44, 16),
(59, 346.25, 1, 88, 17),
(60, 230, 1, 87, 17),
(61, 576.25, 2, 44, 17);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`idcuenta`),
  ADD KEY `fk_idorden` (`idorden`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`idpartida`);

--
-- Indices de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD PRIMARY KEY (`idtransaccion`),
  ADD KEY `fk_idcuenta` (`idcuenta`),
  ADD KEY `fk_idpartida` (`idpartida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  MODIFY `idcuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=95;

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `idpartida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  MODIFY `idtransaccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `fk_idorden` FOREIGN KEY (`idorden`) REFERENCES `cuenta` (`idcuenta`);

--
-- Filtros para la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD CONSTRAINT `fk_idcuenta` FOREIGN KEY (`idcuenta`) REFERENCES `cuenta` (`idcuenta`),
  ADD CONSTRAINT `fk_idpartida` FOREIGN KEY (`idpartida`) REFERENCES `partida` (`idpartida`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
