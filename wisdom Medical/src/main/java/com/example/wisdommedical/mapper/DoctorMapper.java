package com.example.wisdommedical.mapper;

import com.example.wisdommedical.entity.Doctor;
import com.example.wisdommedical.entity.Expert;
import com.example.wisdommedical.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DoctorMapper {
    Doctor login(Doctor doctor);

    String getdoctorname(String account);

    String doctorInfo(String name);

    String getdoctorphone(String name);

    void doctorupinfo(Doctor doctor);

    Expert getid(String name);

    void doctoruppwd(@Param("password") String password,@Param("id") Integer id);

    void inrrecord(Record record);

    List<Record> getrecord(String name);

    void updaterecord(Record record);
}
