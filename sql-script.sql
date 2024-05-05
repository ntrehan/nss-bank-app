CREATE DATABASE  IF NOT EXISTS `nss_proj` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `nss_proj`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: nss_proj
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `nss_accounts`
--

DROP TABLE IF EXISTS `nss_accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nss_accounts` (
  `opendate` date NOT NULL,
  `state` varchar(2) NOT NULL,
  `zipcode` int NOT NULL,
  `accountnumber` varchar(10) NOT NULL,
  `accounttype` varchar(10) NOT NULL,
  `customerid` varchar(10) NOT NULL,
  `city` varchar(20) NOT NULL,
  `street` varchar(20) NOT NULL,
  PRIMARY KEY (`accountnumber`),
  KEY `FK787pf0aq0o2e9n8grbx2d5umx` (`customerid`),
  CONSTRAINT `FK787pf0aq0o2e9n8grbx2d5umx` FOREIGN KEY (`customerid`) REFERENCES `nss_customer` (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nss_accounts`
--

LOCK TABLES `nss_accounts` WRITE;
/*!40000 ALTER TABLE `nss_accounts` DISABLE KEYS */;
/*!40000 ALTER TABLE `nss_accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nss_checking`
--

DROP TABLE IF EXISTS `nss_checking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nss_checking` (
  `servicecharge` double NOT NULL,
  `accountnumber` varchar(10) NOT NULL,
  PRIMARY KEY (`accountnumber`),
  CONSTRAINT `FK1uxqvegcomt794lvml2r085jd` FOREIGN KEY (`accountnumber`) REFERENCES `nss_accounts` (`accountnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nss_checking`
--

LOCK TABLES `nss_checking` WRITE;
/*!40000 ALTER TABLE `nss_checking` DISABLE KEYS */;
/*!40000 ALTER TABLE `nss_checking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nss_customer`
--

DROP TABLE IF EXISTS `nss_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nss_customer` (
  `state` varchar(2) NOT NULL,
  `zipcode` int NOT NULL,
  `customerid` varchar(10) NOT NULL,
  `city` varchar(20) NOT NULL,
  `street` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('ADMIN','USER') NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nss_customer`
--

LOCK TABLES `nss_customer` WRITE;
/*!40000 ALTER TABLE `nss_customer` DISABLE KEYS */;
INSERT INTO `nss_customer` VALUES ('NY',11209,'ADMIN001','New York','123 Main St','Johnny','','ADMIN');
/*!40000 ALTER TABLE `nss_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nss_ed_institute`
--

DROP TABLE IF EXISTS `nss_ed_institute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nss_ed_institute` (
  `state` varchar(2) NOT NULL,
  `zipcode` int NOT NULL,
  `universityid` varchar(10) NOT NULL,
  `city` varchar(20) NOT NULL,
  `street` varchar(20) NOT NULL,
  `universityname` varchar(80) NOT NULL,
  PRIMARY KEY (`universityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nss_ed_institute`
--

LOCK TABLES `nss_ed_institute` WRITE;
/*!40000 ALTER TABLE `nss_ed_institute` DISABLE KEYS */;
/*!40000 ALTER TABLE `nss_ed_institute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nss_employee`
--

DROP TABLE IF EXISTS `nss_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nss_employee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','USER') NOT NULL,
  `employee_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nss_employee`
--

LOCK TABLES `nss_employee` WRITE;
/*!40000 ALTER TABLE `nss_employee` DISABLE KEYS */;
INSERT INTO `nss_employee` VALUES (1,'beingmudassir@gmail.com','Syed','$2a$10$ZiRAOeNHrYmrC0vF8PlXxuEgCd4N0tBI8oLQ5fotN.kNzi2FATogS',NULL,'ADMIN','68765b05-4207-3b40-b8a6-a5b547b3aade');
/*!40000 ALTER TABLE `nss_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nss_home_loan`
--

DROP TABLE IF EXISTS `nss_home_loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nss_home_loan` (
  `housebuiltyear` int NOT NULL,
  `yearlyinsurancepremium` double NOT NULL,
  `accountnumber` varchar(10) NOT NULL,
  `homeinsuranceaccountno` varchar(10) NOT NULL,
  `insurancecompanyname` varchar(50) NOT NULL,
  PRIMARY KEY (`accountnumber`),
  CONSTRAINT `FK7rve1ygiqtac5hp1lh20eieqb` FOREIGN KEY (`accountnumber`) REFERENCES `nss_loan` (`accountnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nss_home_loan`
--

LOCK TABLES `nss_home_loan` WRITE;
/*!40000 ALTER TABLE `nss_home_loan` DISABLE KEYS */;
/*!40000 ALTER TABLE `nss_home_loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nss_loan`
--

DROP TABLE IF EXISTS `nss_loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nss_loan` (
  `loanamount` double NOT NULL,
  `loanmonths` int NOT NULL,
  `loanrate` double NOT NULL,
  `accountnumber` varchar(10) NOT NULL,
  `loanpayment` varchar(20) NOT NULL,
  `loantype` varchar(20) NOT NULL,
  PRIMARY KEY (`accountnumber`),
  CONSTRAINT `FKgthqbssvev4i1dk08lcsnileh` FOREIGN KEY (`accountnumber`) REFERENCES `nss_accounts` (`accountnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nss_loan`
--

LOCK TABLES `nss_loan` WRITE;
/*!40000 ALTER TABLE `nss_loan` DISABLE KEYS */;
/*!40000 ALTER TABLE `nss_loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nss_savings`
--

DROP TABLE IF EXISTS `nss_savings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nss_savings` (
  `interestrate` double NOT NULL,
  `accountnumber` varchar(10) NOT NULL,
  PRIMARY KEY (`accountnumber`),
  CONSTRAINT `FKsg26w596tone9km87sl3fj9m5` FOREIGN KEY (`accountnumber`) REFERENCES `nss_accounts` (`accountnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nss_savings`
--

LOCK TABLES `nss_savings` WRITE;
/*!40000 ALTER TABLE `nss_savings` DISABLE KEYS */;
/*!40000 ALTER TABLE `nss_savings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nss_student_loan`
--

DROP TABLE IF EXISTS `nss_student_loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nss_student_loan` (
  `expectedgraduration` date NOT NULL,
  `accountnumber` varchar(10) NOT NULL,
  `studentid` varchar(10) NOT NULL,
  `universityid` varchar(10) NOT NULL,
  `educationlevel` varchar(20) NOT NULL,
  PRIMARY KEY (`accountnumber`),
  CONSTRAINT `FK4yk1uk4gxfhy79vt4c2ce06mb` FOREIGN KEY (`accountnumber`) REFERENCES `nss_loan` (`accountnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nss_student_loan`
--

LOCK TABLES `nss_student_loan` WRITE;
/*!40000 ALTER TABLE `nss_student_loan` DISABLE KEYS */;
/*!40000 ALTER TABLE `nss_student_loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nss_users`
--

DROP TABLE IF EXISTS `nss_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nss_users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `role` enum('ADMIN','USER') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_p6kx1f1s3lhknx214j3mt94o9` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nss_users`
--

LOCK TABLES `nss_users` WRITE;
/*!40000 ALTER TABLE `nss_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `nss_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-04 20:27:11
