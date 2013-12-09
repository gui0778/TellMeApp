package com.tellme.common.daoimpl;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Reference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.tellme.common.dao.MongoDao;

public class MongoDaoImpl implements MongoDao {

	@Autowired
	public MongoTemplate usermongoTemplate;
	
	public MongoTemplate getUsermongoTemplate() {
		return usermongoTemplate;
	}

	public void setUsermongoTemplate(MongoTemplate usermongoTemplate) {
		this.usermongoTemplate = usermongoTemplate;
	}

	@Override
	public <T> T save(T entity, String collectionNmae) {
		// TODO Auto-generated method stub
		this.usermongoTemplate.save(entity, collectionNmae);
		return entity;
	}

	@Override
	public <T> T delete(T entity, String collectionNmae) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T delete(Query query, String collectionNmae, T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T update(T entity, String collectionNmae) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Page<T> queryAll(Sort sort, String collectionName, T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T findById(T id, String collectionName, T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T findByQuery(Query query, String collectionName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T findByPage(PageRequest pagerequest, Query query,
			String collectionName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getCount(Query query, String collectionName) {
		// TODO Auto-generated method stub
		return null;
	}


}
