-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-12-2023 a las 15:41:32
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `riteve`
--
CREATE DATABASE IF NOT EXISTS `riteve` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `riteve`;

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `BuscarCita` (IN `pId` INT)   SELECT * from citas where id_cita =pId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BuscarRevision` (IN `pIdRevision ` INT)   SELECT * FROM Revisiones WHERE id_revision = pIdRevision$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BuscarTecnico` (IN `pCedula ` VARCHAR(15))   SELECT * FROM Tecnicos WHERE cedula = pCedula$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BuscarVehiculo` (IN `pNumeroPlaca ` VARCHAR(10))   SELECT * FROM Vehiculos WHERE numero_placa = pNumeroPlaca$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CitasMismoHorario` (IN `pFecha` DATE, IN `pHora` TIME, OUT `pCitasEnMismoHorario` INT)   SELECT COUNT(*) INTO pCitasEnMismoHorario
    FROM citas
    WHERE fecha = pFecha AND hora = pHora$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarCita` (IN `pIdCita` INT)   DELETE FROM citas WHERE id_cita = pIdCita$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarRevision` (IN `pIdRevision` INT)   DELETE FROM Revisiones WHERE id_revision = pIdRevision$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarTecnico` (IN `pCedula ` VARCHAR(15))   DELETE FROM Tecnicos WHERE cedula = pCedula$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarVehiculo` (IN `pNumeroPlaca ` VARCHAR(10))   DELETE FROM Vehiculos WHERE numero_placa = pNumeroPlaca$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarCita` (IN `pIdCita` INT, IN `pFecha` DATE, IN `pHora` TIME, IN `pIdVehiculo` VARCHAR(255))   INSERT INTO citas (id_cita, fecha, hora, id_vehiculo) VALUES (pIdCita, pFecha, pHora, pIdVehiculo)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarRevision` (IN `pFecha ` DATE, IN `pHora ` TIME, IN `pIdTecnico ` VARCHAR(15), IN `pIdCita ` INT, IN `pTipoRevision ` VARCHAR(20), IN `pObservaciones ` TEXT, IN `pEstado` VARCHAR(10))   INSERT INTO Revisiones (fecha, hora, id_tecnico, id_cita, tipo_revision, observaciones, estado)
    VALUES (pFecha, pHora, pIdTecnico, pIdCita, pTipoRevision, pObservaciones, pEstado)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarTecnico` (IN `pCedula ` VARCHAR(15), IN `pNombreCompleto ` VARCHAR(30), IN `pFechaNacimiento ` DATE, IN `pTelefono ` VARCHAR(10), IN `pCorreoElectronico ` VARCHAR(255), IN `pSalario ` DECIMAL(10,2), IN `pContrasena ` VARCHAR(255))   INSERT INTO Tecnicos (cedula, nombre_completo, fecha_nacimiento, telefono, correo_electronica, salario)
    VALUES (pCedula, pNombreCompleto, pFechaNacimiento, pTelefono, pCorreoElectronico, pSalario)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarVehiculo` (IN `pNumeroPlaca ` VARCHAR(10), IN `pMarca ` VARCHAR(255), IN `pModelo ` VARCHAR(255), IN `pAnio ` INT, IN `pFechaInscripcion ` DATE, IN `pCedulaPropietario ` VARCHAR(15), IN `pNombrePropietario ` VARCHAR(255))   INSERT INTO Vehiculos (numero_placa, marca, modelo, anio, fecha_inscripcion, cedula_propietario, nombre_propietario)
    VALUES (pNumeroPlaca, pMarca, pModelo, pAnio, pFechaInscripcion, pCedulaPropietario, pNombrePropietario)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ModificarCita` (IN `pFecha` DATE, IN `pHora` TIME, IN `pIdVehiculo` VARCHAR(255), IN `pIdCita` INT)   UPDATE citas
    SET fecha = pFecha, hora = pHora, id_vehiculo = pIdVehiculo
    WHERE id_cita = pIdCita$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ModificarRevision` (IN `pIdRevision` INT, IN `pNuevaFecha ` DATE, IN `pNuevaHora ` TIME, IN `pNuevoIdTecnico ` VARCHAR(15), IN `pNuevoIdCita ` INT, IN `pNuevoTipoRevision ` VARCHAR(20), IN `pNuevasObservaciones ` TEXT, IN `pNuevoEstado ` VARCHAR(10))   UPDATE Revisiones
    SET
        fecha = pNuevaFecha,
        hora = pNuevaHora,
        id_tecnico = pNuevoIdTecnico,
        id_cita = pNuevoIdCita,
        tipo_revision = pNuevoTipoRevision,
        observaciones = pNuevasObservaciones,
        estado = pNuevoEstado
    WHERE id_revision = pIdRevision$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ModificarTecnico` (IN `pCedula ` VARCHAR(15), IN `pNuevoNombreCompleto ` VARCHAR(255), IN `pNuevoFechaNacimiento ` DATE, IN `pNuevoTelefono ` VARCHAR(10), IN `pNuevoCorreoElectronico ` VARCHAR(255), IN `pNuevoSalario ` DECIMAL(10,2))   UPDATE Tecnicos
    SET
        nombre_completo = pNuevoNombreCompleto,
        fecha_nacimiento = pNuevoFechaNacimiento,
        telefono = pNuevoTelefono,
        correo_electronico = pNuevoCorreoElectronico,
        salario = pNuevoSalario
    WHERE cedula = pCedula$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ModificarVehiculo` (IN `pNumeroPlaca ` VARCHAR(10), IN `pNuevaMarca ` VARCHAR(255), IN `pNuevoModelo ` VARCHAR(255), IN `pNuevoAnio ` INT, IN `pNuevaFechaInscripcion ` DATE, IN `pNuevaCedulaPropietario ` VARCHAR(15), IN `pNuevoNombrePropietario ` VARCHAR(255))   UPDATE Vehiculos
    SET
        marca = pNuevaMarca,
        modelo = pNuevoModelo,
        anio = pNuevoAnio,
        fecha_inscripcion = pNuevaFechaInscripcion,
        cedula_propietario = pNuevaCedulaPropietario,
        nombre_propietario = pNuevoNombrePropietario
    WHERE numero_placa = pNumeroPlaca$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ObtenerTodasLasCitas` ()   SELECT * FROM citas$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VerificarCitaActiva` (IN `pIdVehiculo` VARCHAR(255), OUT `pCitaActiva` INT)   SELECT COUNT(*) INTO pCitaActiva
    FROM citas
    WHERE id_vehiculo = pIdVehiculo AND fecha >= CURRENT_DATE$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `id_cita` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `id_vehiculo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`id_cita`, `fecha`, `hora`, `id_vehiculo`) VALUES
(3, '2023-12-06', '10:00:00', 'ABC17'),
(6, '2023-12-06', '12:00:00', 'ABC1'),
(15, '2024-07-07', '11:00:00', 'ABC5'),
(17, '2023-12-03', '15:00:00', 'ABC9'),
(18, '2023-12-07', '12:00:00', 'ABC2'),
(20, '2023-12-06', '10:00:00', 'ABC15'),
(21, '2023-12-06', '10:00:00', 'ABC3'),
(22, '2023-12-06', '10:00:00', 'CR504'),
(23, '2024-06-06', '19:00:00', 'ABC6'),
(24, '2024-05-04', '12:00:00', 'ABC8'),
(25, '2024-01-01', '01:00:00', 'ABC7');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revisiones`
--

