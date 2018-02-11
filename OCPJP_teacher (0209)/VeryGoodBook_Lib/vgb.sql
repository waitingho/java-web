/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Administrator
 * Created: 2018/2/8
 */
DROP DATABASE IF EXISTS `vgb`;
CREATE DATABASE `vgb` 
        DEFAULT CHARSET=utf8; /*!40100 DEFAULT CHARACTER SET utf8 */;
USE vgb; 

DROP TABLE IF EXISTS `customers`;
CREATE TABLE  `customers` (
  `id` char(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `gender` char(1) NOT NULL,
  `email` varchar(60) NOT NULL,
  `birthday` date NOT NULL,
  `address` varchar(100) NOT NULL DEFAULT '',
  `phone` varchar(20) DEFAULT NULL,
  `married` BOOLEAN NOT NULL DEFAULT false,
  `blood_type` varchar(2) DEFAULT NULL,  
  `discount` INT(5) NOT NULL DEFAULT 0,
  `type` varchar(20) NOT NULL DEFAULT 'Customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index_unique_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO customers
    (name,password,gender,email,birthday,id)
VALUES('張三豐', '123456', 'M', 'sammul.chang.tw@gmail.com', '1990-10-05', 'A123456789');

INSERT INTO customers
    (id, name,password,gender,email,birthday, address,phone,married,blood_type, discount, type)
VALUES('A223456781','林梅莉', '123456', 'F', 'marie.lin.tw@gmail.com', '1985-2-18', 
            '台北市復興北路99號14F', '02-25149191', 1, 'AB', 20, 'VIP');


SELECT * FROM customers;