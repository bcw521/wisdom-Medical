package com.example.wisdommedical.common;

import com.example.wisdommedical.controller.dto.ResponseDto;
import com.example.wisdommedical.entity.Register_user;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Resource;
@Data
@AllArgsConstructor
public class Result {
    private boolean success;
    private String code;
    private String message;
    private Object data;

    public Result() {

    }

    public static Result success(){
        return new Result(true,ResponseDto.SUCCESS,null,null);
    }
    public static Result success(Object data){
        return new Result(true,ResponseDto.SUCCESS,null,data);
    }
    public static Result success(String message,Object data){
        return new Result(true,ResponseDto.SUCCESS,message,data);
    }
}
