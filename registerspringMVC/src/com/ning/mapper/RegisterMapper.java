package com.ning.mapper;

import com.ning.pojo.Register;
import org.apache.ibatis.annotations.Insert;

public interface RegisterMapper {
    @Insert("insert into register values(default,#{username},#{password},#{photo})")
    int insRegister(Register register);
}
