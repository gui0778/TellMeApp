package com.tellme.common.daoimpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;

import com.tellme.common.dao.MongoDao;
import com.tellme.common.dao.UserLocationDao;
import com.tellme.common.entity.UserLocation;

public class UserLocationDaoImpl extends MongoDaoImpl implements
		UserLocationDao {

	public MongoDao mongoDao;
	public MongoDao getMongoDao() {
		return mongoDao;
	}

	public void setMongoDao(MongoDao mongoDao) {
		this.mongoDao = mongoDao;
	}

	@Override
	public Page<UserLocation> findUserQuery(PageRequest pagerequest,
			Query query, String collectioName) {
		// TODO Auto-generated method stub
		if(pagerequest!=null)
		{
			query.skip(pagerequest.getPageSize()*pagerequest.getPageNumber()).limit(pagerequest.getPageSize());
		}
		return (Page<UserLocation>)this.usermongoTemplate.find(query, UserLocation.class,collectioName);
	}

}
