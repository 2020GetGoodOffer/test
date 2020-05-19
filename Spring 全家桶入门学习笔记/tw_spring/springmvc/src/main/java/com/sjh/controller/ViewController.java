package com.sjh.controller;

import com.sjh.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/view")
@SessionAttributes(value = "user")
public class ViewController {

    @RequestMapping("/map")
    public String map(Map<String,User> map){
        User user = new User();
        user.setId(1);
        user.setName("sjh");
        map.put("user",user);
        return "view";
    }

    @RequestMapping("/model")//import org.springframework.ui.Model;
    public String model(Model model){
        User user = new User();
        user.setId(1);
        user.setName("sjh");
        model.addAttribute("user",user);
        return "view";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){
        User user = new User();
        user.setId(1);
        user.setName("sjh");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("view");
        return modelAndView;
    }

    @RequestMapping("/modelAndView2")
    public ModelAndView modelAndView2(){
        User user = new User();
        user.setId(1);
        user.setName("sjh");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setView(new InternalResourceView("/view.jsp"));
        return modelAndView;
    }

    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        User user = new User();
        user.setId(1);
        user.setName("sjh");
        request.setAttribute("user",user);
        return "view";
    }

    //@ModelAttribute
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("sjh");
        return user;
    }

    //@ModelAttribute
    public void getUser(Map<String,User> map){
        User user = new User();
        user.setId(1);
        user.setName("sjh");
        map.put("user",user);
    }

    @RequestMapping("/modelAttribute")
    public String modelAttribute(){
        return "view";
    }

    @RequestMapping("/session")
    public String session(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = new User();
        user.setId(1);
        user.setName("sjh");
        session.setAttribute("user",user);
        return "view";
    }

    @RequestMapping("/session2")
    public String session(HttpSession session){
        User user = new User();
        user.setId(1);
        user.setName("sjh");
        session.setAttribute("user",user);
        return "view";
    }

    @RequestMapping("/application")
    public String application(ServletContext servletContext){
        User user = new User();
        user.setId(1);
        user.setName("sjh");
        servletContext.setAttribute("user",user);
        return "view";
    }

}
