package com.example.wisdommedical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Expert {
    private String name;
    private Date dictor_time;
    private Integer number;
    private Integer last_number;
    private Integer dictor_id;
    private String sex;
}
