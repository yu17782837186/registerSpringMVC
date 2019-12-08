package com.ning.service.impl;

import com.ning.mapper.RegisterMapper;
import com.ning.pojo.Register;
import com.ning.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterMapper registerMapper;
    @Override
    public int insRegister(Register register) {
        return registerMapper.insRegister(register);
    }
}
