CREATE TABLE `user` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `address` varchar(255) NOT NULL COMMENT '地址',
   `account_number` varchar(255) NOT NULL COMMENT '账号',
   `password` varchar(255) NOT NULL COMMENT '密码',
   `type` varchar(255) DEFAULT NULL COMMENT '类型',
   `reamke` varchar(255) DEFAULT NULL COMMENT '备注',
   `creat_time` datetime NOT NULL COMMENT '创建时间',
   `update_time` datetime DEFAULT NULL COMMENT '修改时间',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;