-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 24, 2016 at 12:46 PM
-- Server version: 5.5.40-0ubuntu0.14.04.1
-- PHP Version: 7.0.10-2+deb.sury.org~trusty+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `securitydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Sucursal`
--

CREATE TABLE `Sucursal` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `administrador` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `activa` int(1) NOT NULL DEFAULT '1',
  `dbhost` varchar(100) NOT NULL,
  `dbname` varchar(100) NOT NULL,
  `dbuser` varchar(50) NOT NULL,
  `dbpass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Usuario`
--

CREATE TABLE `Usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `tmppwd` varchar(100) DEFAULT NULL,
  `pwdchanged` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Usuario`
--

INSERT INTO `Usuario` (`id`, `nombre`, `direccion`, `telefono`, `email`, `username`, `password`, `tmppwd`, `pwdchanged`) VALUES
(1, 'Ivan E. Tinajero Diaz', 'C. Luis Moya 613 A Sur', '4789855223', 'ivanetinajero@gmail.com', 'itinajero', '21232f297a57a5a743894a0e4a801fc3', 'admin', 1),
(2, 'Juan Tinajero Diaz', 'Direccion', 'telefono', 'tejanero@hotmail.com', 'jtinajero', '21232f297a57a5a743894a0e4a801fc3', 'admin', 1);

-- --------------------------------------------------------

--
-- Table structure for table `UsuarioPerfil`
--

CREATE TABLE `UsuarioPerfil` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `perfil` varchar(100) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `UsuarioPerfil`
--

INSERT INTO `UsuarioPerfil` (`id`, `username`, `perfil`, `idUsuario`) VALUES
(1, 'itinajero', 'role1', 1),
(4, 'jtinajero', 'tomcat', 2);

-- --------------------------------------------------------

--
-- Table structure for table `UsuarioSucursal`
--

CREATE TABLE `UsuarioSucursal` (
  `id` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idSucursal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Sucursal`
--
ALTER TABLE `Sucursal`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `UsuarioPerfil`
--
ALTER TABLE `UsuarioPerfil`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indexes for table `UsuarioSucursal`
--
ALTER TABLE `UsuarioSucursal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `perfil_fk_2` (`idSucursal`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Sucursal`
--
ALTER TABLE `Sucursal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `UsuarioPerfil`
--
ALTER TABLE `UsuarioPerfil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `UsuarioSucursal`
--
ALTER TABLE `UsuarioSucursal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `UsuarioPerfil`
--
ALTER TABLE `UsuarioPerfil`
  ADD CONSTRAINT `fk_UsuarioPerfil` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `UsuarioSucursal`
--
ALTER TABLE `UsuarioSucursal`
  ADD CONSTRAINT `fk_UsuarioSucursal` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `perfil_fk_1` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `perfil_fk_2` FOREIGN KEY (`idSucursal`) REFERENCES `Sucursal` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
