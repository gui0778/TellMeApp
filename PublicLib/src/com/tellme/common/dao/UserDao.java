package com.tellme.common.dao;

import com.tellme.publiclib.entity.User;

public interface UserDao extends MongoDao {
	public User findByUsername(String username,String collectioName);

}
