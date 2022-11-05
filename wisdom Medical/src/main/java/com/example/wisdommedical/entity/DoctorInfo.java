package com.example.wisdommedical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DoctorInfo {
    private String name;
    private String sex;
    private String phone;
    private String dep;
    private Integer number;
    private Integer last_number;
    private boolean is_work;
    private Date work_time;
}
