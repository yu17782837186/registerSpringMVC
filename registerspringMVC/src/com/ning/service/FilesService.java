package com.ning.service;

import com.ning.pojo.Files;
import com.ning.pojo.Register;

import java.util.List;

public interface FilesService {
    /*
    * 显示全部
    * */
    List<Files> show();
    /*
    * 根据id修改资料的下载次数
    * */
    int updCount(int id,Register register,String name);
}
