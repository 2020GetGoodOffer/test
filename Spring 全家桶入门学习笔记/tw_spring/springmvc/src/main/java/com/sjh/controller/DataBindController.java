package com.sjh.controller;

import com.sjh.entity.User;
import com.sjh.entity.UserList;
import com.sjh.entity.UserMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
@RequestMapping("/data")
public class DataBindController {

    @RequestMapping("/baseType")
    public String baseType(int id){
        return id + "";
    }

    @RequestMapping("/packageType")
    public String packageType(@RequestParam(value = "num",defaultValue = "0") Integer id){
        return id + "";
    }

    @RequestMapping("/arr")
    public String arr(String[] name){
        return Arrays.toString(name);
    }

    @RequestMapping("/list")
    public String list(UserList userList){
        StringBuilder sb = new StringBuilder();
        for(User user : userList.getUserList())
            sb.append(user).append(",");
        return sb.toString();
    }

    @RequestMapping("/map")
    public String map(UserMap userMap){
        StringBuilder sb = new StringBuilder();
        for(String key : userMap.getUserMap().keySet()){
            sb.append(userMap.getUserMap().get(key)).append(",");
        }
        return sb.toString();
    }

    @RequestMapping("/json")
    public User json(@RequestBody User user){
        user.setId(24);
        user.setName("2020GetGoodOffer");
        return user;
    }

}


