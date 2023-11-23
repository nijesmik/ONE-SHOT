-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: oneshot-database-instance.cdar65dwvpwx.ap-northeast-2.rds.amazonaws.com    Database: oneshot
-- ------------------------------------------------------
-- Server version	8.0.33

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT COMMENT '주문서 기본 PK',
  `user_id` int NOT NULL COMMENT '주문서 생성 유저 | 비회원일 경우 고정값을 가짐',
  `brand_id` int NOT NULL COMMENT '주문하는 브랜드 id',
  `order_code` varchar(255) NOT NULL COMMENT '주문서 공유 url',
  `service` tinyint(1) NOT NULL DEFAULT '0' COMMENT '주문서 서비스 종료 여부 : 0 종료 안됨 | 1 종료됨',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '주문서 row 생성 시각',
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 주문서 row 수정 시각',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_code` (`order_code`),
  KEY `fk_order_user_id` (`user_id`),
  KEY `fk_order_brand_id` (`brand_id`),
  CONSTRAINT `fk_order_brand_id` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`),
  CONSTRAINT `fk_order_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,1,'7mc19d9w42',0,'2023-11-22 05:18:33',NULL),(2,1,2,'588j56p42p',0,'2023-11-22 08:46:13',NULL),(3,1,8,'jb23719009',0,'2023-11-22 08:47:34',NULL),(4,1,1,'3e9d4e09yh',0,'2023-11-22 08:47:38',NULL),(5,1,2,'376kkr5hb8',0,'2023-11-22 08:50:10',NULL),(6,1,2,'88m8r0c45h',0,'2023-11-22 08:50:53',NULL),(7,1,2,'4nb047g64v',0,'2023-11-22 08:56:50',NULL),(8,1,2,'575h229v6u',0,'2023-11-22 08:57:45',NULL),(9,1,2,'sl3r6se4an',0,'2023-11-22 17:11:52',NULL),(10,1,1,'2kk5w866d9',0,'2023-11-23 06:23:08',NULL),(11,1,1,'ani17q2458',0,'2023-11-23 06:54:12',NULL);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-23 16:45:45
