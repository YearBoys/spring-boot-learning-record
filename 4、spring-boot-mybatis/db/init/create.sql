CREATE TABLE `boot_user` (
    `id` varchar(30) NOT NULL COMMENT '主键',
    `name` varchar(50) DEFAULT NULL COMMENT '姓名',
    `password` varchar(50) DEFAULT NULL COMMENT '密码',
    `age` int(11) DEFAULT NULL COMMENT '年龄',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;