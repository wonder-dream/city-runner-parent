package com.vague.runner.api.controller;

import com.vague.runner.common.result.Result;
import com.vague.runner.model.dto.RegisterDTO;
import com.vague.runner.model.dto.RiderCertificationDTO;
import com.vague.runner.model.vo.UserVO;
import com.vague.runner.service.RiderService;
import com.vague.runner.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping(value = "/api/rider")
@RequiredArgsConstructor
public class RiderController {
    private final RiderService riderService;

    @PostMapping(value = "/register")
    public Result<UserVO> register(@RequestBody RiderCertificationDTO dto) {
        /*
         * 前端获取用户输入的信息，
         * 通过https加密信道传输到后端，
         * 由controller接收转发给service进行处理
         * */
        log.info("Register Rider: {}", dto.getPhone());
        return Result.success(riderService.certificationRider(dto));
    }
}
