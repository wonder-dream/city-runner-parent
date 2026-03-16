package com.vague.runner.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vague.runner.common.constant.UserStatus;
import com.vague.runner.common.constant.UserType;
import com.vague.runner.common.exception.BusinessException;
import com.vague.runner.common.result.ResultCode;
import com.vague.runner.common.utils.PasswordUtil;
import com.vague.runner.mapper.UserMapper;
import com.vague.runner.model.dto.RegisterDTO;
import com.vague.runner.model.vo.UserVO;
import com.vague.runner.service.CustomerService;
import com.vague.runner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.vague.runner.model.entity.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private CustomerService customerService;

    private UserVO convertToVO(User user) {
        /*
        * 只返回前端需要展示的字段，
        * 将密码，创建时间等信息过滤
        * */
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user, vo);  // 自动复制同名字段
        return vo;
    }

    @Override
    public UserVO registerCustomer(RegisterDTO dto) {
        /*
        * 接收到由controller转发的注册信息，
        * 在此层对信息进行验证，
        * 判断是否是新用户（此前未注册为骑手），
        * 对密码进行加密，
        * 将加密后的用户信息转发给DAO层进行数据持久化
        * */

        // 验证用户是否已注册为骑手
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone, dto.getPhone());
        User user = baseMapper.selectOne(queryWrapper);

        if (user != null) {
            // 用户已存在，验证密码
            if (!PasswordUtil.matches(dto.getPassword(), user.getPassword())) {
                throw new BusinessException(ResultCode.PASSWORD_ERROR);
            }
            // 用户已存在，检查是否已经为 Customer
            if (UserType.isCustomer(user.getUserType())) {
                throw new BusinessException(ResultCode.PHONE_EXISTS);
            }
            // 追加成为 Customer
            user.setUserType((byte)(user.getUserType() | UserType.CUSTOMER));
            if (user.getNickname() == null) {
                user.setNickname(dto.getNickname());
            }
            baseMapper.updateById(user);
            return convertToVO(user);
        } else {
            // 创建用户
            User newUser = new User();
            newUser.setPhone(dto.getPhone());
            newUser.setUserType(UserType.CUSTOMER);
            newUser.setNickname(dto.getNickname());
            newUser.setStatus(UserStatus.NORMAL);
            // 密码加密
            String encryptedPassword = PasswordUtil.encode(dto.getPassword());
            newUser.setPassword(encryptedPassword);

            // 将用户信息插入数据库
            baseMapper.insert(newUser);
            // 创建 u_customer 表中记录
            customerService.createCustomerProfile(newUser.getId());
            return convertToVO(newUser);
        }
    }
}
