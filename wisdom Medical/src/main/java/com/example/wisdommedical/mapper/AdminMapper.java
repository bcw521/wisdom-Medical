package com.example.wisdommedical.mapper;

import com.example.wisdommedical.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
    Admin login(Admin admin);

    void adminuppwd(@Param("password") String password,@Param("id") Integer id);
//
    void insert(DoctorInfo record);

    List<DoctorInfo> showdoctor();

    void delete(String name);
}
