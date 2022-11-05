package com.example.wisdommedical.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.example.wisdommedical.common.Result;
import com.example.wisdommedical.entity.Appointment;
import com.example.wisdommedical.entity.Expert;
import com.example.wisdommedical.entity.Register_user;
import com.example.wisdommedical.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
//    @RequestMapping ("/index")
//    public Result test(){
//        return Result.success();
//    }
    @Resource
    private UserServiceImpl userService;
    @PostMapping
    public Result insert(@RequestBody Register_user register_user){
        userService.insert(register_user);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result selectById(@PathVariable("id") Integer id){
        List<Expert> experts = userService.selectById(id);
        return Result.success(experts);
    }
    @PostMapping("/login")
    public Result user_login(@RequestBody Register_user register_user) {
        List<Register_user> login = userService.login(register_user);
        if (CollectionUtil.isNotEmpty(login)) {
            System.out.println(login);
            Register_user login_confirm = userService.login_confirm(register_user);
            if (login_confirm!=null){
                Map<String,String> map=new HashMap<>();
                map.put("name",register_user.getName());
                map.put("sex",login_confirm.getSex());
                return Result.success("1登录成功",map);
            }else {
                return Result.success("2用户名或密码错误",null);
            }
        }else {
            System.out.println(login);
            return Result.success("3用户名不存在,请先注册",null);
        }
    }
    @PostMapping("/login/cx")
    public Result user_cx(@RequestBody Register_user register_user){
        Register_user login_user=userService.user_cx(register_user);
        if (login_user!=null){
            return Result.success("1登录成功",null);
        }else {
            return Result.success("2用户名与身份证绑定的密码不符",null);
        }
    }
    @GetMapping("/login")
    public Result updateById(@RequestParam("last_number") Integer last_number, @RequestParam("id") Integer id){
        userService.updateById(last_number,id);
        return Result.success();
    }
    @GetMapping("/info")
    public Result query(){
        List<Appointment> query = userService.query();
        int total = query.size();
        return Result.success(String.valueOf(total),query);
    }
    @PostMapping("/info")
    public Result appoinmentInfo(@RequestBody Appointment appointment){
        userService.insertInfo(appointment);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delappointment(@PathVariable("id") Integer id){
        userService.delappointment(id);
        return Result.success();
    }
    @PutMapping("/login")
    public Result updateByName(@RequestParam("last_number") Integer last_number, @RequestParam("name") String name){
        userService.updateByName(last_number,name);
        return Result.success();
    }
    @GetMapping("/search")
    public Result searchBycard(@RequestParam("card") String card){
        List<Appointment> appointment = userService.searchBycard(card);
        return Result.success(appointment);
    }
    @GetMapping("/page")
    public Result page(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<Appointment> page = userService.page(pageNum, pageSize);
        return Result.success(page);
    }
    @GetMapping("/info/d")
    public Result queryd(@RequestParam("name") String name){
        List<Appointment> queryd = userService.queryd(name);
        int total = queryd.size();
        return Result.success(String.valueOf(total),queryd);
    }
}

