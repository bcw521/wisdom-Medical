package com.example.wisdommedical.service;

import com.example.wisdommedical.entity.Doctor;
import com.example.wisdommedical.entity.Expert;
import com.example.wisdommedical.entity.Record;

import java.util.List;

public interface DoctorService {

    Doctor login(Doctor doctor);

    String getdoctorname(String account);

    String doctorInfo(String name);

    String getdoctorphone(String name);

    void doctorupinfo(Doctor doctor);

    Expert getid(String name);



    void doctoruppwd(String password, Integer id);

    void inrecord(Record record);

    List<Record> getrecord(String name);

    void updaterecord(Record record);
}
