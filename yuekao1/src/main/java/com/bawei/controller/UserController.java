package com.bawei.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.bean.User;
import com.bawei.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService service;
	
    @RequestMapping("/zhuce.do")
    @ResponseBody
	public Integer zhuce(User user){
    	int num=service.zhuce(user);
    	return num;
    }
    
    @RequestMapping("/login.do")
    @ResponseBody
	public Integer login(User u,HttpSession session){
    	String uname = u.getUname();
    	User user=service.login(uname);
    	if(user!=null){
    		if(u.getUpwd().equals(user.getUpwd())){
    			if(user.getUtype()==0){
    				session.setAttribute("user", user);
    				return 0;
    			}else{
    				session.setAttribute("user", user);
    				return 1;
    			}
    		}else{
    			return 2;
    		}
    	}else{
    		return 3;
    	}
    	
    }
}
