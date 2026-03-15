-- 工单和系统配置表

-- 客服工单表
CREATE TABLE o_service_ticket (
    id BIGINT PRIMARY KEY COMMENT '工单ID',
    order_id BIGINT COMMENT '关联订单ID',
    user_id BIGINT NOT NULL COMMENT '提交用户ID',
    issue_type TINYINT NOT NULL COMMENT '问题类型：1=订单 2=支付 3=配送 4=账户 5=其他',
    title VARCHAR(100) NOT NULL COMMENT '工单标题',
    description VARCHAR(500) NOT NULL COMMENT '问题描述',
    images VARCHAR(500) COMMENT '图片URL',
    status TINYINT DEFAULT 0 COMMENT '状态：0=待处理 1=处理中 2=已解决 3=已关闭',
    handler_id BIGINT COMMENT '处理客服ID',
    reply VARCHAR(500) COMMENT '客服回复',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    handle_time DATETIME COMMENT '处理时间',
    close_time DATETIME COMMENT '关闭时间',
    INDEX idx_user_id (user_id),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客服工单表';

-- 提现记录表
CREATE TABLE o_withdraw_record (
    id BIGINT PRIMARY KEY COMMENT '提现ID',
    rider_id BIGINT NOT NULL COMMENT '骑手ID',
    amount DECIMAL(10,2) NOT NULL COMMENT '提现金额',
    withdraw_method TINYINT NOT NULL COMMENT '提现方式：1=支付宝 2=微信 3=银行卡',
    account_info VARCHAR(100) NOT NULL COMMENT '账户信息',
    status TINYINT DEFAULT 0 COMMENT '状态：0=待审核 1=审核通过 2=已打款 3=已拒绝',
    remark VARCHAR(255) COMMENT '备注',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    audit_time DATETIME COMMENT '审核时间',
    pay_time DATETIME COMMENT '打款时间',
    INDEX idx_rider_id (rider_id),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='提现记录表';

-- 计费规则表
CREATE TABLE s_fee_config (
    id BIGINT PRIMARY KEY COMMENT '配置ID',
    city VARCHAR(50) NOT NULL COMMENT '城市',
    base_fee DECIMAL(10,2) NOT NULL COMMENT '起步价',
    base_distance DECIMAL(5,2) NOT NULL COMMENT '起步距离',
    price_per_km DECIMAL(10,2) NOT NULL COMMENT '每公里价格',
    base_weight DECIMAL(5,2) DEFAULT 0 COMMENT '免费重量',
    weight_fee DECIMAL(10,2) DEFAULT 0 COMMENT '重量费',
    night_start_time TIME COMMENT '夜间开始时间',
    night_end_time TIME COMMENT '夜间结束时间',
    night_markup DECIMAL(10,2) DEFAULT 0 COMMENT '夜间加价',
    status TINYINT DEFAULT 1 COMMENT '状态：0=禁用 1=启用',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_city (city)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='计费规则表';
