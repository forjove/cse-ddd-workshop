package com.jxmall.user.application;

import java.util.List;

import com.jxmall.user.domain.aggregate.user.UserService;
import com.jxmall.user.domain.aggregate.user.root.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserApplication {

	@Autowired
	private UserService userService;

	public List<User> search(String key) {
		return userService.search(key);
	}

	public void create(User user) {
		userService.create(user);
	}

	public User findById(String id) {
		return userService.findById(id);
	}
}
