package com.tellme.common.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;

 
import com.tellme.common.entity.UserLocation;

public interface UserLocationDao extends MongoDao {
	public Page<UserLocation> findUserQuery(PageRequest pagerequest,Query query,String collectioName);
	

}
