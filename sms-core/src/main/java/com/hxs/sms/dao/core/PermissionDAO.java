package com.hxs.sms.dao.core;

import com.hxs.sms.form.core.PermissionQueryForm;
import com.hxs.sms.model.core.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDAO {

    int insert(Permission pojo);

    int update(Permission pojo);

    long count(PermissionQueryForm form);

    List<Permission> query(PermissionQueryForm form);

    String getNewCode();

    Permission findByIdAndName(@Param("id") String id, @Param("name") String name);

    void deleteById(@Param("id") String id);
}
