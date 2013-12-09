package com.tellme.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

public interface MongoService {
	public <T> T save(T entity,String collectionNmae);
	public <T> T delete(T entity,String collectionNmae);
	public long getCount(Query query,String collectionName);

}
