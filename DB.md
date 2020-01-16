# mysql 相关介绍

### 库，表
    1，创建commodity库。
        执行
        DROP TABLE IF EXISTS `tb_commodity`;
        CREATE TABLE `tb_commodity` (
          `commodity_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
          `commodity_name` varchar(255) NOT NULL COMMENT '商品名称',
          `commodity_price` double NOT NULL COMMENT '商品价格',
          `commodity_stock` int(11) NOT NULL COMMENT '库存',
          PRIMARY KEY (`commodity_id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
     
    2，创建user库。
        执行
        DROP TABLE IF EXISTS `tb_user`;
        CREATE TABLE `tb_user` (
          `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
          `user_name` varchar(255) NOT NULL COMMENT '用户名称',
          `user_password` varchar(26) NOT NULL COMMENT '用户密码',
          `user_balance` double NOT NULL COMMENT '余额',
          PRIMARY KEY (`user_id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
        
    3，创建order库。
        执行
        DROP TABLE IF EXISTS `tb_order`;
        CREATE TABLE `tb_order` (
          `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
          `user_id` int(11) NOT NULL COMMENT '用户id',
          `commodity_id` int(11) NOT NULL COMMENT '商品id',
          PRIMARY KEY (`order_id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=1147 DEFAULT CHARSET=utf8;
    
    4，创建tx-manager库。
        执行
        CREATE TABLE `t_tx_exception`  (
          `id` bigint(20) NOT NULL AUTO_INCREMENT,
          `group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
          `unit_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
          `mod_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
          `transaction_state` tinyint(4) NULL DEFAULT NULL,
          `registrar` tinyint(4) NULL DEFAULT NULL,
          `remark` varchar(4096) NULL DEFAULT  NULL,
          `ex_state` tinyint(4) NULL DEFAULT NULL COMMENT '0 未解决 1已解决',
          `create_time` datetime(0) NULL DEFAULT NULL,
          PRIMARY KEY (`id`) USING BTREE
        ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;