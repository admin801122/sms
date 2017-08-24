package com.hxs.sms.dao.core;

import com.hxs.sms.form.core.RoleQueryForm;
import com.hxs.sms.model.core.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDAO {
    int insert(Role role);

    int update(Role role);

    Role findExistsByName(@Param("id") String id, @Param("name") String name, @Param("sign") String sign);

    int deleteById(@Param("id") String id);

    List<Role> findByEntity(RoleQueryForm form);
}
