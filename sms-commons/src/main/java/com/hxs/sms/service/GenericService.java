package com.hxs.sms.service;

import com.hxs.sms.form.QueryForm;
import com.hxs.sms.result.QueryResult;

import java.util.List;

public interface GenericService<T, PK> {

    public List<T> getAll();

    public T getById(PK id);

    public void add(T entity);

    public void update(T entity);

    public void delete(PK id);

    public QueryResult<T> query(QueryForm form);
}
