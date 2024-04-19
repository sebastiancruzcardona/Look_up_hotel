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

INSERT INTO `hotels` (`id`, `name`, `address`, `classification`, `comforts`) VALUES
(1,	'emperador',	'calle 12',	2,	'prueba'),
(2,	'armenia',	'prueba',	2,	'prueba'),
(3,	'polar',	'calle 21',	2,	'uf');

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


DROP TABLE IF EXISTS `reservation_statuses`;
CREATE TABLE `reservation_statuses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `reservation_statuses` (`id`, `name`) VALUES
(1,	'Pending'),
(2,	'Confirmed'),
(3,	'Canceled');

DROP TABLE IF EXISTS `reservations`;
CREATE TABLE `reservations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `id_hotel` int NOT NULL,
  `id_room` int NOT NULL,
  `entry_date` date NOT NULL,
  `departure_date` date NOT NULL,
  `total_Price` double NOT NULL,
  `id_reservation_statuses` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  KEY `id_hotel` (`id_hotel`),
  KEY `id_room` (`id_room`),
  KEY `id_reservation_statuses` (`id_reservation_statuses`),
  CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`id_hotel`) REFERENCES `hotels` (`id`),
  CONSTRAINT `reservations_ibfk_3` FOREIGN KEY (`id_room`) REFERENCES `rooms` (`id`),
  CONSTRAINT `reservations_ibfk_4` FOREIGN KEY (`id_reservation_statuses`) REFERENCES `reservation_statuses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `reservations` (`id`, `id_user`, `id_hotel`, `id_room`, `entry_date`, `departure_date`, `total_Price`, `id_reservation_statuses`) VALUES
(1,	28,	2,	7,	'2024-04-19',	'2024-04-21',	20000,	2),
(2,	28,	1,	10,	'2024-04-23',	'2024-04-25',	20000,	2),
(4,	28,	2,	7,	'2024-04-25',	'2024-04-27',	426,	2);

DROP TABLE IF EXISTS `rols`;
CREATE TABLE `rols` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `rols` (`id`, `name`) VALUES
(1,	'Admin'),
(2,	'Client');

DROP TABLE IF EXISTS `rooms`;
CREATE TABLE `rooms` (
  `id` int NOT NULL AUTO_INCREMENT,
  `room_number` varchar(20) NOT NULL,
  `id_type_room` int NOT NULL,
  `price_per_night` double NOT NULL,
  `availability` tinyint(1) NOT NULL,
  `amenities_details` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_hotel` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `room_number` (`room_number`),
  KEY `fk_hotel` (`id_hotel`),
  KEY `id_type_room` (`id_type_room`),
  CONSTRAINT `fk_hotel` FOREIGN KEY (`id_hotel`) REFERENCES `hotels` (`id`),
  CONSTRAINT `rooms_ibfk_1` FOREIGN KEY (`id_type_room`) REFERENCES `type_rooms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `rooms` (`id`, `room_number`, `id_type_room`, `price_per_night`, `availability`, `amenities_details`, `id_hotel`) VALUES
(6,	'2b',	4,	12,	1,	'dsad',	1),
(7,	'12',	5,	213,	1,	'sadas',	2),
(9,	'12b',	2,	3233,	1,	'dsad',	2),
(10,	'3b',	1,	2000,	1,	'hg',	1);

DROP TABLE IF EXISTS `type_rooms`;
CREATE TABLE `type_rooms` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_room` varchar(30) NOT NULL,
  `person_number` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `type_rooms` (`id`, `type_room`, `person_number`) VALUES
(1,	'single room',	1),
(2,	'double room',	2),
(3,	'triple room',	3),
(4,	'quadruple room',	4),
(5,	'family room',	5);

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(120) NOT NULL,
  `email` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL,
  `contact` varchar(120) NOT NULL,
  `id_rol` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `id_rol` (`id_rol`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rols` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `users` (`id`, `full_name`, `email`, `password`, `contact`, `id_rol`) VALUES
(7,	'test',	'test',	'test',	'test',	NULL),
(8,	'prueba1',	'prueba1',	'prueba1',	'prueba1',	NULL),
(9,	'test1',	'test1',	'test1',	'test1',	NULL),
(10,	'prueba3',	'prueba3',	'prueba3',	'prueba3',	NULL),
(11,	'prueba5',	'prueba5',	'prueba5',	'prueba5',	NULL),
(12,	'a',	's',	's',	's	',	NULL),
(13,	'prueba7',	'prueba7',	'prueba7',	'prueba7',	NULL),
(14,	'prueba9',	'prueba9',	'prueba9',	'prueba9',	NULL),
(15,	'test7',	'test7',	'test7',	'test7',	NULL),
(16,	'test8',	'test8',	'test8',	'test8',	NULL),
(17,	'test10',	'test10',	'test10',	'test10',	NULL),
(18,	'prueba11',	'prueba11',	'prueba11',	'prueba11',	NULL),
(19,	'prueba12',	'prueba12',	'prueba12',	'prueba12',	NULL),
(20,	'prueba13',	'prueba13',	'prueba13',	'prueba13',	2),
(23,	'prueba15',	'prueba15',	'prueba15',	'prueba15',	2),
(24,	'prueba16',	'prueba16',	'prueba16',	'prueba16',	2),
(26,	'fabian',	'feibian@gmail.com',	'admin',	'300421523',	1),
(27,	'sebastian',	'sebastian@gmail.com',	'admin',	'3187492128',	1),
(28,	'andres',	'prueba@gmail.com',	'prueba',	'3234',	2),
(29,	'alberto lopez',	'prueba1@gmail.com',	'1',	'hola prueba hola otravez',	2);

-- 2024-04-19 05:49:55
