-- 用户相关表

-- 用户主表
CREATE TABLE u_user (
    id BIGINT PRIMARY KEY COMMENT '用户ID',
    phone VARCHAR(11) NOT NULL UNIQUE COMMENT '手机号',
    password VARCHAR(255) NOT NULL COMMENT '密码',
    nickname VARCHAR(50) COMMENT '昵称',
    avatar VARCHAR(255) COMMENT '头像URL',
    user_type TINYINT DEFAULT 1 COMMENT '用户类型：1=消费者 2=骑手 3=都是',
    status TINYINT DEFAULT 1 COMMENT '状态：0=禁用 1=正常',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_phone (phone),
    INDEX idx_user_type (user_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 消费者扩展表
CREATE TABLE u_customer (
    id BIGINT PRIMARY KEY COMMENT '用户ID',
    real_name VARCHAR(50) COMMENT '真实姓名',
    credit INT DEFAULT 100 COMMENT '信用积分',
    total_orders INT DEFAULT 0 COMMENT '累计订单数',
    total_amount DECIMAL(10,2) DEFAULT 0.00 COMMENT '累计消费金额',
    vip_level INT DEFAULT 0 COMMENT '会员等级',
    default_address_id BIGINT COMMENT '默认地址ID',
    last_order_time DATETIME COMMENT '最近下单时间',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消费者扩展表';

-- 骑手扩展表
CREATE TABLE u_rider (
    id BIGINT PRIMARY KEY COMMENT '用户ID',
    real_name VARCHAR(50) COMMENT '真实姓名',
    id_card VARCHAR(18) COMMENT '身份证号',
    status TINYINT DEFAULT 0 COMMENT '状态：0=待审核 1=正常 2=休息中 3=已禁用',
    current_lng DECIMAL(10,6) COMMENT '当前经度',
    current_lat DECIMAL(10,6) COMMENT '当前纬度',
    total_orders INT DEFAULT 0 COMMENT '累计接单数',
    rating DECIMAL(3,2) DEFAULT 5.00 COMMENT '评分',
    total_earnings DECIMAL(10,2) DEFAULT 0.00 COMMENT '累计收入',
    available_balance DECIMAL(10,2) DEFAULT 0.00 COMMENT '可提现余额',
    frozen_amount DECIMAL(10,2) DEFAULT 0.00 COMMENT '冻结金额',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_location (current_lng, current_lat)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='骑手扩展表';

-- 地址表
CREATE TABLE u_address (
    id BIGINT PRIMARY KEY COMMENT '地址ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    contact_name VARCHAR(50) NOT NULL COMMENT '联系人',
    contact_phone VARCHAR(11) NOT NULL COMMENT '联系电话',
    province VARCHAR(50) NOT NULL COMMENT '省',
    city VARCHAR(50) NOT NULL COMMENT '市',
    district VARCHAR(50) NOT NULL COMMENT '区',
    street VARCHAR(100) COMMENT '街道',
    detail VARCHAR(255) NOT NULL COMMENT '详细地址',
    lng DECIMAL(10,6) NOT NULL COMMENT '经度',
    lat DECIMAL(10,6) NOT NULL COMMENT '纬度',
    tag VARCHAR(20) COMMENT '标签',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_user_id (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='地址表';

-- 客服表
CREATE TABLE u_service_staff (
    id BIGINT PRIMARY KEY COMMENT '客服ID',
    staff_name VARCHAR(50) NOT NULL UNIQUE COMMENT '登录账号',
    password VARCHAR(255) NOT NULL COMMENT '密码',
    real_name VARCHAR(50) COMMENT '真实姓名',
    phone VARCHAR(11) COMMENT '联系电话',
    status TINYINT DEFAULT 0 COMMENT '状态：0=离线 1=在线 2=忙碌 3=已禁用',
    total_handled INT DEFAULT 0 COMMENT '累计处理工单数',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客服表';
