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
-- Table structure for table `movie_order`
--

DROP TABLE IF EXISTS `movie_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `payment_type` varchar(45) DEFAULT NULL,
  `total_price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000007 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_order`
--

LOCK TABLES `movie_order` WRITE;
/*!40000 ALTER TABLE `movie_order` DISABLE KEYS */;
INSERT INTO `movie_order` VALUES (1000000,'MOV-ORDR-1-1000000','Thint Zaw','thintzaw89@gmail.com','Burma, Asean, Rangoon, Yangon, 11211','09898184440','COD','21'),(1000001,'MOV-ORDR-1-1000001','Thint Zaw','thintzaw89@gmail.com','Burma, Asean, Rangoon, Yangon, 11211','09898184440','COD','28.0'),(1000002,'MOV-ORDR-1-1000002','Thint Zaw','thintzaw89@gmail.com','Burma, Asean, Rangoon, Yangon, 11211','09898184440','COD','33.0'),(1000003,'MOV-ORDR-1-1000003','Thint Zaw','thintzaw89@gmail.com','Burma, Asean, Rangoon, Yangon, 11211','09898184440','COD','34.0'),(1000004,'MOV-ORDR-1-1000004','Thint Zaw','thintzaw89@gmail.com','Burma, Asean, Rangoon, Yangon, 11211','09898184440','COD','90.0'),(1000005,'MOV-ORDR-8-1000005','Deagol','deagol@gmail.com','No 23, Shew Gong Dai Roal, Myanmar, Yangon, Yangon, 11311','984028422342','COD','21'),(1000006,'MOV-ORDR-1-1000006','Thint Zaw','thintzaw89@gmail.com','Burma, Asean, Rangoon, Yangon, 11211','09898184440','COD','52');
/*!40000 ALTER TABLE `movie_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-06 16:46:45
