package com.example.wisdommedical.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Appointment {
    private Integer id;
    private String name;
    private String sex;
    private String dictor_name;
    private String dictor_sex;
    private Date book_time;
    private boolean check;
    private Integer last_number;
}
