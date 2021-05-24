CREATE DATABASE `rmm_services` /*!40100 DEFAULT CHARACTER SET utf8 */;

--CREATE TABLES
CREATE TABLE `customer` (
  `id_number` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `service` (
  `id` varchar(3) NOT NULL,
  `service_name` varchar(255) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `service_cost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` varchar(3) NOT NULL,
  `system` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `service_cost_FK` (`service_id`),
  CONSTRAINT `service_cost_FK` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE `device` (
  `id` varchar(255) NOT NULL,
  `date_create` date DEFAULT NULL,
  `system_name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `customer_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `device_FK` (`customer_id`),
  CONSTRAINT `device_FK` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `customer_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_create` date DEFAULT NULL,
  `customer_id` varchar(255) DEFAULT NULL,
  `service_id` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_service_FK` (`customer_id`),
  KEY `customer_service_FK_1` (`service_id`),
  CONSTRAINT `customer_service_FK` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id_number`),
  CONSTRAINT `customer_service_FK_1` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
