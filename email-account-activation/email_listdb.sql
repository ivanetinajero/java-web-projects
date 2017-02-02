-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 02, 2017 at 01:20 PM
-- Server version: 5.5.40-0ubuntu0.14.04.1
-- PHP Version: 7.0.10-2+deb.sury.org~trusty+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `email_listdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Contact`
--

CREATE TABLE `Contact` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `source` varchar(250) NOT NULL COMMENT 'Campo para saber de que seccion de mis paginas se registro.',
  `code` varchar(10) NOT NULL COMMENT 'Codigo de activacion random.',
  `codeMD5` varchar(50) NOT NULL COMMENT 'Codigo de activacion random en MD5.',
  `active` int(1) NOT NULL DEFAULT '0',
  `dateReg` timestamp NULL DEFAULT NULL,
  `dateAct` timestamp NULL DEFAULT NULL COMMENT 'Fecha de activacion'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Contact`
--

INSERT INTO `Contact` (`id`, `name`, `email`, `source`, `code`, `codeMD5`, `active`, `dateReg`, `dateAct`) VALUES
(1, 'Ivan Eliseo Tinajero Diaz', 'ivanetinajero@gmail.com', 'cursoUdemy', 'Q@&1=YySml', '83d07bebf4fff98f76a862626c2857d4', 1, '2016-12-29 20:27:00', '2016-12-29 20:28:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Contact`
--
ALTER TABLE `Contact`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Contact`
--
ALTER TABLE `Contact`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
