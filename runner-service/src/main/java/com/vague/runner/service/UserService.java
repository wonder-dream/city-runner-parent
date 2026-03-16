package com.vague.runner.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vague.runner.model.dto.RegisterDTO;
import com.vague.runner.model.entity.User;
import com.vague.runner.model.vo.UserVO;

public interface UserService extends IService<User> {
    UserVO registerCustomer(RegisterDTO dto);
}
