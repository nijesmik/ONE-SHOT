-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: oneshot
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `brand_id` int NOT NULL AUTO_INCREMENT COMMENT '브랜드 기본 PK',
  `brand_name` varchar(255) NOT NULL COMMENT '브랜드 이름',
  `logo` varchar(255) NOT NULL COMMENT '브랜드 로고',
  `brand_url` varchar(255) DEFAULT NULL COMMENT '브랜드 공식 홈페이지 url',
  `service` tinyint(1) NOT NULL DEFAULT '0' COMMENT '서비스 여부 : 0 서비스 안함 | 1 서비스 함',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '브랜드 row 생성 시각',
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 브랜드 row 수정 시각',
  PRIMARY KEY (`brand_id`),
  UNIQUE KEY `brand_name` (`brand_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'메머드커피','https://www.mmthcoffee.com/img/common/f_logo.png','https://www.mmthcoffee.com',1,'2023-11-22 02:45:41','2023-11-23 05:16:35'),(2,'스타벅스','https://i.namu.wiki/i/9p8OVxJTce_f2HnuZF1QOU6qMSHqXBHdkcx3q_hlGxvhcyaOXKxBVyoDkeg-Cb4Nx2p60W0AUh6RzjAH59vHwQ.svg','https://www.starbucks.co.kr',1,'2023-11-22 02:45:41','2023-11-23 05:16:35'),(3,'바나프레소','https://www.banapresso.com/from_open_storage?ws=fprocess&file=banapresso/open/logo/h_logo_3138e3904929.png','https://banapresso.com',1,'2023-11-22 02:45:41','2023-11-23 05:16:35'),(4,'폴바셋','https://i.namu.wiki/i/iXdsl5GbzMVXOT0e2-UqWuTA324MKepW5nYBL2E2v39Kkyt9VK1DtwH7SsaKcQO19OIEg928k_7mUI712LVyvA.svg','https://www.baristapaulbassett.co.kr',0,'2023-11-22 02:45:41',NULL),(5,'투썸플레이스','https://i.namu.wiki/i/2n8YMYmAqaahZlqf99M5TIJtUTAxcgwupMZntBVnZRgpJZ98wJSivLH8BpRKHedcuC18fPzRsMaJmC9ctL5EBQ.svg','https://www.twosome.co.kr',0,'2023-11-22 02:45:41',NULL),(6,'이디야커피','https://i.namu.wiki/i/_Zid1rr0H_EegrxIgq_dfrvBT64kiXN10FXULMA0WhDjrADaQW094ibd1QtPkttWlJcAUmz33wI4vkZ6YyGKCw.svg','https://ediya.com',0,'2023-11-22 02:45:41',NULL),(7,'메가커피','https://img.79plus.co.kr/megahp/common/img/bi_logo1.png','https://www.mega-mgccoffee.com',0,'2023-11-22 02:45:41',NULL),(8,'컴포즈커피','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGxkOrtKR_kNJcmNyv2uHQp5M4VEsSTmDAth-oH0HsK5nv1imq7OTO88pJBw_N5taQAO4&usqp=CAU','https://composecoffee.com',0,'2023-11-22 02:45:41',NULL),(9,'더벤티','https://www.theventi.co.kr/new2022/images/sub/bi_1-xs.png','https://www.theventi.co.kr/',0,'2023-11-22 02:45:41',NULL),(10,'빽다방','https://scontent-ssn1-1.xx.fbcdn.net/v/t39.30808-6/327294194_929628688477291_6295134427025366399_n.png?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=rFhYC_wYeD8AX-HW7Bv&_nc_oc=AQmckRIcUXK4yoxpf7U4gB4iP5S8fpeLi2yeFNxyOz8AMIzi_mMTr6u-0RhpcvhmpoQ&_nc_ht=sconten','https://paikdabang.com',0,'2023-11-22 02:45:41',NULL);
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-23 14:17:58