CREATE TABLE `revisiones` (
  `id_revision` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `id_tecnico` varchar(40) NOT NULL,
  `id_cita` int(10) NOT NULL,
  `tipo_revision` varchar(15) NOT NULL,
  `observaciones` text NOT NULL,
  `estado` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `revisiones`
--

INSERT INTO `revisiones` (`id_revision`, `fecha`, `hora`, `id_tecnico`, `id_cita`, `tipo_revision`, `observaciones`, `estado`) VALUES
(2, '2024-06-06', '20:00:00', '504', 23, 'Reinspección', 'Perfecto estado', 'Aprobado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnicos`
--

CREATE TABLE `tecnicos` (
  `cedula` varchar(15) NOT NULL,
  `nombre_completo` varchar(40) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo_electronico` varchar(40) NOT NULL,
  `salario` decimal(10,0) NOT NULL,
  `contrasena` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tecnicos`
--

INSERT INTO `tecnicos` (`cedula`, `nombre_completo`, `fecha_nacimiento`, `telefono`, `correo_electronico`, `salario`, `contrasena`) VALUES
('123', 'Felipe', '0000-00-00', '8888888', 'felichaconv@gmail.com', 1200000, '123'),
('504', 'Ronny', '2003-06-06', '77777777', 'ronny@gmail', 120000, '245');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `numero_placa` varchar(30) NOT NULL,
  `marca` varchar(40) NOT NULL,
  `modelo` varchar(40) NOT NULL,
  `anio` int(10) NOT NULL,
  `fecha_inscripcion` date NOT NULL,
  `cedula_propietario` varchar(30) NOT NULL,
  `nombre_propietario` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`numero_placa`, `marca`, `modelo`, `anio`, `fecha_inscripcion`, `cedula_propietario`, `nombre_propietario`) VALUES
('ABC0', 'Marca0', 'Modelo0', 2022, '2022-01-01', '123456789', 'Propietario0'),
('ABC1', 'Marca1', 'Modelo1', 2021, '2022-01-01', '123456789', 'Propietario1'),
('ABC10', 'Marca10', 'Modelo10', 2012, '2022-01-01', '123456789', 'Propietario10'),
('ABC11', 'Marca11', 'Modelo11', 2011, '2022-01-01', '123456789', 'Propietario11'),
('ABC13', 'Marca13', 'Modelo13', 2009, '2022-01-01', '123456789', 'Propietario13'),
('ABC14', 'Marca14', 'Modelo14', 2008, '2022-01-01', '123456789', 'Propietario14'),
('ABC15', 'Marca15', 'Modelo15', 2007, '2022-01-01', '123456789', 'Propietario15'),
('ABC16', 'Marca80', 'Modelo16', 2006, '2022-01-01', '123456789', 'Propietario16'),
('ABC17', 'Marca17', 'Modelo17', 2005, '2022-01-01', '123456789', 'Propietario17'),
('ABC18', 'Marca90', 'Modelo18', 2004, '2022-01-01', '123456789', 'Propietario18'),
('ABC19', 'Marca19', 'Modelo92', 2003, '2022-01-01', '123456789', 'Propietario19'),
('ABC2', 'Toyota', 'Hilux', 2006, '2007-08-08', '506', 'Ronny'),
('ABC3', 'Marca3', 'Modelo3', 2019, '2022-01-01', '123456789', 'Propietario3'),
('ABC4', 'Marca4', 'Modelo4', 2018, '2022-01-01', '123456789', 'Propietario4'),
('ABC45', 'Toyota', 'Camri', 2020, '2020-01-01', '504550220', 'Felipe Chacón'),
('ABC5', 'Marca5', 'Modelo5', 2017, '2022-01-01', '123456789', 'Propietario5'),
('ABC6', 'Marca6', 'Modelo6', 2016, '2022-01-01', '123456789', 'Propietario6'),
('ABC7', 'Marca7', 'Modelo7', 2015, '2022-01-01', '123456789', 'Propietario7'),
('ABC8', 'Marca8', 'Modelo8', 2014, '2022-01-01', '123456789', 'Propietario8'),
('ABC9', 'Marca9', 'Modelo9', 2013, '2022-01-01', '123456789', 'Propietario9'),
('ABC90', 'Toyota', 'Hilux', 2007, '2015-05-05', '503', 'Ekar Cortes'),
('CR504', 'Toyota', 'Hilux', 2004, '2023-06-06', '504', 'Ronny'),
('CR505', 'Toyota', 'Camri', 2002, '2003-04-04', '506', 'Alejandra');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`id_cita`),
  ADD UNIQUE KEY `FKIdVehiculo` (`id_vehiculo`(30)) USING BTREE,
  ADD KEY `id_vehiculo` (`id_vehiculo`);

--
-- Indices de la tabla `revisiones`
--
ALTER TABLE `revisiones`
  ADD PRIMARY KEY (`id_revision`),
  ADD UNIQUE KEY `FK` (`id_tecnico`),
  ADD UNIQUE KEY `FKIdCita` (`id_cita`),
  ADD UNIQUE KEY `FKIdTecnico` (`id_tecnico`);

--
-- Indices de la tabla `tecnicos`
--
ALTER TABLE `tecnicos`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`numero_placa`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `id_cita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `revisiones`
--
ALTER TABLE `revisiones`
  MODIFY `id_revision` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculos` (`numero_placa`);

--
-- Filtros para la tabla `revisiones`
--
ALTER TABLE `revisiones`
  ADD CONSTRAINT `revisiones_ibfk_1` FOREIGN KEY (`id_tecnico`) REFERENCES `tecnicos` (`cedula`),
  ADD CONSTRAINT `revisiones_ibfk_2` FOREIGN KEY (`id_cita`) REFERENCES `citas` (`id_cita`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
