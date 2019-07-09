package com.bawei.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.bean.User;
import com.bawei.mapper.UserDao;
@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao dao;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
