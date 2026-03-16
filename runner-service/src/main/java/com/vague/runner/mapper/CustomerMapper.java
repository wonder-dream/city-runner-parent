package com.vague.runner.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vague.runner.model.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
