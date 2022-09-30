CREATE TABLE `roles` (
  `idroles` bigint NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  `description` varchar(250) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`idroles`),
  UNIQUE KEY `role_UNIQUE` (`role`)
);

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
);

CREATE TABLE `reviews` (
  `idreviews` bigint NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `title` varchar(45) NOT NULL,
  `description` varchar(5000) NOT NULL,
  `iduser` bigint NOT NULL,
  PRIMARY KEY (`idreviews`),
  KEY `iduser_review_fk_idx` (`iduser`),
  CONSTRAINT `review_iduser_fk` FOREIGN KEY (`iduser`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO `roles`
(`idroles`,
`role`,
`description`,
`enabled`)
VALUES
('1', 'USER', 'registered users', '1');

INSERT INTO `roles`
(`idroles`,
`role`,
`description`,
`enabled`)
VALUES
('2', 'ADMINISTRATOR', 'application administrator', '1');

INSERT INTO `roles`
(`idroles`,
`role`,
`description`,
`enabled`)
VALUES
('3', 'TEST', 'simple role for test', '1');

INSERT INTO `users`
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
