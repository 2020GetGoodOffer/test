package com.sjh.controller;


import com.sjh.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    @RequestMapping(value = "/index")
    public String index(@RequestParam("str") String name){
        System.out.println(name);
        return "index";
    }

    @RequestMapping(value = "/rest/{name}")
    public String rest(@PathVariable("name") String name){
        System.out.println(name);
        return "index";
    }

    @RequestMapping(value = "/cookie")
    public String cookie(@CookieValue(value = "JSESSIONID") String id){
        System.out.println(id);
        return "index";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(User user){
        System.out.println(user);
        return "redirect:/index.jsp";
    }
}
