package com.vague.runner.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vague.runner.model.entity.Rider;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RiderMapper extends BaseMapper<Rider> {
}
