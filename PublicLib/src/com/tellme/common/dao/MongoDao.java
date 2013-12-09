package com.tellme.common.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface MongoDao {
	public <T> T save(T entity,String collectionNmae);
	public <T> T delete(T entity,String collectionNmae);
	public <T> T delete(Query query,String collectionNmae,T entity);
	public <T> T update(T entity,String collectionNmae);
	public <T> Page<T> queryAll(Sort sort,String collectionName,T entity);
	public <T> T findById(T id,String collectionName,T entity);
	public <T> T findByQuery(Query query,String collectionName);
	public <T> T findByPage(PageRequest pagerequest,Query query,String collectionName);
	public <T> T getCount(Query query,String collectionName);
	


}
