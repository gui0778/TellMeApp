package com.tellme.common.service;

import com.tellme.publiclib.entity.User;

public interface UserService {
	public User findByUsername(String username,String collectioName);

}
