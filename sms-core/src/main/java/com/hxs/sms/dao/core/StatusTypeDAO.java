package com.hxs.sms.dao.core;

import com.hxs.sms.form.core.StatusTypeQueryForm;
import com.hxs.sms.model.core.StatusType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusTypeDAO {
    long count(StatusTypeQueryForm form);

    List<StatusType> query(StatusTypeQueryForm form);

    int insert(StatusType statusType);

    int update(StatusType statusType);

    void deleteById(@Param("id") String id);

    StatusType findByIdAndName(@Param("id") Integer id, @Param("name") String name);
}
