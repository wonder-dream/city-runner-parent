package com.vague.runner.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vague.runner.mapper.RiderMapper;
import com.vague.runner.model.dto.RegisterDTO;
import com.vague.runner.model.dto.RiderCertificationDTO;
import com.vague.runner.model.entity.Rider;
import com.vague.runner.model.vo.RiderVO;
import com.vague.runner.model.vo.UserVO;

public interface RiderService extends IService<Rider> {
    RiderVO certificationRider(RiderCertificationDTO dto);
}
