-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: exam1
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `exam1`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `exam1` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `exam1`;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `b_no` int DEFAULT NULL,
  `b_type` varchar(11) DEFAULT NULL,
  `b_name` varchar(10) DEFAULT NULL,
  `b_author` varchar(10) DEFAULT NULL,
  `b_publish` varchar(10) DEFAULT NULL,
  `b_price` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (445501,'TP3/12','数据库导论','王强','科学出版社','17.50'),(445502,'TP3/12','数据库导论','王强','科学出版社','17.50'),(445503,'TP3/12','数据库导论','王强','科学出版社','17.50'),(332211,'TP5/10','计算机基础','李伟','高等教育出版社','18.00'),(112266,'TP3/12','FoxBASE','张三','电子工业出版社','23.60'),(665544,'TS7/21','高等数学','刘明','高等教育出版社','20.00'),(114455,'TR9/12','线性代数','孙业','北京大学出版社','20.80'),(113388,'TR7/90','大学英语','胡玲','清华大学出版社','12.50'),(446601,'TP4/13','数据库基础','马凌云','人民邮电出版社','22.50'),(446602,'TP4/13','数据库基础','马凌云','人民邮电出版社','22.50'),(446603,'TP4/13','数据库基础','马凌云','人民邮电出版社','22.50'),(449901,'TP4/14','FoxPro大全','周虹','科学出版社','32.50'),(449902,'TP4/14','FoxPro大全','周虹','科学出版社','32.50'),(118801,'TP4/15','计算机网络','黄力钧','高等教育出版社','21.80'),(118802,'TP4/15','计算机网络','黄力钧','高等教育出版社','21.80');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrow` (
  `r_no` int DEFAULT NULL,
  `b_no` int DEFAULT NULL,
  `b_time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
INSERT INTO `borrow` VALUES (112,445501,'2020-03-19'),(125,332211,'2020-02-12'),(111,445503,'2020-08-21'),(112,112266,'2020-03-14'),(114,665544,'2020-10-21'),(120,114455,'2020-11-02'),(120,118801,'2020-10-18'),(119,446603,'2020-12-12'),(112,449901,'2020-10-23'),(115,449902,'2020-08-21'),(118,118801,'2020-09-10');
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reader`
--

DROP TABLE IF EXISTS `reader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reader` (
  `r_no` int DEFAULT NULL,
  `r_unit` varchar(11) DEFAULT NULL,
  `r_name` varchar(10) DEFAULT NULL,
  `r_sex` varchar(10) DEFAULT NULL,
  `r_pro` varchar(10) DEFAULT NULL,
  `r_address` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reader`
--

LOCK TABLES `reader` WRITE;
/*!40000 ALTER TABLE `reader` DISABLE KEYS */;
INSERT INTO `reader` VALUES (111,'信息系','王维利','女','教授','1号楼'),(112,'财会系','李立','男','副教授','2号楼'),(113,'经济系','张大三','男','讲师','3号楼'),(114,'信息系','周华发','男','讲师','1号楼'),(115,'信息系','赵正义','男','工程师','1号楼'),(116,'信息系','李明大','男','副教授','1号楼'),(117,'计算机系','李小峰','男','助教','1号楼'),(118,'计算机系','许鹏飞','男','教授','1号楼'),(119,'计算机系','刘大李龙','男','副教授','4号楼'),(120,'国际贸易','李雪','男','副教授','4号楼'),(121,'国际贸易','李爽','女','讲师','4号楼'),(122,'国际贸易','王纯','女','讲师','4号楼'),(123,'财会系','沈小霞','女','助教','2号楼'),(124,'财会系','朱海','男','讲师','2号楼'),(125,'财会系','马英明李','男','副教授','2号楼');
/*!40000 ALTER TABLE `reader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `exam2`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `exam2` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `exam2`;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `BNO` varchar(12) NOT NULL,
  `BNAME` varchar(12) DEFAULT NULL,
  `AUTHOR` varchar(12) DEFAULT NULL,
  `PRICE` varchar(12) DEFAULT NULL,
  `QUANTITY` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`BNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES ('1100011','计算机网络','阿一','86.9','10'),('1100022','红楼梦','阿二','53.6','5'),('1100033','组合数学','阿三','26.3','15'),('1100044','水浒','阿四','98.7','3'),('1100055','三国','阿五','46.8','2'),('1100066','计算方法','阿一','59.6','8'),('1100077','计算方法习题集','阿一','23.5','8');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrows`
--

DROP TABLE IF EXISTS `borrows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrows` (
  `CNO` varchar(12) DEFAULT NULL,
  `BNO` varchar(12) DEFAULT NULL,
  `RDATE` date DEFAULT NULL,
  KEY `CNO` (`CNO`),
  KEY `BNO` (`BNO`),
  CONSTRAINT `borrows_ibfk_1` FOREIGN KEY (`CNO`) REFERENCES `card` (`CNO`),
  CONSTRAINT `borrows_ibfk_2` FOREIGN KEY (`BNO`) REFERENCES `books` (`BNO`),
  CONSTRAINT `borrows_ibfk_3` FOREIGN KEY (`BNO`) REFERENCES `books` (`BNO`),
  CONSTRAINT `borrows_ibfk_4` FOREIGN KEY (`BNO`) REFERENCES `books` (`BNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrows`
--

LOCK TABLES `borrows` WRITE;
/*!40000 ALTER TABLE `borrows` DISABLE KEYS */;
INSERT INTO `borrows` VALUES ('sx001','1100011','2021-10-22'),('sx001','1100022','2021-10-22'),('sx001','1100033','2021-10-22'),('sx001','1100044','2021-10-22'),('sx001','1100055','2021-10-22'),('sx001','1100066','2020-10-22'),('sx002','1100066','2020-07-09'),('sx002','1100077','2020-07-09'),('sx003','1100066','2020-06-15'),('sx004','1100055','2020-06-15'),('sx003','1100033','2021-01-14');
/*!40000 ALTER TABLE `borrows` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `CNO` varchar(12) NOT NULL,
  `NAME` varchar(12) DEFAULT NULL,
  `CLASS` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`CNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES ('008','张铭','c02'),('sx001','汪伟','c01'),('sx002','张三','c02'),('sx003','李四','c02'),('sx004','王五','c02'),('sx005','小明','c02'),('sx006','小红','c02');
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-03 22:14:28
