package com.tellme.common.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;

import com.tellme.common.entity.User;

public interface UserDao extends MongoDao {
	public User findByUsername(String username,String collectioName);
	public Page<User> findUserQuery(PageRequest pagerequest,Query query,String collectioName);

}
