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
-- Table structure for table `movie_dtls`
--

DROP TABLE IF EXISTS `movie_dtls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_dtls` (
  `movieid` int NOT NULL AUTO_INCREMENT,
  `moviename` varchar(45) DEFAULT NULL,
  `director` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `movieCategory` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `photo` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `video` varchar(45) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`movieid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_dtls`
--

LOCK TABLES `movie_dtls` WRITE;
/*!40000 ALTER TABLE `movie_dtls` DISABLE KEYS */;
INSERT INTO `movie_dtls` VALUES (1,'Interstellar','Christopher Noland','35','New','Active','MOVAB14245__28808.jpg','admin@gmail.com','Sci-Fi','2014',NULL,1),(2,'The Thin Red Line','Terrence Malick','32','New','Active','TTRL.jpg','admin@gmail.com','War','1998',NULL,2),(3,'Jurassic Park','Steven Spielberg','30','New','Active','jrpark.jpg','admin@gmail.com','Fantasy','1993',NULL,2),(4,'A.I','Steven Spielberg','27','Old','Active','AI_.jpg','admin@gmail.com','Sci-Fi','2001',NULL,1),(5,'Troy','Wolfgang Petersen','30','New','Active','Troy.jpg','admin@gmail.com','Historical','2004',NULL,1),(6,'1408','Mikael Håfström','25','Old','Active','1408.jpg','admin@gmail.com','Horror','2006',NULL,1),(7,'The Matrix','The Wachowski Brothers','34','New','Active','matrix.jpg','admin@gmail.com','Sci-Fi','1999',NULL,1),(8,'Man of Steel','Zack Snyder','33','New','Active','mos.jpg','admin@gmail.com','Superhero','2013',NULL,1),(9,'Cast Away','Robert Zemeckis','25','Old','Active','castaway.jpg','thintzaw89@gmail.com','Drama','2000',NULL,1),(10,'Terminator 2: Judgment Day','James Cameron','28','Old','Active','terminator2.jpg','thintzaw89@gmail.com','Fantasy','1986',NULL,1),(11,'Forrest Gump','Robert Zemeckis','32','Old','Active','forrestgump.jpg','admin@gmail.com','Drama','1994','ForrestGump.mp4',2),(17,'Wall-E','Andrew Stanton','21','New','Active','WALL-E_poster.jpg','admin@gmail.com','Family','2009','',1);
/*!40000 ALTER TABLE `movie_dtls` ENABLE KEYS */;
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
