-- Adminer 4.8.1 MySQL 8.3.0 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

INSERT INTO `Products` (`id`, `name`, `price`, `supplier`, `final_date`) VALUES
(1,	'Arina pan',	5000,	'ara',	'30/03/2024'),
(2,	'arroz roa',	3500,	'D1',	'20/03/2024'),
(3,	'gdsag',	123,	'212',	'121');

DROP TABLE IF EXISTS `Rooms`;
CREATE TABLE `Rooms` (
  `id` int NOT NULL AUTO_INCREMENT,
  `room_number` int NOT NULL,
  `type_room` varchar(10) NOT NULL,
  `price_per_night` double NOT NULL,
  `availability` tinyint(1) NOT NULL,
  `amenities_details` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `room_number` (`room_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(120) NOT NULL,
  `email` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL,
  `contact` varchar(120) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Users` (`id`, `full_name`, `email`, `password`, `contact`) VALUES
(1,	'Sebastián',	'sbs@gmail.com',	'password',	'contact'),
(2,	'Fabián',	'lugo@gmail.com',	'password',	'contact');

INSERT INTO `computers` (`id`, `board`, `ram`, `power_supply`, `cpu`) VALUES
(1,	'asus',	'16',	'500gold',	'ryzen 5');

-- 2024-03-09 14:28:03
