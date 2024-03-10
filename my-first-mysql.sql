-- Adminer 4.8.1 MySQL 8.3.0 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `hotels`;
CREATE TABLE `hotels` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `address` varchar(60) NOT NULL,
  `classification` int NOT NULL,
  `comforts` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `uri` varchar(200) NOT NULL,
  `id_hotel` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uri` (`uri`),
  KEY `id_hotel` (`id_hotel`),
  CONSTRAINT `images_ibfk_1` FOREIGN KEY (`id_hotel`) REFERENCES `hotels` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `reservations`;
CREATE TABLE `reservations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `id_hotel` int NOT NULL,
  `id_room` int NOT NULL,
  `entry_date` date NOT NULL,
  `departure_date` date NOT NULL,
  `status` varchar(20) NOT NULL,
  `total_Price` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  KEY `id_hotel` (`id_hotel`),
  KEY `id_room` (`id_room`),
  CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`id_hotel`) REFERENCES `hotels` (`id`),
  CONSTRAINT `reservations_ibfk_3` FOREIGN KEY (`id_room`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `rooms`;
CREATE TABLE `rooms` (
  `id` int NOT NULL AUTO_INCREMENT,
  `room_number` varchar(20) NOT NULL,
  `type_room` varchar(10) NOT NULL,
  `price_per_night` double NOT NULL,
  `availability` tinyint(1) NOT NULL,
  `amenities_details` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `room_number` (`room_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(120) NOT NULL,
  `email` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL,
  `contact` varchar(120) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `users` (`id`, `full_name`, `email`, `password`, `contact`) VALUES
(1,	'Sebastián',	'sbs@gmail.com',	'password',	'contact'),
(2,	'Fabián',	'lugo@gmail.com',	'password',	'contact');

-- 2024-03-10 17:58:51
