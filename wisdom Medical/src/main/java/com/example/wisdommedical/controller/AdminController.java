package com.example.wisdommedical.controller;

import com.example.wisdommedical.common.Result;
import com.example.wisdommedical.controller.dto.ResponseDto;
import com.example.wisdommedical.entity.*;
import com.example.wisdommedical.service.impl.AdminServiceImpl;
import com.example.wisdommedical.service.impl.DoctorServiceImpl;
import com.example.wisdommedical.utils.JWTUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminServiceImpl adminService;
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){
        Admin admin1 = adminService.login(admin);
        if (admin1!=null){
            return Result.success(admin1);
        }else {
            return new Result(false,ResponseDto.SUCCESS,"账号或密码错误",null);
        }
    }
    @PutMapping("/info/updatepwd")
    public Result doctoruppwd(@RequestParam("password") String password,@RequestParam("id") Integer id){
        adminService.adminuppwd(password,id);
        return new Result(true, ResponseDto.SUCCESS,"密码修改成功,请重新登录",null);
    }
    @PostMapping("/record")
    public Result insertRecord(@RequestBody DoctorInfo record){
        adminService.insert(record);
        return Result.success();
    }
    @DeleteMapping("/{name}")
    public Result delete(@PathVariable("name")String name){
        adminService.delete(name);
        return Result.success();
    }
    @GetMapping("/showdoctor")
    public Result showdoctor(){
        List<DoctorInfo> doctorInfos=adminService.showdoctor();
        return Result.success(doctorInfos);
    }
}
