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




INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (1, 'iphone 账号', '993550968@qq.com', 'Yangc0328', 'iphone', '手机账号(国内)', '2023-02-15 17:24:09', NULL);
INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (2, 'iphone 账号', 'alangcvip@gmail.com', 'Yangc0328', 'iphone', '手机账号(地址海外)', '2023-02-15 17:24:09', NULL);
INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (3, '163账号', 'alangcvip@163.com', 'alangc123', 'mail', '邮箱账号', '2023-02-15 17:28:15', NULL);
INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (4, 'gitee', 'alangc', 'alangc123', 'git', 'gitee 账号', '2023-02-15 17:28:48', NULL);
INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (5, 'github', '993550968@qq.com', 'Yangc@950001', 'git', 'github账号', '2023-02-15 17:29:47', NULL);
INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (6, 'postman', '993550968@qq.com', 'bb520baby', 'debug', 'postman账号', '2023-02-15 17:38:54', NULL);
INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (7, 'oracle', '993550968@qq.com', 'Yangcheng@1', 'oracle', 'oracle账号', '2023-02-15 17:41:37', NULL);
INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (8, '微信公众号', 'alangcvip@163.com', 'Yangcheng@1', 'wechat', 'appid=wx1143739b625994fd ,Secret=4c9817bf88f4adf90529b6f1451cd5a9', '2023-02-15 17:42:31', NULL);
INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (9, '服务器', 'root', 'Alangc123', '服务器', '服务器root 账号密码 ip:81.71.43.125', '2023-02-15 17:43:40', NULL);
INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (10, 'chatgpt. key', 'chatgpt', 'gpt', 'open ai', '', '2023-03-17 16:14:22', NULL);
INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (11, 'open ai 账号密码', '993550968@qq.com', 'Yangcheng@1', 'open ai', 'chat. gpt', '2023-03-17 16:15:48', NULL);
INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (12, 'sms-activate.org', 'alangcvip@163.com', 'alangc123', 'sms-activate.org', 'https://sms-activate.org/#  国外虚拟手机号', '2023-03-17 16:17:00', NULL);
INSERT INTO  `yc_user` (`id`, `address`, `account_number`, `password`, `type`, `reamke`, `creat_time`, `update_time`) VALUES (13, '谷歌', 'alangcvip@gmail.com', 'Yangcheng@1', 'guge', NULL, '2023-05-05 18:03:51', NULL);