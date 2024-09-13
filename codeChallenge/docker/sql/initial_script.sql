
CREATE TABLE `payments` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(300) NOT NULL,
  `amount` decimal(9,2) NOT NULL,
  `number_products` int NOT NULL,
  `account_holder` varchar(200) NOT NULL,
  `payment_receiver` varchar(200) NOT NULL,
  `status` varchar(25) NOT NULL,
  `user` varchar(100) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;