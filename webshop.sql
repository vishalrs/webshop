-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.19-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for webshop
CREATE DATABASE IF NOT EXISTS `webshop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `webshop`;


-- Dumping structure for table webshop.orders
DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_date` date NOT NULL,
  `order_no` varchar(50) NOT NULL,
  `shipping_address` longtext NOT NULL,
  `shipping_city` varchar(50) NOT NULL,
  `shipping_pin` varchar(10) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_89639a66ea74413dab259df0655` (`user_id`),
  CONSTRAINT `FK_89639a66ea74413dab259df0655` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table webshop.orders: ~0 rows (approximately)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;


-- Dumping structure for table webshop.order_lines
DROP TABLE IF EXISTS `order_lines`;
CREATE TABLE IF NOT EXISTS `order_lines` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `price` decimal(8,2) DEFAULT NULL,
  `qty` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b8f2aa0a5bf54dc1937c4395279` (`product_id`),
  KEY `FK_548f67918b994da48941671ffa6` (`order_id`),
  CONSTRAINT `FK_548f67918b994da48941671ffa6` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK_b8f2aa0a5bf54dc1937c4395279` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table webshop.order_lines: ~0 rows (approximately)
/*!40000 ALTER TABLE `order_lines` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_lines` ENABLE KEYS */;


-- Dumping structure for table webshop.products
DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(36) DEFAULT NULL,
  `description` longtext,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `product_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_0fac282c98f547fa8dbe7885b64` (`code`),
  KEY `FK_4263cdaab4504fed93ffc1f85eb` (`product_category_id`),
  CONSTRAINT `FK_4263cdaab4504fed93ffc1f85eb` FOREIGN KEY (`product_category_id`) REFERENCES `product_categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table webshop.products: ~4 rows (approximately)
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`id`, `code`, `description`, `name`, `price`, `product_category_id`) VALUES
	(1, '1001', 'Apple iPhone 6', 'iPhone 6', 50000.00, 1),
	(3, '1002', 'Google Nexus 5', 'Nexus 5', 30000.00, 1),
	(4, '1003', 'Samsung S4', 'Samsung S4', 40000.00, 1),
	(5, '1004', 'Motorola MotoX', 'Motorola MotoX', 35000.00, 1),
	(6, '1005', 'Motorola MotoG', 'Motorola MotoG', 15000.00, 1),
	(7, '1006', 'Sony 42 LED', 'Sony 42 LED', 40000.00, 2),
	(8, '1007', 'Samsung 42 LED', 'Samsung 42 LED', 50000.00, 2),
	(9, '1008', 'Panasonic 42 LED', 'Panasonic 42 LED', 35000.00, 2),
	(10, '1009', 'Sharp 46 LED', 'Sharp 46 LED', 42000.00, 2);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;


-- Dumping structure for table webshop.product_categories
DROP TABLE IF EXISTS `product_categories`;
CREATE TABLE IF NOT EXISTS `product_categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table webshop.product_categories: ~4 rows (approximately)
/*!40000 ALTER TABLE `product_categories` DISABLE KEYS */;
INSERT INTO `product_categories` (`id`, `name`) VALUES
	(1, 'Mobiles'),
	(2, 'Televisions'),
	(3, 'Laptops'),
	(4, 'Cameras'),
	(5, 'IT Accessories');
/*!40000 ALTER TABLE `product_categories` ENABLE KEYS */;


-- Dumping structure for table webshop.product_pictures
DROP TABLE IF EXISTS `product_pictures`;
CREATE TABLE IF NOT EXISTS `product_pictures` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longblob,
  `contentType` varchar(100) DEFAULT NULL,
  `description` longtext,
  `name` varchar(50) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8e64728c7f0647ec8a6b238e91c` (`product_id`),
  CONSTRAINT `FK_8e64728c7f0647ec8a6b238e91c` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table webshop.product_pictures: ~0 rows (approximately)
/*!40000 ALTER TABLE `product_pictures` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_pictures` ENABLE KEYS */;


-- Dumping structure for table webshop.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table webshop.roles: ~2 rows (approximately)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_CUSTOMER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- Dumping structure for table webshop.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountEnabled` tinyint(1) DEFAULT NULL,
  `address` varchar(250) NOT NULL,
  `city` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `pincode` varchar(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_19b20d2379bd4434809f310e9ed` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table webshop.users: ~5 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `accountEnabled`, `address`, `city`, `email`, `first_name`, `last_name`, `password`, `pincode`, `username`) VALUES
	(1, 1, 'Shefalee, Makrand Soc', 'Mumbai', 'vishalrs@gmail.com', 'Vishal', 'Shinde', 'svish', '400016', 'admin'),
	(2, 1, 'Shefalee, Makrand Soc', 'Mumbai', 'vishalrs@gmail.com', 'Vishal', 'Shinde', 'svish', '400016', 'cust1'),
	(4, 1, 'Shefalee, Makrand Soc', 'Mumbai', 'vishalrs@gmail.com', 'Vishal', 'Shinde', 'svish', '400016', 'cust2'),
	(5, 1, 'Shefalee, Makrand Soc', 'Mumbai', 'vishalrs@gmail.com', 'Vishal', 'Shinde', 'svish', '400016', 'cust3'),
	(6, 1, 'Shefalee, Makrand Soc', 'Mumbai', 'vishalrs@gmail.com', 'Vishal', 'Shinde', 'svish', '400016', 'cust4'),
	(7, 1, 'Shefalee, Makrand Soc', 'Mumbai', 'vishalrs@gmail.com', 'Vishal', 'Shinde', 'svish', '400016', 'cust5');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Dumping structure for table webshop.user_roles
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FK_bca0bd135d594dcab69a6029a9e` (`role_id`),
  KEY `FK_e9eb5dd7796e48afa37f800fd61` (`user_id`),
  CONSTRAINT `FK_bca0bd135d594dcab69a6029a9e` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FK_e9eb5dd7796e48afa37f800fd61` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table webshop.user_roles: ~5 rows (approximately)
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
	(1, 1),
	(4, 2),
	(2, 2),
	(5, 2),
	(6, 2),
	(7, 2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
