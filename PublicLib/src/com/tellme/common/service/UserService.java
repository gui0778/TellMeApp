package com.tellme.common.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.tellme.common.entity.User;
@Service
public interface UserService extends MongoService{
	public User findByUsername(String username,String collectioName);
	public Page<User> findUserQuery(PageRequest pagerequest,Query query,String collectioName);
	public Page<User> findAllUser();
	public User setUserOnline(User user);
	public User getUserOnline(User user);
	public User removeUserOnline(User user);
	public User updateUserOnline(User user);
	public void removeOldChl(User user);
	public Collection<User> getAllOnlinesUser();

}
