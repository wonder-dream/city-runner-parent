package com.vague.runner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vague.runner.common.exception.BusinessException;
import com.vague.runner.common.result.ResultCode;
import com.vague.runner.common.utils.PasswordUtil;
import com.vague.runner.mapper.RiderMapper;
import com.vague.runner.mapper.UserMapper;
import com.vague.runner.model.dto.RiderCertificationDTO;
import com.vague.runner.model.entity.Rider;
import com.vague.runner.model.entity.User;
import com.vague.runner.model.vo.RiderVO;
import com.vague.runner.model.vo.UserVO;
import com.vague.runner.service.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiderServiceImpl extends ServiceImpl<RiderMapper, Rider> implements RiderService {
    private final UserMapper userMapper;

    public RiderVO convertToVO(Rider rider) {
        RiderVO vo = new RiderVO();
        BeanUtils.copyProperties(rider, vo);
        return vo;
    }

    @Override
    public RiderVO certificationRider(RiderCertificationDTO dto) {
        // 查询用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getPhone, dto.getPhone());
        User user = userMapper.selectOne(wrapper);  // 用 userMapper

        // 检查用户是否存在
        if (user == null) {
            throw new BusinessException(ResultCode.USER_NOT_FOUND);
        }

        // 验证密码
        if (!PasswordUtil.matches(dto.getPassword(), user.getPassword())) {
            throw new BusinessException(ResultCode.PASSWORD_ERROR);
        }

        // 检查是否已认证
        Rider existRider = baseMapper.selectById(user.getId());
        if (existRider != null){
            throw new BusinessException("您已提交过认证");
        }

        // 创建 Rider 记录
        Rider rider = new Rider();
        rider.setId(user.getId());
        rider.setRealName(dto.getRealName());
        rider.setIdCard(dto.getIdCard());
        rider.setIdCardFrontImage(dto.getIdCardFrontImage());
        rider.setIdCardBackImage(dto.getIdCardBackImage());
        baseMapper.insert(rider);
        return convertToVO(rider);
    }
}
