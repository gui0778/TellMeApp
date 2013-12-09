package com.tellme.common.dao;

import org.springframework.data.domain.Page;

public interface MongoDao {
	public <T> T save(T entity,String collectionNmae);
	public <T> T delete(T entity);
	public <T> T update(T entity);
	public <T> Page<T> query();


}
