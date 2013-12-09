package com.tellme.common.serviceImpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.tellme.common.dao.MongoDao;
import com.tellme.common.service.MongoService;

public class MongoServieImpl implements MongoService {

	public MongoDao getMongoDao() {
		return mongoDao;
	}

	public void setMongoDao(MongoDao mongoDao) {
		this.mongoDao = mongoDao;
	}

	public MongoDao mongoDao;
	@Override
	public <T> T save(T entity, String collectionNmae) {
		// TODO Auto-generated method stub
		mongoDao.save(entity, collectionNmae);
		return entity;
	}

	@Override
	public <T> T delete(T entity, String collectionNmae) {
		// TODO Auto-generated method stub
		mongoDao.delete(entity, collectionNmae);
		return null;
	}

	@Override
	public long  getCount(Query query, String collectionName) {
		// TODO Auto-generated method stub
		return mongoDao.getCount(query, collectionName);
	}

}
