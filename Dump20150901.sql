-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: example
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_amphur`
--

DROP TABLE IF EXISTS `tbl_amphur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_amphur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_amphur`
--

LOCK TABLES `tbl_amphur` WRITE;
/*!40000 ALTER TABLE `tbl_amphur` DISABLE KEYS */;
INSERT INTO `tbl_amphur` VALUES (1,'A001','พระนคร',1,0,NULL,NULL,NULL,NULL),(2,'A002','บางงรัก',1,0,NULL,NULL,NULL,NULL),(3,'A003','เมืองนนทบุรี',2,0,NULL,NULL,NULL,NULL),(4,'A004','ปากเกร็ด',2,0,NULL,NULL,NULL,NULL),(5,'A005','เมืองปทุมธานี',3,0,NULL,NULL,NULL,NULL),(6,'A006','รังสิต',3,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_amphur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_attachment`
--

DROP TABLE IF EXISTS `tbl_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `attach_by` int(11) DEFAULT NULL,
  `attach_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=tis620;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_attachment`
--

LOCK TABLES `tbl_attachment` WRITE;
/*!40000 ALTER TABLE `tbl_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_attachment_item`
--

DROP TABLE IF EXISTS `tbl_attachment_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_attachment_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attachment_id` int(11) DEFAULT NULL,
  `attachment_type` int(11) DEFAULT NULL,
  `attachment_file` varchar(1000) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=tis620;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_attachment_item`
--

