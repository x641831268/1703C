package com.bawei.service;

import com.bawei.bean.User;

public interface UserService {

	int zhuce(User user);

	User login(String uname);

}
