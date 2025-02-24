-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: movie_app
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `movie_order_dtls`
--

DROP TABLE IF EXISTS `movie_order_dtls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_order_dtls` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(45) DEFAULT NULL,
  `cartid` int DEFAULT NULL,
  `moviename` varchar(45) DEFAULT NULL,
  `director` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `movieid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_order_dtls`
--

LOCK TABLES `movie_order_dtls` WRITE;
/*!40000 ALTER TABLE `movie_order_dtls` DISABLE KEYS */;
INSERT INTO `movie_order_dtls` VALUES (1,'MOV-ORDR-1-1000000',1,'Wall-E','Andrew Stanton','21.0',17,1),(3,'MOV-ORDR-1-1000001',3,'Terminator 2: Judgment Day','James Cameron','28.0',10,1),(4,'MOV-ORDR-1-1000002',5,'Man of Steel','Zack Snyder','33.0',8,1),(5,'MOV-ORDR-1-1000003',6,'The Matrix','The Wachowski Brothers','34.0',7,1),(6,'MOV-ORDR-1-1000004',9,'1408','Mikael Håfström','25.0',6,1),(7,'MOV-ORDR-1-1000004',10,'Troy','Wolfgang Petersen','30.0',5,1),(8,'MOV-ORDR-1-1000004',11,'Interstellar','Christopher Noland','35.0',1,1),(9,'MOV-ORDR-8-1000005',13,'Wall-E','Andrew Stanton','21.0',17,8),(11,'MOV-ORDR-1-1000006',12,'A.I','Steven Spielberg','27.0',4,1),(12,'MOV-ORDR-1-1000006',21,'Cast Away','Robert Zemeckis','25.0',9,1);
/*!40000 ALTER TABLE `movie_order_dtls` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-06 16:46:44
