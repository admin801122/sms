package com.hxs.sms.service.impl;

import com.hxs.sms.dao.GenericDAO;
import com.hxs.sms.form.PaginationForm;
import com.hxs.sms.form.QueryForm;
import com.hxs.sms.result.PaginationResult;
import com.hxs.sms.result.QueryResult;
import com.hxs.sms.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GenericServiceImpl<T, PK, DAO extends GenericDAO<T, PK>>
        implements GenericService<T, PK> {

    @Autowired
    public DAO dao;

    @Transactional(readOnly = true)
    public List<T> getAll() {
        return dao.getAll();
    }

    @Transactional(readOnly = true)
    public T getById(PK id) {
        return dao.getById(id);
    }

    @Transactional
    public void add(T entity) {
        dao.add(entity);
    }

    @Transactional
    public void update(T entity) {
        dao.update(entity);
    }

    @Transactional
    public void delete(PK id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    public QueryResult<T> query(QueryForm form) {
        List<T> list = dao.query(form);
        QueryResult<T> result;
        if (form instanceof PaginationForm) {
            long count = dao.count(form);
            result = new PaginationResult<T>(count, list, (PaginationForm) form);
        } else {
            result = new QueryResult<T>(list);
        }
        return result;
    }

}
