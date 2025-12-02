-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: aula19
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cli_cliente`
--

DROP TABLE IF EXISTS `cli_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cli_cliente` (
  `CLI_ID` int NOT NULL AUTO_INCREMENT,
  `CLI_NOME` varchar(200) NOT NULL,
  `CLI_SALARIO` decimal(10,2) NOT NULL,
  PRIMARY KEY (`CLI_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cli_cliente`
--

LOCK TABLES `cli_cliente` WRITE;
/*!40000 ALTER TABLE `cli_cliente` DISABLE KEYS */;
INSERT INTO `cli_cliente` VALUES (1,'Junior',50000.00),(2,'Fulano',10000.00),(3,'Maria',150000.00),(4,'Lula',300000.00);
/*!40000 ALTER TABLE `cli_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cnt_conta`
--

DROP TABLE IF EXISTS `cnt_conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cnt_conta` (
  `CNT_ID` int NOT NULL AUTO_INCREMENT,
  `CNT_IDCLIENTE` int NOT NULL,
  `CNT_AGENCIA` int NOT NULL,
  `CNT_NUMERO` int NOT NULL,
  `CNT_TIPO` tinyint NOT NULL,
  PRIMARY KEY (`CNT_ID`),
  KEY `FK_CLIENTE_idx` (`CNT_IDCLIENTE`),
  CONSTRAINT `FK_CLIENTE` FOREIGN KEY (`CNT_IDCLIENTE`) REFERENCES `cli_cliente` (`CLI_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cnt_conta`
--

LOCK TABLES `cnt_conta` WRITE;
/*!40000 ALTER TABLE `cnt_conta` DISABLE KEYS */;
INSERT INTO `cnt_conta` VALUES (1,1,123,10,0),(2,1,456,11,1),(3,2,12,12,0),(4,3,879,13,0),(5,4,567,14,1);
/*!40000 ALTER TABLE `cnt_conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mov_movimentacao`
--

DROP TABLE IF EXISTS `mov_movimentacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mov_movimentacao` (
  `MOV_ID` int NOT NULL AUTO_INCREMENT,
  `MOV_IDCONTA` int NOT NULL,
  `MOV_IDTIPO` int NOT NULL,
  `MOV_DATA` datetime NOT NULL,
  `MOV_VALOR` decimal(10,2) NOT NULL,
  PRIMARY KEY (`MOV_ID`),
  KEY `FK_CONTA_idx` (`MOV_IDCONTA`),
  KEY `FK_TIPO_idx` (`MOV_IDTIPO`),
  CONSTRAINT `FK_CONTA` FOREIGN KEY (`MOV_IDCONTA`) REFERENCES `cnt_conta` (`CNT_ID`),
  CONSTRAINT `FK_TIPO` FOREIGN KEY (`MOV_IDTIPO`) REFERENCES `tip_tipo` (`TIP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mov_movimentacao`
--

LOCK TABLES `mov_movimentacao` WRITE;
/*!40000 ALTER TABLE `mov_movimentacao` DISABLE KEYS */;
INSERT INTO `mov_movimentacao` VALUES (1,1,1,'2025-11-02 00:00:00',123.00),(2,4,1,'2025-11-02 10:13:14',1234.00),(3,5,1,'2025-11-02 10:34:55',3000.00),(4,5,1,'2025-11-02 10:35:00',3004.00);
/*!40000 ALTER TABLE `mov_movimentacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tip_tipo`
--

DROP TABLE IF EXISTS `tip_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tip_tipo` (
  `TIP_ID` int NOT NULL AUTO_INCREMENT,
  `TIP_DESCRICAO` varchar(200) NOT NULL,
  `TIP_OPERACAO` tinyint NOT NULL,
  PRIMARY KEY (`TIP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tip_tipo`
--

LOCK TABLES `tip_tipo` WRITE;
/*!40000 ALTER TABLE `tip_tipo` DISABLE KEYS */;
INSERT INTO `tip_tipo` VALUES (1,'Depósito',0),(2,'Saque',1);
/*!40000 ALTER TABLE `tip_tipo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-02 10:45:26
