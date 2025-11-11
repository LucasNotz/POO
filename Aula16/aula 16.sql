-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: aula16
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
-- Table structure for table `dis_disciplina`
--

DROP TABLE IF EXISTS `dis_disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dis_disciplina` (
  `DIS_ID` int NOT NULL AUTO_INCREMENT,
  `DIS_NOME` varchar(200) NOT NULL,
  PRIMARY KEY (`DIS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dis_disciplina`
--

LOCK TABLES `dis_disciplina` WRITE;
/*!40000 ALTER TABLE `dis_disciplina` DISABLE KEYS */;
INSERT INTO `dis_disciplina` VALUES (1,'POO'),(2,'BD'),(3,'Estrutura de dados'),(4,'Algebra Linear'),(5,'Seg Comp');
/*!40000 ALTER TABLE `dis_disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prf_professor`
--

DROP TABLE IF EXISTS `prf_professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prf_professor` (
  `PRF_ID` int NOT NULL AUTO_INCREMENT,
  `PRF_NOME` varchar(200) NOT NULL,
  `PRF_TITULACAO` varchar(45) NOT NULL,
  PRIMARY KEY (`PRF_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prf_professor`
--

LOCK TABLES `prf_professor` WRITE;
/*!40000 ALTER TABLE `prf_professor` DISABLE KEYS */;
INSERT INTO `prf_professor` VALUES (1,'Junior','Doutor'),(2,'Houston','Mestre'),(3,'Keila','Especialista');
/*!40000 ALTER TABLE `prf_professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tur_turma`
--

DROP TABLE IF EXISTS `tur_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tur_turma` (
  `TUR_ID` int NOT NULL AUTO_INCREMENT,
  `TUR_IDDISCIPLINA` int NOT NULL,
  `TUR_IDPROFESSOR` int NOT NULL,
  `TUR_LETRA` char(1) NOT NULL,
  PRIMARY KEY (`TUR_ID`),
  KEY `FK_DISCIPLINA_idx` (`TUR_IDDISCIPLINA`),
  KEY `FK_PROFESSOR_idx` (`TUR_IDPROFESSOR`),
  CONSTRAINT `FK_DISCIPLINA` FOREIGN KEY (`TUR_IDDISCIPLINA`) REFERENCES `dis_disciplina` (`DIS_ID`),
  CONSTRAINT `FK_PROFESSOR` FOREIGN KEY (`TUR_IDPROFESSOR`) REFERENCES `prf_professor` (`PRF_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tur_turma`
--

LOCK TABLES `tur_turma` WRITE;
/*!40000 ALTER TABLE `tur_turma` DISABLE KEYS */;
INSERT INTO `tur_turma` VALUES (1,1,2,'a');
/*!40000 ALTER TABLE `tur_turma` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-11 10:14:37
