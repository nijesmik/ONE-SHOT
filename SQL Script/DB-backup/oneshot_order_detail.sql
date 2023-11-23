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
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `order_detail_id` int NOT NULL AUTO_INCREMENT COMMENT '주문 기본 PK',
  `order_id` int NOT NULL COMMENT '주문이 속한 주문서의 id',
  `menu_detail_id` int NOT NULL COMMENT '주문에 해당하는 메뉴상세 의 id',
  `name` varchar(255) NOT NULL COMMENT '주문을 실시한 사용자 이름',
  `amount` int NOT NULL DEFAULT '1' COMMENT '주문 내역에 속한 메뉴의 개수',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '주문 row 생성 시각',
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 주문 row 수정 시각',
  PRIMARY KEY (`order_detail_id`),
  KEY `fk_orderdetail_order_id` (`order_id`),
  KEY `fk_orderdetail_menudetail_id` (`menu_detail_id`),
  CONSTRAINT `fk_orderdetail_menudetail_id` FOREIGN KEY (`menu_detail_id`) REFERENCES `menu_detail` (`menu_detail_id`),
  CONSTRAINT `fk_orderdetail_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,1,1,'김싸피',2,'2023-11-22 05:20:18',NULL),(2,1,5,'홍싸피',3,'2023-11-22 05:20:32','2023-11-22 05:27:07'),(3,2,264,'박정훈',1,'2023-11-22 08:47:07',NULL),(4,4,52,'박정훈',1,'2023-11-22 08:47:55',NULL),(5,5,252,'ㅈㅂㄷ',1,'2023-11-22 08:50:13',NULL),(6,6,252,'ㅂㅈㄷ',1,'2023-11-22 08:50:56',NULL),(7,6,252,'qwe',1,'2023-11-22 08:54:02',NULL),(8,6,255,'zxc',1,'2023-11-22 08:54:08',NULL),(9,7,276,'qwew',1,'2023-11-22 08:56:54',NULL),(10,7,276,'zxcv',1,'2023-11-22 08:56:58',NULL),(11,7,255,'asd',1,'2023-11-22 08:57:01',NULL),(12,2,252,'dfgdg',1,'2023-11-22 08:57:15',NULL),(13,2,170,'dfsdffs',1,'2023-11-22 08:57:39',NULL),(14,8,255,'zc',1,'2023-11-22 08:57:48',NULL),(15,8,279,'qw',1,'2023-11-22 08:57:51',NULL),(16,8,267,'as',1,'2023-11-22 08:57:54',NULL),(17,8,152,'123123',1,'2023-11-22 08:58:10',NULL),(18,10,52,'ㅂㅈㄷㅂㅈㄷ',1,'2023-11-23 06:23:51',NULL),(19,10,91,'ㅁㄴㅇㅁㄴㅇ',1,'2023-11-23 06:23:56',NULL);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
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

-- Dump completed on 2023-11-23 16:45:43