LOCK TABLES `tbl_attachment_item` WRITE;
/*!40000 ALTER TABLE `tbl_attachment_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_attachment_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_attachment_type`
--

DROP TABLE IF EXISTS `tbl_attachment_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_attachment_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=tis620;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_attachment_type`
--

LOCK TABLES `tbl_attachment_type` WRITE;
/*!40000 ALTER TABLE `tbl_attachment_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_attachment_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_branch`
--

DROP TABLE IF EXISTS `tbl_branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_branch`
--

LOCK TABLES `tbl_branch` WRITE;
/*!40000 ALTER TABLE `tbl_branch` DISABLE KEYS */;
INSERT INTO `tbl_branch` VALUES (1,'B001','สำนักงานใหญ่',0,NULL,NULL,NULL,NULL),(2,'B002','สาขาภาคกลาง',0,NULL,NULL,NULL,NULL),(3,'B003','สาขาภาคเหนือ',0,NULL,NULL,NULL,NULL),(4,'B004','สาขาภาคใต้',0,NULL,NULL,NULL,NULL),(5,'B005','สาขาภาคตะวันออกเฉียงเหนือ',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_children`
--

DROP TABLE IF EXISTS `tbl_children`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_children` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `first_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `last_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `company` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `position` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_children`
--

LOCK TABLES `tbl_children` WRITE;
/*!40000 ALTER TABLE `tbl_children` DISABLE KEYS */;
INSERT INTO `tbl_children` VALUES (23,2,1,'11','11','11','11',11,0,NULL,NULL,NULL,NULL),(25,20,5,'11','11','11','11',11,0,NULL,NULL,NULL,NULL),(26,20,4,'22','22','22','22',22,0,NULL,NULL,NULL,NULL),(27,21,4,'11','11','11','11',11,0,NULL,NULL,NULL,NULL),(28,21,5,'22','22','22','22',22,0,NULL,NULL,NULL,NULL),(29,63,5,'33','33','33','33',33,0,NULL,NULL,NULL,NULL),(30,63,4,'22','22','22','22',22,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_children` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_claim_upload`
--

DROP TABLE IF EXISTS `tbl_claim_upload`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_claim_upload` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `claim_desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `claim_date` varchar(8) COLLATE tis620_bin DEFAULT NULL,
  `claim_time` varchar(5) COLLATE tis620_bin DEFAULT NULL,
  `claim_location` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  `claim_reason` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_claim_upload`
--

LOCK TABLES `tbl_claim_upload` WRITE;
/*!40000 ALTER TABLE `tbl_claim_upload` DISABLE KEYS */;
INSERT INTO `tbl_claim_upload` VALUES (1,'C001','เทเวศประกันภัย','20150811','11:11','พระนคร11',1,NULL,NULL,NULL,NULL,'ทดสอบ1'),(2,'C002','กรุงเทพประกันภัย','20150812','11:12','สาทร',0,NULL,NULL,NULL,NULL,'ทดสอบ2'),(3,'C003','ทิพยประกันภัย','20150813','11:13','ห้วยขวาง',0,NULL,NULL,NULL,NULL,'ทดสอบ3'),(4,'C004','ไทยรับประกันภัยต่อ','20150814','11:14','ห้วยขวาง',0,NULL,NULL,NULL,NULL,'ทดสอบ4'),(5,'C005','ไทยรับประกันภัยต่อ','20150814','11:14','ห้วยขวาง',0,NULL,NULL,NULL,NULL,'ทดสอบ4');
/*!40000 ALTER TABLE `tbl_claim_upload` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customer`
--

DROP TABLE IF EXISTS `tbl_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `company` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `customer_type` char(1) COLLATE tis620_bin DEFAULT NULL,
  `contact_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `tel` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `mobile` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `fax` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `home_page` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `email` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `address_no` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `moo` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `soi` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `road` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `district` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL,
  `amphur_id` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer`
--

LOCK TABLES `tbl_customer` WRITE;
/*!40000 ALTER TABLE `tbl_customer` DISABLE KEYS */;
INSERT INTO `tbl_customer` VALUES (1,NULL,NULL,NULL,'P',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,'P',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(3,NULL,NULL,NULL,'P',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(4,'C01','11','11','C','11','11','11','11','11','11','11','11','11','11',NULL,1,1,0,NULL,NULL,NULL,NULL),(7,'C02','11','11','C','11','11','11','11','11','11','11','11','11','11',NULL,1,1,0,NULL,NULL,NULL,NULL),(9,'C03','11','11','P','11','11','11','11','11','11','11','11','11','11',NULL,1,2,0,NULL,NULL,NULL,NULL),(10,'C05','11','11','C','11','11','11','11','11','11','11','11','11','11',NULL,2,4,4,NULL,NULL,NULL,NULL),(11,'C07','11','111','P','11','11','11','11','11','11','11','11','11','11',NULL,3,5,2,NULL,NULL,NULL,NULL),(12,'T04','11','11','C','11','11','11','1','11','11','11','11','11','11',NULL,1,2,0,NULL,NULL,NULL,NULL),(13,'S001','11','11','P','11','11','11','11','11','11','11','11','11','11',NULL,1,1,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_department`
--

DROP TABLE IF EXISTS `tbl_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_department`
--

LOCK TABLES `tbl_department` WRITE;
/*!40000 ALTER TABLE `tbl_department` DISABLE KEYS */;
INSERT INTO `tbl_department` VALUES (1,'D001','ฝ่ายพัฒนาระบบ',0,NULL,NULL,NULL,NULL),(2,'D002','ฝ่ายไอที',0,NULL,NULL,NULL,NULL),(3,'D003','ฝ่ายบัญชี',0,NULL,NULL,NULL,NULL),(4,'D004','ฝ่ายทรัพยากรบุคคล',0,NULL,NULL,NULL,NULL),(5,'D005','ฝ่ายขาย',0,NULL,NULL,NULL,NULL),(6,'D006','ฝ่ายกฎหมาย',0,NULL,NULL,NULL,NULL),(7,'D007','ฝ่ายผลิต',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_education`
--

DROP TABLE IF EXISTS `tbl_education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `education_level_id` int(11) DEFAULT NULL,
  `university` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `major` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `gpa` decimal(10,0) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_education__employee_idx` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_education`
--

LOCK TABLES `tbl_education` WRITE;
/*!40000 ALTER TABLE `tbl_education` DISABLE KEYS */;
INSERT INTO `tbl_education` VALUES (7,2,2,'22','22',22,0,NULL,NULL,NULL,NULL),(17,15,1,'33','33',33,0,NULL,NULL,NULL,NULL),(18,15,3,'44','44',44,0,NULL,NULL,NULL,NULL),(20,18,6,'44','44',44,0,NULL,NULL,NULL,NULL),(21,19,4,'33','33',33,0,NULL,NULL,NULL,NULL),(22,19,1,'44','44',44,0,NULL,NULL,NULL,NULL),(23,34,1,'11','11',11,0,NULL,NULL,NULL,NULL),(24,45,3,'มหาวิทยาลัยราชภัฎบ้านสมเด็จ','คอมพิวเตอร์ธุรกิจ',3,0,NULL,NULL,NULL,NULL),(25,51,3,'มหาวิทยาลัยราชภัฎบ้านสมเด็จ','คอมพิวเตอร์ธุรกิจ',3,0,NULL,NULL,NULL,NULL),(26,52,3,'ทดสอบ','ทดสอบ',4,0,NULL,NULL,NULL,NULL),(36,62,7,'11','11',11,0,NULL,NULL,NULL,NULL),(37,21,7,'11','11',11,0,NULL,NULL,NULL,NULL),(38,63,2,'22','22',22,0,NULL,NULL,NULL,NULL),(39,63,1,'11','11',11,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_education_level`
--

DROP TABLE IF EXISTS `tbl_education_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_education_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_education_level`
--

LOCK TABLES `tbl_education_level` WRITE;
/*!40000 ALTER TABLE `tbl_education_level` DISABLE KEYS */;
INSERT INTO `tbl_education_level` VALUES (1,'E01','ปริญญาเอก',1,NULL,NULL,NULL,NULL),(2,'E02','ปริญญาโท',1,NULL,NULL,NULL,NULL),(3,'E03','ปริญญาตรี',1,NULL,NULL,NULL,NULL),(4,'E04','ปอนุปริญญา',1,NULL,NULL,NULL,NULL),(5,'E05','ประกาศนียบัตรวิชาชีพ',1,NULL,NULL,NULL,NULL),(6,'E06','มัธยมศึกษา',1,NULL,NULL,NULL,NULL),(7,'E07','ประถมศึกษา',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_education_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_employee`
--

DROP TABLE IF EXISTS `tbl_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `first_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `last_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `birth_date` datetime DEFAULT NULL,
  `salary` decimal(10,0) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  `address_no` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `road` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `soi` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `moo` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `district` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `amphur_id` int(11) DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `father_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `father_occupation` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `father_company` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `father_tel` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `father_address` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `mother_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `mother_occupation` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `mother_company` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `mother_tel` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `mother_address` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `marital_status` char(1) COLLATE tis620_bin DEFAULT NULL,
  `supouse_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `supouse_occupation` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `supouse_company` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `supouse_tel` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `supouse_address` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `contact_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `contact_address` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `contact_tel` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `contact_relation` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_employee`
--

LOCK TABLES `tbl_employee` WRITE;
/*!40000 ALTER TABLE `tbl_employee` DISABLE KEYS */;
INSERT INTO `tbl_employee` VALUES (2,'11',1,'11','11','1472-08-28 00:00:00',11,40,NULL,NULL,NULL,NULL,1,'11','11','11','11','11',1,1,NULL,NULL,'11','11','11','11','11','11','11','11','11','11','S','11','11','11','11','11','11','11','111','11'),(15,'22',2,'22','22','1472-08-20 00:00:00',22,1,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'44',1,'44','44','1472-08-28 00:00:00',44,1,NULL,NULL,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'33',3,'33','33','1472-08-28 00:00:00',33,1,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,NULL,4,NULL,NULL,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'52002',1,'11',NULL,'1472-08-28 00:00:00',11,2,NULL,NULL,NULL,NULL,1,'11','11','11','11','11',1,1,1,1,'11','11','11','11','11','111','11','11','11','11','S','11','11','11','11','11','11','11','11','11'),(22,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,NULL,1,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(33,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,NULL,NULL,NULL,NULL,'1472-08-19 00:00:00',NULL,1,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(37,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(40,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(45,'56046',1,'อนวัช','จารุศิริพจน์','1442-08-17 00:00:00',29200,1,NULL,NULL,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(46,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(47,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(48,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(49,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(50,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(51,'56146',1,'อนวัช','จารุศิริพจน์','1472-08-13 00:00:00',23000,2,NULL,NULL,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(52,'56007',1,'อำนาจ','จันทัด','1472-08-06 00:00:00',40000,1,NULL,NULL,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(62,'56008',1,'11','11','1472-08-12 00:00:00',11,8,NULL,NULL,NULL,NULL,4,'11','11','11','11','11',1,1,1,4,'11','11','11','11','11','11','11','11','11','11','M','11','11','11','11','11','11','11','11','11'),(63,'S00001',3,'11','11','1472-08-30 17:00:00',11,1,NULL,NULL,NULL,NULL,1,'11','11','11','11','11',2,1,1,1,'11','11','11','11','11','11','11','11','11','11','M','11','11','11','11','11','11','11','11','11');
/*!40000 ALTER TABLE `tbl_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_employee_hobby`
--

DROP TABLE IF EXISTS `tbl_employee_hobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_employee_hobby` (
  `employee_id` int(11) NOT NULL,
  `hobby_id` int(11) NOT NULL,
  PRIMARY KEY (`employee_id`,`hobby_id`)
) ENGINE=InnoDB DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_employee_hobby`
--

LOCK TABLES `tbl_employee_hobby` WRITE;
/*!40000 ALTER TABLE `tbl_employee_hobby` DISABLE KEYS */;
INSERT INTO `tbl_employee_hobby` VALUES (2,7),(2,8),(15,7),(15,8),(15,9),(18,7),(18,9),(19,8),(20,8),(21,8),(31,7),(34,7),(34,9),(45,7),(45,8),(45,9),(51,7),(51,8),(51,9),(52,9),(62,8),(63,7),(63,8),(63,9);
/*!40000 ALTER TABLE `tbl_employee_hobby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_employee_language`
--

DROP TABLE IF EXISTS `tbl_employee_language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_employee_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `language_id` int(11) DEFAULT NULL,
  `flag_reading` char(1) COLLATE tis620_bin DEFAULT NULL,
  `flag_writing` char(1) COLLATE tis620_bin DEFAULT NULL,
  `flag_speaking` char(1) COLLATE tis620_bin DEFAULT NULL,
  `flag_listening` char(1) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_employee_language`
--

LOCK TABLES `tbl_employee_language` WRITE;
/*!40000 ALTER TABLE `tbl_employee_language` DISABLE KEYS */;
INSERT INTO `tbl_employee_language` VALUES (13,2,1,'V','V','V','V',0,NULL,NULL,NULL,NULL),(14,62,4,'V','V','V','V',0,NULL,NULL,NULL,NULL),(15,21,6,'G','G','G','G',0,NULL,NULL,NULL,NULL),(16,63,1,'G','G','G','G',0,NULL,NULL,NULL,NULL),(17,63,2,'V','V','G','V',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_employee_language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_equipment`
--

DROP TABLE IF EXISTS `tbl_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=tis620;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_equipment`
--

LOCK TABLES `tbl_equipment` WRITE;
/*!40000 ALTER TABLE `tbl_equipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_experience`
--

DROP TABLE IF EXISTS `tbl_experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_experience` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `company` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `position` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `reponsiability` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `hired_date` datetime DEFAULT NULL,
  `resigned_date` datetime DEFAULT NULL,
  `salary` decimal(10,0) DEFAULT NULL,
  `reason_of_regsign` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_experience`
--

LOCK TABLES `tbl_experience` WRITE;
/*!40000 ALTER TABLE `tbl_experience` DISABLE KEYS */;
INSERT INTO `tbl_experience` VALUES (1,51,'Deves Insurance','Developer','test','1472-08-01 00:00:00','1472-08-31 00:00:00',15000,'11',0,NULL,NULL,NULL,NULL),(2,51,'Thai Reinsurance','IT Developer','test','1472-07-01 00:00:00','1472-07-31 00:00:00',14000,'12',0,NULL,NULL,NULL,NULL),(3,52,'Deves Insurance','Programmer','test','1472-07-01 00:00:00','1472-08-31 00:00:00',30000,'ทดสอบ',0,NULL,NULL,NULL,NULL),(15,62,'11','111','11','1472-08-26 00:00:00','1472-08-31 00:00:00',11,'11',0,NULL,NULL,NULL,NULL),(16,21,'11','11','11','1472-08-28 00:00:00','1472-08-28 00:00:00',11,'11',0,NULL,NULL,NULL,NULL),(17,2,'11','11','11','1472-07-31 17:00:00','1472-08-30 17:00:00',11,'11',0,NULL,NULL,NULL,NULL),(18,2,'22','22','22','1472-07-31 17:00:00','1472-08-30 17:00:00',22,'22',0,NULL,NULL,NULL,NULL),(19,63,'22','22','22','1472-07-31 17:00:00','1472-08-30 17:00:00',222,'22',0,NULL,NULL,NULL,NULL),(20,63,'11','11','11','1472-07-31 17:00:00','1472-08-30 17:00:00',11,'11',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_hobby`
--

DROP TABLE IF EXISTS `tbl_hobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_hobby` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_hobby`
--

LOCK TABLES `tbl_hobby` WRITE;
/*!40000 ALTER TABLE `tbl_hobby` DISABLE KEYS */;
INSERT INTO `tbl_hobby` VALUES (7,'H01','เล่นดนตรี',0,NULL,NULL,NULL,NULL),(8,'H02','เล่นกีฬา',0,NULL,NULL,NULL,NULL),(9,'H03','อ่านหนังสือ',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_hobby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_language`
--

DROP TABLE IF EXISTS `tbl_language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_language`
--

LOCK TABLES `tbl_language` WRITE;
/*!40000 ALTER TABLE `tbl_language` DISABLE KEYS */;
INSERT INTO `tbl_language` VALUES (1,'L001','ไทย',0,NULL,NULL,NULL,NULL),(2,'L002','อังกฤษ',0,NULL,NULL,NULL,NULL),(3,'L003','จีน',0,NULL,NULL,NULL,NULL),(4,'L004','ญี่ปุ่น',0,NULL,NULL,NULL,NULL),(5,'L005','ฝรั่งเศส',0,NULL,NULL,NULL,NULL),(6,'L006','เยอรมัน',0,NULL,NULL,NULL,NULL),(7,'L007','สเปน',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_order`
--

DROP TABLE IF EXISTS `tbl_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `require_date` datetime DEFAULT NULL,
  `shipper_date` datetime DEFAULT NULL,
  `request_by` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `approve_by` int(11) DEFAULT NULL,
  `approve_date` datetime DEFAULT NULL,
  `shipper_id` int(11) DEFAULT NULL,
  `freight` decimal(10,0) DEFAULT NULL,
  `status` char(1) COLLATE tis620_bin DEFAULT NULL,
  `shipp_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `ship_address_no` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `ship_moo` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `ship_soi` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `ship_road` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `ship_district` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `ship_amphur_id` int(11) DEFAULT NULL,
  `ship_province_id` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_order`
--

LOCK TABLES `tbl_order` WRITE;
/*!40000 ALTER TABLE `tbl_order` DISABLE KEYS */;
INSERT INTO `tbl_order` VALUES (1,'O0001','11','1472-08-31 17:00:00','1472-08-30 17:00:00','1472-08-30 17:00:00',2,4,18,NULL,NULL,11,'P','11','11','11','11','11','11',1,1,6,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_order_item`
--

DROP TABLE IF EXISTS `tbl_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit_price` decimal(10,0) DEFAULT NULL,
  `discount` decimal(10,0) DEFAULT NULL,
  `total` decimal(10,0) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_order_item`
--

LOCK TABLES `tbl_order_item` WRITE;
/*!40000 ALTER TABLE `tbl_order_item` DISABLE KEYS */;
INSERT INTO `tbl_order_item` VALUES (1,1,1,11,11,111,1,0,NULL,NULL,NULL,NULL),(2,1,4,22,22,22,22,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_position`
--

DROP TABLE IF EXISTS `tbl_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_position`
--

LOCK TABLES `tbl_position` WRITE;
/*!40000 ALTER TABLE `tbl_position` DISABLE KEYS */;
INSERT INTO `tbl_position` VALUES (1,'P01','Admin',0,NULL,NULL,NULL,NULL),(2,'P02','System Analysis',0,NULL,NULL,NULL,NULL),(3,'P03','Architect',0,NULL,NULL,NULL,NULL),(4,'P04','Programmer',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_product`
--

DROP TABLE IF EXISTS `tbl_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `unit_price` decimal(10,0) DEFAULT NULL,
  `unit_in_stock` int(11) DEFAULT NULL,
  `unit_on_order` int(11) DEFAULT NULL,
  `active` char(1) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_product`
--

LOCK TABLES `tbl_product` WRITE;
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
INSERT INTO `tbl_product` VALUES (1,'P001','Sumsung222',1,11,11,11,'Y',2,NULL,NULL,NULL,NULL),(2,'P002','IPhone',4,22,22,22,'Y',3,NULL,NULL,NULL,NULL),(4,'P0004','Oppo',1,11,11,11,'Y',0,NULL,NULL,NULL,NULL),(5,'P0005','Nokia',5,11,11,11,'Y',0,NULL,NULL,NULL,NULL),(6,'P0003','11',6,11,11,11,'Y',0,NULL,NULL,NULL,NULL),(7,'P007',NULL,NULL,NULL,NULL,NULL,'Y',6,NULL,NULL,NULL,NULL),(8,'P008',NULL,NULL,NULL,NULL,NULL,'Y',1,NULL,NULL,NULL,NULL),(9,'P009',NULL,NULL,NULL,NULL,NULL,'Y',1,NULL,NULL,NULL,NULL),(10,'P110',NULL,NULL,NULL,NULL,NULL,'Y',1,NULL,NULL,NULL,NULL),(11,'P111',NULL,NULL,NULL,NULL,NULL,'Y',1,NULL,NULL,NULL,NULL),(12,'P112',NULL,NULL,NULL,NULL,NULL,'Y',0,NULL,NULL,NULL,NULL),(13,'P0013','1111',1,11,11,11,'Y',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_product_group`
--

DROP TABLE IF EXISTS `tbl_product_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_product_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_product_group`
--

LOCK TABLES `tbl_product_group` WRITE;
/*!40000 ALTER TABLE `tbl_product_group` DISABLE KEYS */;
INSERT INTO `tbl_product_group` VALUES (1,'PG01','มือถือ',0,NULL,NULL,NULL,NULL),(2,'PG02','โปรแกรม',0,NULL,NULL,NULL,NULL),(3,'PG03','รถยนต์',0,NULL,NULL,NULL,NULL),(4,'PG04','จักรยาน',0,NULL,NULL,NULL,NULL),(5,'PG05','เครื่องดนตรี',0,NULL,NULL,NULL,NULL),(6,'PG06','เฟอร์นิเจอร์',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_product_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_project`
--

DROP TABLE IF EXISTS `tbl_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `type` char(1) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_project`
--

LOCK TABLES `tbl_project` WRITE;
/*!40000 ALTER TABLE `tbl_project` DISABLE KEYS */;
INSERT INTO `tbl_project` VALUES (1,'P001','ทดสอบ 11','B',5,NULL,NULL,NULL,NULL),(3,'1111','1111','A',3,NULL,NULL,NULL,NULL),(4,'P0003','ทดสอบ','A',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_project_item`
--

DROP TABLE IF EXISTS `tbl_project_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_project_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `item_desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_project_item`
--

LOCK TABLES `tbl_project_item` WRITE;
/*!40000 ALTER TABLE `tbl_project_item` DISABLE KEYS */;
INSERT INTO `tbl_project_item` VALUES (2,1,'ทดสอบ ย่อย 2',5,NULL,NULL,NULL,NULL),(3,1,'ทดสอบ ย่อย 3',3,NULL,NULL,NULL,NULL),(4,1,'ทดสอบ ย่อย 4',3,NULL,NULL,NULL,NULL),(7,3,'11',3,NULL,NULL,NULL,NULL),(8,3,'12',3,NULL,NULL,NULL,NULL),(9,4,'22',1,NULL,NULL,NULL,NULL),(10,4,'11',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_project_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_project_item_frm`
--

DROP TABLE IF EXISTS `tbl_project_item_frm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_project_item_frm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_item_id` int(11) DEFAULT NULL,
  `product_group_id` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_project_item_frm`
--

LOCK TABLES `tbl_project_item_frm` WRITE;
/*!40000 ALTER TABLE `tbl_project_item_frm` DISABLE KEYS */;
INSERT INTO `tbl_project_item_frm` VALUES (4,2,2,0,NULL,NULL,NULL,NULL),(5,2,3,0,NULL,NULL,NULL,NULL),(6,3,6,0,NULL,NULL,NULL,NULL),(7,3,1,0,NULL,NULL,NULL,NULL),(8,4,1,0,NULL,NULL,NULL,NULL),(15,7,2,0,NULL,NULL,NULL,NULL),(16,8,5,0,NULL,NULL,NULL,NULL),(17,9,5,0,NULL,NULL,NULL,NULL),(18,9,2,0,NULL,NULL,NULL,NULL),(19,10,2,0,NULL,NULL,NULL,NULL),(20,10,4,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_project_item_frm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_province`
--

DROP TABLE IF EXISTS `tbl_province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_province`
--

LOCK TABLES `tbl_province` WRITE;
/*!40000 ALTER TABLE `tbl_province` DISABLE KEYS */;
INSERT INTO `tbl_province` VALUES (1,'P01','กรุงเทพ',0,NULL,NULL,NULL,NULL),(2,'P02','นนทบุรี',0,NULL,NULL,NULL,NULL),(3,'P03','ปทุมธานี',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_purchase`
--

DROP TABLE IF EXISTS `tbl_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `purchase_date` datetime DEFAULT NULL,
  `description` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `status` char(1) COLLATE tis620_bin DEFAULT NULL,
  `purchase_by` int(11) DEFAULT NULL,
  `approve_by` int(11) DEFAULT NULL,
  `approve_date` datetime DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_purchase`
--

LOCK TABLES `tbl_purchase` WRITE;
/*!40000 ALTER TABLE `tbl_purchase` DISABLE KEYS */;
INSERT INTO `tbl_purchase` VALUES (8,'P0001','1472-08-28 00:00:00',NULL,'P',2,2,'1472-08-28 00:00:00',4,1,1,1,NULL,NULL,NULL,NULL),(9,'P0002',NULL,NULL,'P',18,NULL,NULL,NULL,NULL,NULL,3,NULL,NULL,NULL,NULL),(10,'P0003',NULL,NULL,'P',2,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),(11,'P0004','1472-08-28 00:00:00',NULL,'P',18,18,'1472-08-28 00:00:00',4,1,1,13,NULL,NULL,NULL,NULL),(12,'P0006',NULL,NULL,'P',18,45,NULL,6,1,2,3,NULL,NULL,NULL,NULL),(13,'P003','1472-08-30 17:00:00','11','P',2,21,'1472-08-30 17:00:00',4,1,1,11,NULL,NULL,NULL,NULL),(15,NULL,'1472-08-31 17:00:00','111','P',2,21,'1472-08-31 17:00:00',4,1,1,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_purchase_item`
--

DROP TABLE IF EXISTS `tbl_purchase_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_purchase_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL,
  `type` char(1) COLLATE tis620_bin DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit_price` decimal(10,0) DEFAULT NULL,
  `vat` decimal(10,0) DEFAULT NULL,
  `flag_vat` char(1) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_purchase_item`
--

LOCK TABLES `tbl_purchase_item` WRITE;
/*!40000 ALTER TABLE `tbl_purchase_item` DISABLE KEYS */;
INSERT INTO `tbl_purchase_item` VALUES (15,8,2,NULL,'P',11,11,11,NULL,0,NULL,NULL,NULL,NULL),(16,8,NULL,1,'S',11,11,11,'I',0,NULL,NULL,NULL,NULL),(17,8,NULL,2,'S',22,22,22,'I',0,NULL,NULL,NULL,NULL),(18,8,NULL,3,'S',33,33,33,'I',0,NULL,NULL,NULL,NULL),(19,9,1,NULL,'P',11,11,11,NULL,0,NULL,NULL,NULL,NULL),(20,9,NULL,1,'S',11,11,11,'I',0,NULL,NULL,NULL,NULL),(21,10,NULL,1,'S',11,11,11,'I',0,NULL,NULL,NULL,NULL),(22,11,1,NULL,'P',11,11,11,'I',0,NULL,NULL,NULL,NULL),(23,11,2,NULL,'P',33,33,33,'I',0,NULL,NULL,NULL,NULL),(24,11,NULL,1,'S',11,11,11,'I',0,NULL,NULL,NULL,NULL),(25,11,NULL,2,'S',22,22,22,'I',0,NULL,NULL,NULL,NULL),(27,12,1,NULL,'P',11,11,11,'I',0,NULL,NULL,NULL,NULL),(28,12,NULL,1,'S',22,22,22,'I',0,NULL,NULL,NULL,NULL),(29,11,NULL,3,'S',22,22,22,NULL,0,NULL,NULL,NULL,NULL),(30,13,NULL,1,'S',11,11,11,'I',0,NULL,NULL,NULL,NULL),(31,13,4,NULL,'P',11,11,11,'I',0,NULL,NULL,NULL,NULL),(32,15,4,NULL,'P',11,11,11,'I',0,NULL,NULL,NULL,NULL),(33,15,NULL,2,'S',11,11,11,'I',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_purchase_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_reference`
--

DROP TABLE IF EXISTS `tbl_reference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_reference` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `first_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `last_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `address` varchar(2000) COLLATE tis620_bin DEFAULT NULL,
  `relation` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `tel` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  `company` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `position` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_reference`
--

LOCK TABLES `tbl_reference` WRITE;
/*!40000 ALTER TABLE `tbl_reference` DISABLE KEYS */;
INSERT INTO `tbl_reference` VALUES (10,2,1,'11','11','11','11','11',0,NULL,NULL,NULL,NULL,'11','11'),(11,62,1,'11','11','11','11','11',0,NULL,NULL,NULL,NULL,'11','11'),(12,21,1,'11','11','11','11','11',0,NULL,NULL,NULL,NULL,'11','11'),(13,63,1,'11','11','11','11','11',0,NULL,NULL,NULL,NULL,'11','11'),(14,63,4,'22','22','22','22','22',0,NULL,NULL,NULL,NULL,'22','22');
/*!40000 ALTER TABLE `tbl_reference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_reservation`
--

DROP TABLE IF EXISTS `tbl_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `reservation_by` int(11) DEFAULT NULL,
  `reservation_date` datetime DEFAULT NULL,
  `approve_by` int(11) DEFAULT NULL,
  `approve_date` datetime DEFAULT NULL,
  `attachment_id` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=tis620;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_reservation`
--

LOCK TABLES `tbl_reservation` WRITE;
/*!40000 ALTER TABLE `tbl_reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_reservation_item`
--

DROP TABLE IF EXISTS `tbl_reservation_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_reservation_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reservation_id` int(11) DEFAULT NULL,
  `equipment_id` int(11) DEFAULT NULL,
  `resv_from_date` datetime DEFAULT NULL,
  `resv_from_time` varchar(5) DEFAULT NULL,
  `resv_to_date` datetime DEFAULT NULL,
  `resv_to_time` varchar(5) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `serial_no` varchar(50) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  `resv_item_type` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=tis620;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_reservation_item`
--

LOCK TABLES `tbl_reservation_item` WRITE;
/*!40000 ALTER TABLE `tbl_reservation_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_reservation_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role`
--

DROP TABLE IF EXISTS `tbl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role`
--

LOCK TABLES `tbl_role` WRITE;
/*!40000 ALTER TABLE `tbl_role` DISABLE KEYS */;
INSERT INTO `tbl_role` VALUES (1,'R01','Admin',1,NULL,NULL,NULL,NULL),(2,'R02','PowerUser',1,NULL,NULL,NULL,NULL),(3,'R03','User',1,NULL,NULL,NULL,NULL),(4,'R04','Guest',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_service`
--

DROP TABLE IF EXISTS `tbl_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_service`
--

LOCK TABLES `tbl_service` WRITE;
/*!40000 ALTER TABLE `tbl_service` DISABLE KEYS */;
INSERT INTO `tbl_service` VALUES (1,'S01','กำจัดปลวก',1,NULL,NULL,NULL,NULL),(2,'S02','ทำบัญชี',1,NULL,NULL,NULL,NULL),(3,'S03','พัฒนาระบบ',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_shipper`
--

DROP TABLE IF EXISTS `tbl_shipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_shipper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_shipper`
--

LOCK TABLES `tbl_shipper` WRITE;
/*!40000 ALTER TABLE `tbl_shipper` DISABLE KEYS */;
INSERT INTO `tbl_shipper` VALUES (1,'SH01','RCL',0,NULL,NULL,NULL,NULL),(2,'SH02','RCL2',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_shipper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sibling`
--

DROP TABLE IF EXISTS `tbl_sibling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_sibling` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  `first_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `last_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `company` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `position` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `tel` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sibling`
--

LOCK TABLES `tbl_sibling` WRITE;
/*!40000 ALTER TABLE `tbl_sibling` DISABLE KEYS */;
INSERT INTO `tbl_sibling` VALUES (14,2,4,'11','11','11','11','11',1,NULL,NULL,NULL,NULL),(15,62,5,'11','11','11','11','11',1,NULL,NULL,NULL,NULL),(16,62,5,'11','11','11','11','11',0,NULL,NULL,NULL,NULL),(17,21,1,'11','11','11','11','11',0,NULL,NULL,NULL,NULL),(18,63,1,'11','11','11','11','11',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_sibling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_supplier`
--

DROP TABLE IF EXISTS `tbl_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `company` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `contact_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `tel` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `mobile` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `fax` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `home_page` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `email` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  `address_no` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `road` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `soi` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `moo` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `district` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL,
  `amphur_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_supplier`
--

LOCK TABLES `tbl_supplier` WRITE;
/*!40000 ALTER TABLE `tbl_supplier` DISABLE KEYS */;
INSERT INTO `tbl_supplier` VALUES (1,'S11','1111',NULL,'11','11','11','11',NULL,'11',0,NULL,NULL,NULL,NULL,'11','11','11','11',NULL,1,1),(4,'S12','1111',NULL,'11','11','11','11',NULL,'11',0,NULL,NULL,NULL,NULL,'11','11','11','11',NULL,1,1),(5,'S13','12',NULL,'12','2','2','2',NULL,'2',0,NULL,NULL,NULL,NULL,'2','2','2','2',NULL,1,2),(6,'S14','15','14','14','14','14','14','14','14',4,NULL,NULL,NULL,NULL,'14','14','14','14',NULL,2,3),(7,'C0001','11','11','11','11','11','11','11','11',0,NULL,NULL,NULL,NULL,'11','11','11','11',NULL,2,3);
/*!40000 ALTER TABLE `tbl_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_title`
--

DROP TABLE IF EXISTS `tbl_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `desc` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_title`
--

LOCK TABLES `tbl_title` WRITE;
/*!40000 ALTER TABLE `tbl_title` DISABLE KEYS */;
INSERT INTO `tbl_title` VALUES (1,'T01','นาย',1,NULL,NULL,NULL,NULL),(2,'T02','นาง',1,NULL,NULL,NULL,NULL),(3,'T03','นางสาว',1,NULL,NULL,NULL,NULL),(4,'T04','เด็กชาย',1,NULL,NULL,NULL,NULL),(5,'T05','เด็กหญิง',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_training`
--

DROP TABLE IF EXISTS `tbl_training`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_training` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `company` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `course_name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_training`
--

LOCK TABLES `tbl_training` WRITE;
/*!40000 ALTER TABLE `tbl_training` DISABLE KEYS */;
INSERT INTO `tbl_training` VALUES (10,2,'11','11','1472-08-01 00:00:00','1472-08-31 00:00:00',0,NULL,NULL,NULL,NULL),(11,62,'11','11','1472-08-02 00:00:00','1472-08-31 00:00:00',0,NULL,NULL,NULL,NULL),(12,21,'11','11','1472-08-28 00:00:00','1472-08-28 00:00:00',0,NULL,NULL,NULL,NULL),(13,63,'11','11','1472-07-31 17:00:00','1472-08-30 17:00:00',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_training` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `pass_word` varchar(2000) COLLATE tis620_bin DEFAULT NULL,
  `email` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `is_lock` bit(1) DEFAULT NULL,
  `effective_date` datetime DEFAULT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `create_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `lastupdate_by` varchar(20) COLLATE tis620_bin DEFAULT NULL,
  `lastupdate_date` datetime DEFAULT NULL,
  `name` varchar(200) COLLATE tis620_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (1,'Admin','1234',NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL),(2,'56146','P@ssw0rd',NULL,'\0',NULL,NULL,4,NULL,NULL,NULL,NULL,'anawatj');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user_role`
--

DROP TABLE IF EXISTS `tbl_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=tis620 COLLATE=tis620_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user_role`
--

LOCK TABLES `tbl_user_role` WRITE;
/*!40000 ALTER TABLE `tbl_user_role` DISABLE KEYS */;
INSERT INTO `tbl_user_role` VALUES (1,1),(2,1),(2,2),(2,3),(2,4);
/*!40000 ALTER TABLE `tbl_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-01 18:25:18
