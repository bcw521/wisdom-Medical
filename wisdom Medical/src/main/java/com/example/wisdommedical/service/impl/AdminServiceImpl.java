package com.example.wisdommedical.service.impl;

import com.example.wisdommedical.entity.*;
import com.example.wisdommedical.mapper.AdminMapper;
import com.example.wisdommedical.mapper.DoctorMapper;
import com.example.wisdommedical.service.AdminService;
import com.example.wisdommedical.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public Admin login(Admin admin) {
        return adminMapper.login(admin);
    }
    @Override
    public void adminuppwd(String password,Integer id) {
        adminMapper.adminuppwd(password,id);
    }

    @Override
    public void insert(DoctorInfo record) {
        adminMapper.insert(record);
    }
    @Override
    public void delete(String name) {
        adminMapper.delete(name);
    }

    @Override
    public List<DoctorInfo> showdoctor() {
        return adminMapper.showdoctor();
    }

}
