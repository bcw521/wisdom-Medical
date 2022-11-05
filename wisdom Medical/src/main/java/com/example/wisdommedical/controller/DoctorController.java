package com.example.wisdommedical.controller;

import com.example.wisdommedical.common.Result;
import com.example.wisdommedical.controller.dto.ResponseDto;
import com.example.wisdommedical.entity.Doctor;
import com.example.wisdommedical.entity.Expert;
import com.example.wisdommedical.entity.Record;
import com.example.wisdommedical.service.impl.DoctorServiceImpl;
import com.example.wisdommedical.utils.JWTUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Resource
    private DoctorServiceImpl doctorService;
    @PostMapping("/login")
    public Result login(@RequestBody Doctor doctor){
        Doctor doctor1 = doctorService.login(doctor);
        if (doctor1!=null){
            String account = doctor1.getAccount();
            String token = JWTUtil.createToken(account);
            String doctorname = doctorService.getdoctorname(account);
            Expert expert=doctorService.getid(doctorname);
            Integer id = expert.getDictor_id();
            Map<String,String> map=new HashMap<>();
            map.put("name",doctorname);
            map.put("token",token);
            map.put("id", String.valueOf(id));
            return Result.success(map);
        }else {
            return new Result(false,ResponseDto.SUCCESS,"账号或密码错误",null);
        }
    }
    @GetMapping("/info")
    public Result doctorInfo(@RequestParam("name") String name){
        String info = doctorService.doctorInfo(name);
        String phone=doctorService.getdoctorphone(name);
        Map<String,String> map=new HashMap<>();
        map.put("info",info);
        map.put("phone",phone);
        return new Result(true, ResponseDto.SUCCESS,null,map);
    }
    @PutMapping("/info")
    public Result doctorupinfo(@RequestBody Doctor doctor){
        doctorService.doctorupinfo(doctor);
        return new Result(true, ResponseDto.SUCCESS,"修改成功",null);
    }
    @PutMapping("/info/updatepwd")
    public Result doctoruppwd(@RequestParam("password") String password,@RequestParam("id") Integer id){
        doctorService.doctoruppwd(password,id);
        return new Result(true, ResponseDto.SUCCESS,"密码修改成功,请重新登录",null);
    }
    @PostMapping("/record")
    public Result insertRecord(@RequestBody Record record){
        doctorService.inrecord(record);
        return Result.success();
    }
    @GetMapping("/record")
    public Result getrecord(@RequestParam("name") String name){
        List<Record> records=doctorService.getrecord(name);
        return new Result(true,ResponseDto.SUCCESS,null,records);
    }
    @PutMapping("/record")
    public Result updaterecord(@RequestBody Record record){
        doctorService.updaterecord(record);
        return new Result(true,ResponseDto.SUCCESS,null,null);
    }
}
