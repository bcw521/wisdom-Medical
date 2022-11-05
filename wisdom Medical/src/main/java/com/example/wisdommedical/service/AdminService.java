package com.example.wisdommedical.service;

import com.example.wisdommedical.entity.*;

import java.util.List;

public interface AdminService {

    Admin login(Admin admin);

    void adminuppwd(String password, Integer id);

    void insert(DoctorInfo record);

    void delete(String name);

    List<DoctorInfo> showdoctor();

}
