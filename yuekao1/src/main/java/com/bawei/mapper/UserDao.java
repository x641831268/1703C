package com.bawei.mapper;

import com.bawei.bean.User;

public interface UserDao {

	int zhuce(User user);

	User login(String uname);

}
