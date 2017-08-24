package com.hxs.sms.service.core;

import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.RoleMenuPermissionAddForm;
import com.hxs.sms.form.core.RoleMenuPermissionQueryForm;
import com.hxs.sms.model.core.RoleMenuPermission;
import com.hxs.sms.result.Result;

import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： RoleMenuPermissionService
 * @类描述： 角色菜单权限管理服务接口
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 18:55
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
public interface RoleMenuPermissionService {
    /**
     * 查询角色菜单权限信息
     *
     * @param form 查询条件
     * @return 菜单权限信息
     */
    List<RoleMenuPermission> query(RoleMenuPermissionQueryForm form);

    /**
     * 添加角色菜单权限信息
     *
     * @param userInfo 操作用户
     * @param form     角色菜单权限信息
     * @return 操作结果
     */
    Result add(UserInfo userInfo, RoleMenuPermissionAddForm form);

    /**
     * 根据菜单id删除角色菜单权限关联信息
     *
     * @param roleId       角色id
     * @param menuId       菜单id
     * @param permissionId 权限id
     */
    void deleteByRoleIdAndMenuIdAndPermissionId(String roleId, String menuId, String permissionId);

    /**
     * 根据角色id列表查询权限列表
     *
     * @param roleIds 角色id列表
     * @return 角色关联权限列表
     */
    List<String> findByRoleIds(List<String> roleIds);
}
