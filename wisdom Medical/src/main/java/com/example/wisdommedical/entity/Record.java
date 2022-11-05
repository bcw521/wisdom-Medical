package com.example.wisdommedical.entity;

import lombok.Data;

@Data
public class Record {
    private String name;
    private String career;
    private String sex;
    private String address;
    private Integer age;
    private boolean hospital;
    private String doctor_name;
    private String create_d_time;
    private String disease;
}
