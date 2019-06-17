package com.jh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jh.pojo.User;
import com.jh.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Reference(timeout = 3000, check = false)
    private UserService userService;

    @RequestMapping("/saveUser/{name}/{age}/{sex}")
    public String saveUser(User user){
        int row = userService.saveUser(user);
        String result = row==1?"入库成功！！":"入库失败！！";
        return result;
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(User user){
        int row = userService.deleteUser(user);
        String result = row!=0?"删除成功！！":"删除失败！！";
        return result;
    }

    @RequestMapping("findAll")
    public List<User> findAll(){
        return userService.find();
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user){
        int row = userService.updateUser(user);
        String result = row!=0?"更新成功！！":"更新失败！！";
        return result;
    }
}
