package com.example.wisdommedical.mapper;

import com.example.wisdommedical.entity.Appointment;
import com.example.wisdommedical.entity.Expert;
import com.example.wisdommedical.entity.Register_user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(Register_user register_user);

    List<Expert> selectById(Integer id);

    List<Register_user> login(Register_user register_user);
    Register_user login_confirm(Register_user register_user);
    void updateById(@Param("last_number") Integer last_number, @Param("id") Integer id);

    List<Appointment> query();

    void indertInfo(Appointment appointment);

    void delappointment(Integer id);

    Register_user user_cx(Register_user register_user);
    void updateByName(@Param("last_number") Integer last_number, @Param("name") String name);

    List<Appointment> searchBycard(String card);

    List<Appointment> page(@Param("pageNum") Integer pageNumber,@Param("pageSize") Integer pageSize);

    List<Appointment> querd(String name);
}
