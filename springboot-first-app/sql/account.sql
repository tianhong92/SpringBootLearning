DROP TABLE `account` IF EXISTS;
CREATE TABLE `account` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`name` varchar(32) NOT NULL,
	`money` double(10, 6) NOT NULL,
	PRIMARY KEY(`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
INSERT INTO `account` VALUES(1, 'aaa', 12.5454);
INSERT INTO `account` VALUES(2, 'bbb', 14.5454);
INSERT INTO `account` VALUES(3, 'ccc', 16.5454);