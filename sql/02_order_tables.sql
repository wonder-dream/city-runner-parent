-- 订单相关表

-- 订单表
CREATE TABLE o_order (
    id BIGINT PRIMARY KEY COMMENT '订单ID',
    customer_id BIGINT NOT NULL COMMENT '下单用户ID',
    rider_id BIGINT COMMENT '接单骑手ID',
    pickup_address VARCHAR(255) NOT NULL COMMENT '取货地址',
    pickup_lng DECIMAL(10,6) NOT NULL COMMENT '取货经度',
    pickup_lat DECIMAL(10,6) NOT NULL COMMENT '取货纬度',
    pickup_contact VARCHAR(50) NOT NULL COMMENT '取货联系人',
    pickup_phone VARCHAR(11) NOT NULL COMMENT '取货电话',
    delivery_address VARCHAR(255) NOT NULL COMMENT '送货地址',
    delivery_lng DECIMAL(10,6) NOT NULL COMMENT '送货经度',
    delivery_lat DECIMAL(10,6) NOT NULL COMMENT '送货纬度',
    delivery_contact VARCHAR(50) NOT NULL COMMENT '送货联系人',
    delivery_phone VARCHAR(11) NOT NULL COMMENT '送货电话',
    goods_desc VARCHAR(255) COMMENT '物品描述',
    weight DECIMAL(5,2) COMMENT '重量',
    distance DECIMAL(6,2) COMMENT '距离',
    total_fee DECIMAL(10,2) NOT NULL COMMENT '总费用',
    status TINYINT DEFAULT 0 COMMENT '状态：0=待支付 1=待接单 2=取货中 3=配送中 4=已完成 5=已取消',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
    pay_time DATETIME COMMENT '支付时间',
    accept_time DATETIME COMMENT '接单时间',
    pickup_time DATETIME COMMENT '取货时间',
    delivery_time DATETIME COMMENT '送达时间',
    cancel_time DATETIME COMMENT '取消时间',
    INDEX idx_customer_id (customer_id),
    INDEX idx_rider_id (rider_id),
    INDEX idx_status (status),
    INDEX idx_create_time (create_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- 支付流水表
CREATE TABLE o_payment (
    id BIGINT PRIMARY KEY COMMENT '支付ID',
    order_id BIGINT NOT NULL COMMENT '订单ID',
    user_id BIGINT NOT NULL COMMENT '支付用户ID',
    amount DECIMAL(10,2) NOT NULL COMMENT '支付金额',
    payment_method TINYINT NOT NULL COMMENT '支付方式：1=微信 2=支付宝 3=余额',
    status TINYINT DEFAULT 0 COMMENT '状态：0=待支付 1=成功 2=失败 3=已退款',
    transaction_id VARCHAR(100) COMMENT '第三方交易流水号',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    pay_time DATETIME COMMENT '支付时间',
    INDEX idx_order_id (order_id),
    INDEX idx_user_id (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付流水表';

-- 订单状态日志表
CREATE TABLE o_order_status_log (
    id BIGINT PRIMARY KEY COMMENT '日志ID',
    order_id BIGINT NOT NULL COMMENT '订单ID',
    old_status TINYINT COMMENT '变更前状态',
    new_status TINYINT NOT NULL COMMENT '变更后状态',
    operator_id BIGINT COMMENT '操作人ID',
    operator_type TINYINT COMMENT '操作人类型：1=用户 2=骑手 3=系统',
    remark VARCHAR(255) COMMENT '备注',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '变更时间',
    INDEX idx_order_id (order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单状态日志表';

-- 订单评价表
CREATE TABLE o_order_review (
    id BIGINT PRIMARY KEY COMMENT '评价ID',
    order_id BIGINT NOT NULL UNIQUE COMMENT '订单ID',
    customer_id BIGINT NOT NULL COMMENT '评价用户ID',
    rider_id BIGINT NOT NULL COMMENT '被评价骑手ID',
    rating TINYINT NOT NULL COMMENT '评分：1-5星',
    content VARCHAR(500) COMMENT '评价内容',
    tags VARCHAR(100) COMMENT '标签',
    images VARCHAR(500) COMMENT '评价图片',
    is_anonymous TINYINT DEFAULT 0 COMMENT '是否匿名：0=否 1=是',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    INDEX idx_rider_id (rider_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单评价表';
