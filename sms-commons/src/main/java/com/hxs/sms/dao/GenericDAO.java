package com.hxs.sms.dao;

import java.util.List;

import com.hxs.sms.form.QueryForm;


public interface GenericDAO<T,PK> {

	public List<T> getAll();
	
	public T getById(PK id);
	
	public void add(T entity);
	
	public void update(T entity);
	
	public void delete(PK id);
	
	public long count(QueryForm form);
	
	public List<T> query(QueryForm form);
}
