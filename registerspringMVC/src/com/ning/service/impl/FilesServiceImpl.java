package com.ning.service.impl;

import com.ning.mapper.FilesMapper;
import com.ning.pojo.Files;
import com.ning.pojo.Register;
import com.ning.service.FilesService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FilesServiceImpl implements FilesService {
    @Resource
    private FilesMapper filesMapper;
    @Override
    public List<Files> show() {
        return filesMapper.selAll();
    }

    @Override
    public int updCount(int id,Register register,String name) {
        Logger logger = Logger.getLogger(FilesServiceImpl.class);
        logger.info(register.getUsername()+"下载了"+name);
        return filesMapper.updCountById(id);
    }
}
