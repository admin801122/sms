package com.hxs.sms.dao.core;

import com.hxs.sms.model.core.RoleMenuPermission;
import com.hxs.sms.form.core.RoleMenuPermissionQueryForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： RoleMenuPermissionDAO
 * @类描述： 角色菜单权限管理数据持久接口
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 18:56
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Repository
public interface RoleMenuPermissionDAO {
    List<RoleMenuPermission> selectByEntity(RoleMenuPermissionQueryForm form);

    void deleteByRoleIdAndMenuId(@Param("roleId") String roleId, @Param("menuId") String menuId, @Param("permissionId") String permissionId);

    void insertAll(List<RoleMenuPermission> roleMenuPermissionList);

    List<String> selectByRoleIds(List<String> roleIds);
}
