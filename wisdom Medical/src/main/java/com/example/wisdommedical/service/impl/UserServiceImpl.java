package com.example.wisdommedical.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.example.wisdommedical.entity.Appointment;
import com.example.wisdommedical.entity.Expert;
import com.example.wisdommedical.entity.Register_user;
import com.example.wisdommedical.mapper.UserMapper;
import com.example.wisdommedical.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final String SALT="ying";
    @Resource
    private UserMapper userMapper;
    @Override
    public void insert(Register_user register_user) {
        register_user.setPassword(SecureUtil.md5(register_user.getPassword()+SALT));
        userMapper.insert(register_user);
    }

    @Override
    public List<Expert> selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<Register_user> login(Register_user register_user) {
        return userMapper.login(register_user);
    }
    public Register_user login_confirm(Register_user register_user) {
        register_user.setPassword(SecureUtil.md5(register_user.getPassword()+SALT));
        return userMapper.login_confirm(register_user);
    }

    @Override
    public void updateById(Integer last_number,Integer id) {
        userMapper.updateById(last_number,id);
    }

    @Override
    public List<Appointment> query() {
        List<Appointment> query = userMapper.query();
        return query;
    }

    @Override
    public void insertInfo(Appointment appointment) {
        userMapper.indertInfo(appointment);
    }

    @Override
    public void delappointment(Integer id) {
        userMapper.delappointment(id);
    }

    @Override
    public Register_user user_cx(Register_user register_user) {
        register_user.setPassword(SecureUtil.md5(register_user.getPassword()+SALT));
        return userMapper.user_cx(register_user);
    }

    @Override
    public void updateByName(Integer last_number, String name) {
        userMapper.updateByName(last_number,name);
    }

    @Override
    public List<Appointment> searchBycard(String card) {
        return userMapper.searchBycard(card);
    }

    @Override
    public List<Appointment> page(Integer pageNum, Integer pageSize) {
        return userMapper.page(pageNum,pageSize);
    }

    @Override
    public List<Appointment> queryd(String name) {
        return userMapper.querd(name);
    }
}
