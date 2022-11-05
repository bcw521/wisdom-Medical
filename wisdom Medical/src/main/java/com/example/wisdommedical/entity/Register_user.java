package com.example.wisdommedical.entity;

import lombok.Data;

@Data
public class Register_user {
    private String name;
    private String card;
    private String sex;
    private String phone;
    private String address;
    private String disease;
    private String password;
}
