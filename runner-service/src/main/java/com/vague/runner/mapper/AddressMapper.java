package com.vague.runner.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vague.runner.model.entity.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper extends BaseMapper<Address> {
}
