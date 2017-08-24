package com.hxs.sms.dao.core;

import com.hxs.sms.form.core.UserRoleQueryForm;
import com.hxs.sms.model.core.Role;
import com.hxs.sms.model.core.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： UserRoleDAO
 * @类描述： 用户角色管理数据持久接口
 * @创建人： huxinsheng
 * @创建时间： 2017-04-08 15:32
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Repository
public interface UserRoleDAO {

    int deleteByUserIdAndRoleId(@Param("userId") String userId,@Param("roleId") String roleId);

    void insertAll(List<UserRole> userRoles);

    List<Role> findByEntity(UserRoleQueryForm form);
}
