package com.bawei.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.bean.User;
import com.bawei.mapper.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao dao;
	
	public int zhuce(User user) {
		// TODO Auto-generated method stub
		return dao.zhuce(user);
	}

	public User login(String uname) {
		// TODO Auto-generated method stub
		return dao.login(uname);
	}

}
