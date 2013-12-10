package com.tellme.common.daoimpl;


import javax.annotation.meta.When;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.tellme.common.dao.MongoDao;
import com.tellme.common.dao.UserDao;
import com.tellme.common.entity.User;

public class UserDaoImpl extends MongoDaoImpl implements UserDao {

	public MongoDao mongoDao;
	public MongoDao getMongoDao() {
		return mongoDao;
	}

	public void setMongoDao(MongoDao mongoDao) {
		this.mongoDao = mongoDao;
	}

	@Override
	public User findByUsername(String username, String collectioName) {
		// TODO Auto-generated method stub
		
		Query query=new Query();
		Criteria criteria=new Criteria();
		Criteria.where("name").is(username);
		query.addCriteria(criteria);
		return this.usermongoTemplate.findOne(query, User.class, collectioName);
	}

	@Override
	public Page<User> findUserQuery(PageRequest pagerequest, Query query,
			String collectioName) {
		// TODO Auto-generated method stub
		if(pagerequest!=null)
		{
			query.skip(pagerequest.getPageSize()*pagerequest.getPageNumber()).limit(pagerequest.getPageSize());
		}
		Page<User> find = (Page<User>)this.usermongoTemplate.find(query, User.class, collectioName);
		return find;
	}

	@Override
	public Page<User> findAllUser(String collectionName) {
		// TODO Auto-generated method stub
		Page<User> find = (Page<User>)this.usermongoTemplate.findAll(User.class, collectionName);
		return find;
	}


}
