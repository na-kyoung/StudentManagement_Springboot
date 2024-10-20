-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.7.42-log - MySQL Community Server (GPL)
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- springdb 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `springdb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `springdb`;

-- 테이블 springdb.student 구조 내보내기
CREATE TABLE IF NOT EXISTS `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `sage` int(11) DEFAULT NULL,
  `sdept` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 테이블 데이터 springdb.student:~7 rows (대략적) 내보내기
DELETE FROM `student`;
INSERT INTO `student` (`sid`, `sname`, `sage`, `sdept`) VALUES
	(1, '최민준', 24, '산업공학과'),
	(2, '이지영', 22, '유아교육과'),
	(3, '김민정', 21, '경영학과'),
	(4, '송지영', 20, '컴퓨터공학과'),
	(5, '박민정', 22, '행정학과'),
	(6, '김민지', 20, '수학과'),
	(7, '한지희', 23, '실용음악학과');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
