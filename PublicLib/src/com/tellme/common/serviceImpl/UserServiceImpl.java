package com.tellme.common.serviceImpl;



import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;

import com.tellme.common.dao.MongoDao;
import com.tellme.common.dao.UserDao;
import com.tellme.common.entity.User;
import com.tellme.common.service.UserService;



public class UserServiceImpl extends MongoServieImpl implements UserService {


	public Map<String,User> userlistonline=new HashMap<String,User>();
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

	@Override
	public Page<User> findAllUser() {
		// TODO Auto-generated method stub
		return this.userDao.findAllUser(User.CollectionName);
	}

	@Override
	public User setUserOnline(User user) {
		// TODO Auto-generated method stub
		User oldUser=getUserOnline(user);
		if(oldUser!=null)
		{
			Object oldchl=oldUser.getLinehandler().get("chl");
			oldUser.getLinehandler().put("chl", user.getLinehandler().get("chl"));
			oldUser.getLinehandler().put("oldchl",oldchl);
		}else
		{
			oldUser=user;
		}
		userlistonline.put(oldUser.getName(), oldUser);
		return oldUser;
	}

	@Override
	public User getUserOnline(User user) {
		// TODO Auto-generated method stub
		return userlistonline.get(user.getName());
	}

	@Override
	public User removeUserOnline(User user) {
		// TODO Auto-generated method stub
		userlistonline.remove(user.getName());
		return user;
	}

	@Override
	public User updateUserOnline(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	public void RemoveOldChl(User user)
	{
		User oldUser=getUserOnline(user);
		if(oldUser!=null)
		{
			userlistonline.get(oldUser.getName()).getLinehandler().remove("oldchl");
		}
		
	}

	@Override
	public void removeOldChl(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<User> getAllOnlinesUser() {
		// TODO Auto-generated method stub
		return userlistonline.values();
	}
	

}
