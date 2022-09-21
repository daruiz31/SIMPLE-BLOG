CREATE DATABASE `simpleblog` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `simpleblog`;

CREATE TABLE `roles` (
  `idroles` bigint NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  `description` varchar(250) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`idroles`),
  UNIQUE KEY `role_UNIQUE` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='roles for simple blog users';

CREATE TABLE `users` (
  `idusers` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45)  NOT NULL,
  `surname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(99) NOT NULL,
  `enabled` tinyint NOT NULL,
  `idrol` bigint DEFAULT NULL,
  PRIMARY KEY (`idusers`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `user_idrol_fk_idx` (`idrol`),
  CONSTRAINT `user_idrol_fk` FOREIGN KEY (`idrol`) REFERENCES `roles` (`idroles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='registered users';

CREATE TABLE `reviews` (
  `idreviews` bigint NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `title` varchar(45) NOT NULL,
  `description` varchar(500) NOT NULL,
  `iduser` bigint NOT NULL,
  PRIMARY KEY (`idreviews`),
  KEY `iduser_review_fk_idx` (`iduser`),
  CONSTRAINT `review_iduser_fk` FOREIGN KEY (`iduser`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `simpleblog`.`roles`
(`idroles`,
`role`,
`description`,
`enabled`)
VALUES
('1', 'USER', 'registered users', '1');

INSERT INTO `simpleblog`.`roles`
(`idroles`,
`role`,
`description`,
`enabled`)
VALUES
('2', 'ADMINISTRATOR', 'application administrator', '1');

INSERT INTO `simpleblog`.`roles`
(`idroles`,
`role`,
`description`,
`enabled`)
VALUES
('3', 'TEST', 'simple role for test', '1');

INSERT INTO `simpleblog`.`users`
(`idusers`,
`name`,
`surname`,
`email`,
`password`,
`enabled`,
`idrol`)
VALUES
(1,
'Pruebas','Automáticas',
'PruebasJUnit@test.com',
'7c4a8d09ca3762af61e59520943dc26494f8941b',
1,
3);


