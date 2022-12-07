CREATE DATABASE `restaurant_management` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `ban` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `so_ghe` int DEFAULT NULL,
  `da_dat` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `ban_dat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `khach_hang_id` int DEFAULT NULL,
  `thoi_gian_dat` datetime DEFAULT NULL,
  `ban_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `ban_dat_combo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ban_dat_id` int DEFAULT NULL,
  `combo_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `ban_dat_mon_an` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ban_dat_id` int DEFAULT NULL,
  `mon_an_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `combo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gia` float DEFAULT NULL,
  `mo_ta` text,
  `hien_co` tinyint(1) DEFAULT NULL,
  `combo_mon_an_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `combo_mon_an` (
  `id` int NOT NULL AUTO_INCREMENT,
  `combo_id` int DEFAULT NULL,
  `mon_an_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `khach_hang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dia_chi` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `sdt` varchar(10) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `cmt` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `mon_an` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `so_luong` int DEFAULT NULL,
  `gia` float DEFAULT NULL,
  `loai` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDSBan`(IN so_ghe int,IN tenKH varchar(255), IN thoi_gian_dat datetime)
BEGIN
	declare start_d datetime;
	declare end_d datetime;
    set start_d = STR_TO_DATE(CONCAT(date(thoi_gian_dat), ' 00:00:00'), '%Y-%m-%d %H:%i:%s');
    set end_d = STR_TO_DATE(CONCAT(date(thoi_gian_dat), ' 23:59:59'), '%Y-%m-%d %H:%i:%s');
   select b.id ban_id,bd.id ban_dat_id,b.ten ten_ban,kh.ten ten_khach_hang,b.so_ghe so_ghe,bd.thoi_gian_dat thoi_gian_dat   from ban_dat bd
   left join ban b on b.id = bd.ban_id
   left join khach_hang kh on bd.khach_hang_id = kh.id
   where (so_ghe is  null or b.so_ghe = so_ghe) and (tenKH is null or kh.ten like concat('%',tenKH,'%')) and (bd.thoi_gian_dat between start_d and end_d);
END$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDsKH`(IN ten varchar(255), IN sdt varchar(10))
BEGIN
select * from khach_hang kh where (ten is null or kh.ten like concat('%',ten,'%')) and (sdt is null or sdt like concat('%',sdt,'%'));
END$$
DELIMITER ;

