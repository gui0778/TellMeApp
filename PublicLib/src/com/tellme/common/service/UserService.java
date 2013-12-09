package com.tellme.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.tellme.common.entity.User;
@Service
public interface UserService extends MongoService{
	public User findByUsername(String username,String collectioName);
	public Page<User> findUserQuery(PageRequest pagerequest,Query query,String collectioName);

}
