-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 21, 2018 at 03:02 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `saaf`
--

-- --------------------------------------------------------

--
-- Table structure for table `movimientos`
--

CREATE TABLE `movimientos` (
  `id` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tabla` varchar(100) NOT NULL,
  `idAcceso` int(11) NOT NULL,
  `request` text NOT NULL,
  `ip` varchar(250) NOT NULL,
  `comentarios` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movimientos`
--

INSERT INTO `movimientos` (`id`, `fecha`, `tabla`, `idAcceso`, `request`, `ip`, `comentarios`) VALUES
(1, '2018-10-21 00:17:00', 'detalles_resguardos', 177797, '{\"txtid_resguardo\":\"49780\"}', '0:0:0:0:0:0:0:1', 'Se termina un resguardo activo.'),
(2, '2018-10-21 00:28:00', 'detalles_resguardos', 177801, '{\"txtid_resguardo_administrativo\":\"2599\",\"txtid_resguardo\":\"49870\",\"txtids_activos\":\"985374,985390\"}', '0:0:0:0:0:0:0:1', 'Se agregan activos a un resguardo en solicitud.'),
(3, '2018-10-21 00:35:00', 'detalles_resguardos', 177802, '{\"txtids_detalles_resguardos\":\"144539,43825\",\"txtcurp_responsable\":\"RICS750816MZSNBN08\",\"jqg_activos_43825\":\"on\",\"txtid_resguardo\":\"49786\",\"jqg_activos_144539\":\"on\",\"txtnombre_responsable\":\"SANDRA MARISOL RINCON CABRERA\",\"txtfechainicio\":\"2018/10/20\",\"origen\":\"1\",\"txtids_muebles\":\"\"}', '0:0:0:0:0:0:0:1', 'Se reasigna un resguardo activo.'),
(4, '2018-10-21 00:52:00', 'detalles_solicitudes', 177805, '{\"cbodestinofinal964326\":\"1\",\"cbomotivo964326\":\"10\",\"txtcomentarios964326\":\"Baja administrativa\",\"cbodestinofinal125600\":\"3\",\"cbomotivo117518\":\"1\",\"txtcomentarios117518\":\"baja definitivca\",\"txtids\":\"964326,125600,117518\",\"txtcomentarios125600\":\"inservible\",\"cbomotivo125600\":\"1\",\"cbodestinofinal117518\":\"1\"}', '0:0:0:0:0:0:0:1', 'Se crea una solicitud de baja.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idAcceso` (`idAcceso`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `movimientos`
--
ALTER TABLE `movimientos`
  ADD CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`idAcceso`) REFERENCES `accesos` (`ID_ACCESO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
