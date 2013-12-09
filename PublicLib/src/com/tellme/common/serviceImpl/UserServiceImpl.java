package com.tellme.common.serviceImpl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;

import com.tellme.common.dao.MongoDao;
import com.tellme.common.dao.UserDao;
import com.tellme.common.entity.User;
import com.tellme.common.service.MongoService;
import com.tellme.common.service.UserService;



public class UserServiceImpl extends MongoServieImpl implements UserService {


	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao userDao;
	@Autowired
	public MongoDao mongoDao;
	@Override
	public User findByUsername(String username, String collectioName) {
		// TODO Auto-generated method stub
		return this.userDao.findByUsername(username, collectioName);
	}

	@Override
	public Page<User> findUserQuery(PageRequest pagerequest, Query query,
			String collectioName) {
		// TODO Auto-generated method stub
		return this.userDao.findUserQuery(pagerequest,query, collectioName);
	}
	

}
