package com.example.wisdommedical.service;

import com.example.wisdommedical.entity.Appointment;
import com.example.wisdommedical.entity.Expert;
import com.example.wisdommedical.entity.Register_user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    void insert(Register_user register_user);

    List<Expert> selectById(Integer id);

    List<Register_user> login(Register_user register_user);
    Register_user login_confirm(Register_user register_user);

    void updateById(Integer last_number,Integer id);

    List<Appointment> query();

    void insertInfo(Appointment appointment);

    void delappointment(Integer id);

    Register_user user_cx(Register_user register_user);

    void updateByName(Integer last_number, String name);

    List<Appointment> searchBycard(String card);

    List<Appointment> page(Integer pageNum, Integer pageSize);

    List<Appointment> queryd(String name);
}
