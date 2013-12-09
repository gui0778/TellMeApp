package com.tcyclient.tellme.mongo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.server.tellme.entity.User;

public class MongDaoImpl implements MongoDao {
	public MongoTemplate getMongo() {
		return mongo;
	}

	public void setMongo(MongoTemplate mongo) {
		this.mongo = mongo;
	}

	@Inject
	@Named("usermsgMongoTemplate")
	public MongoTemplate mongo;
	public <T> T save(T entity,String collectionNmae) {
		// TODO Auto-generated method stub
		mongo.save(entity,collectionNmae);
		return entity;
	}


	public <T> Page<T> query() {
		// TODO Auto-generated method stub
		return new PageImpl<T>((List<T>) mongo.findAll(User.class));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public <T> T delete(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T update(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
