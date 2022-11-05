package com.example.wisdommedical.service.impl;

import com.example.wisdommedical.entity.Doctor;
import com.example.wisdommedical.entity.Expert;
import com.example.wisdommedical.entity.Record;
import com.example.wisdommedical.mapper.DoctorMapper;
import com.example.wisdommedical.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Resource
    private DoctorMapper doctorMapper;
    @Override
    public Doctor login(Doctor doctor) {
        return doctorMapper.login(doctor);
    }

    @Override
    public String getdoctorname(String account) {
        return doctorMapper.getdoctorname(account);
    }

    @Override
    public String doctorInfo(String name) {
        return doctorMapper.doctorInfo(name);
    }

    @Override
    public String getdoctorphone(String name) {
        return doctorMapper.getdoctorphone(name);
    }

    @Override
    public void doctorupinfo(Doctor doctor) {
        doctorMapper.doctorupinfo(doctor);
    }

    @Override
    public Expert getid(String name) {
        return doctorMapper.getid(name);
    }

    @Override
    public void doctoruppwd(String password,Integer id) {
        doctorMapper.doctoruppwd(password,id);
    }

    @Override
    public void inrecord(Record record) {
        doctorMapper.inrrecord(record);
    }

    @Override
    public List<Record> getrecord(String name) {
        return doctorMapper.getrecord(name);
    }

    @Override
    public void updaterecord(Record record) {
        doctorMapper.updaterecord(record);
    }
}
