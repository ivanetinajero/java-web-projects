-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: zapateria
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Zapatos Caballero'),(2,'Zapatos Dama'),(3,'Tennis'),(4,'Pantalones'),(5,'Chamarras');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Publico General','N/A','234354'),(2,'Felipe Gonzalez Lopez','C. Platero #5','152654'),(3,'Marcela Diaz','C. G Lopez #4','485211'),(4,'Marisol Martinez Esparza','C. Luis Moya #456','485214');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(100) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `precioVenta` double NOT NULL,
  `precioCosto` double NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `FK_REFERENCE_1` (`idCategoria`),
  CONSTRAINT `FK_REFERENCE_1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'001','Zapatos Hunter #6',800,650,1),(2,'002','Zapatos DC Shoes #5',600,500,1),(3,'003','Zapatos Mujer Dirk Bikkembergs #5',1200,950,2),(4,'004','Zapatos para Mujer Gucci #4',1500,1350,2),(5,'005','Tennis Nike Modelo 1524 #7',700,620,3),(6,'006','Tennis Adidas modelo 4511 #5',1800,1795,3),(7,'007','Tennis Nike Jordan 52 #6',2200,1800,3),(8,'008','Tennis Running Mod 774 # 7',1400,1250,3);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `idSucursal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  PRIMARY KEY (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES (1,'B Hermanos - Zacatecas Centro','Centro, Zacatecas'),(2,'B Hermanos - Fresnillo','Centro Fresnillo'),(3,'B Hermanos - Jerez','Jerez, Centro');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `idSucursal` int(11) DEFAULT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `tipo` enum('vendedor','admin') NOT NULL,
  `activo` int(11) DEFAULT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `FK_REFERENCE_4` (`idSucursal`),
  CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'admin','21232f297a57a5a743894a0e4a801fc3','admin',1,'IVAN ELISEO TINAJERO DIAZ'),(2,1,'maricela','148e60fc188d3e74c6be627ecfd8c390','vendedor',1,'MARICELA GUEVARA GOMEZ'),(3,2,'luis','502ff82f7f1f8218dd41201fe4353687','vendedor',1,'LUIS MIGUEL ROSALES GAITAN'),(4,2,'griselda','9d2e64075dbec7ee824cbd5d0244d352','vendedor',1,'EVA GRISELDA GARCIA LUCERO'),(5,3,'jose','662eaa47199461d01a623884080934ab','vendedor',1,'JOSE ADRIAN PEREZ MOTA'),(6,3,'anabel','6d0d3cd7b60bce2368f99610908c2a00','vendedor',1,'ANABEL VILLAGRANA MACIAS');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cantidad` int(11) NOT NULL,
  `precio` double NOT NULL,
  `idSucursal` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idProducto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `FK_REFERENCE_2` (`idCliente`),
  KEY `FK_REFERENCE_3` (`idSucursal`),
  KEY `FK_REFERENCE_5` (`idProducto`),
  CONSTRAINT `FK_REFERENCE_2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FK_REFERENCE_3` FOREIGN KEY (`idSucursal`) REFERENCES `sucursal` (`idSucursal`),
  CONSTRAINT `FK_REFERENCE_5` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,'2014-09-18 23:37:00',1,1500,1,1,4),(2,'2014-09-18 23:38:00',6,1400,1,1,8),(3,'2014-09-18 23:47:00',5,1500,1,1,4),(4,'2014-09-19 00:21:00',3,1500,2,4,4),(5,'2014-09-19 15:14:00',3,700,1,1,5),(6,'2014-09-19 15:20:00',3,1500,1,1,4),(7,'2014-09-19 15:51:00',3,1500,2,1,4),(8,'2014-09-19 16:26:00',1,2200,3,1,7),(9,'2014-09-19 16:26:00',2,1800,3,4,6);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-19 11:27:24
