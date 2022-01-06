CREATE TABLE `shiro_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `shiro_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `springboot`.`shiro_user` (`id`, `name`, `password`) VALUES ('1', 'admin', 'admin');
INSERT INTO `springboot`.`shiro_user` (`id`, `name`, `password`) VALUES ('2', 'pys', '12345');

INSERT INTO `springboot`.`shiro_role` (`id`, `role_name`, `user_id`) VALUES ('1', 'admin', '1');
INSERT INTO `springboot`.`shiro_role` (`id`, `role_name`, `user_id`) VALUES ('2', 'normal', '2');




