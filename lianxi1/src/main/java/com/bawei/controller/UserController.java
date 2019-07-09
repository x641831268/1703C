package com.bawei.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bawei.bean.User;
import com.bawei.service.UserService;

@Controller
public class UserController {
    
	@Resource
	private UserService service;
	
	@RequestMapping("/list.do")
	public String findAll(ModelMap model){
		List<User> list=service.findAll();
		model.put("list", list);
		return "list";
	}
	
}
