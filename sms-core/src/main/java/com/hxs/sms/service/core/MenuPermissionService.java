package com.hxs.sms.service.core;

import com.hxs.sms.model.core.Permission;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.MenuPermissionAddForm;
import com.hxs.sms.form.core.MenuPermissionQueryForm;
import com.hxs.sms.result.Result;

import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： MenuPermissionService
 * @类描述： 菜单权限管理服务接口
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 08:53
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
public interface MenuPermissionService {
    /**
     * 根据菜单和权限信息查询权限信息
     *
     * @param form 查询数据对象
     * @return 权限列表
     */
    List<Permission> query(MenuPermissionQueryForm form);

    /**
     * 添加菜单权限信息
     *
     * @param userInfo 操作用户
     * @param form     菜单权限信息
     * @return 操作结果
     */
    Result add(UserInfo userInfo, MenuPermissionAddForm form);

    /**
     * 根据菜单id删除菜单权限信息
     *
     * @param menuId 菜单id
     * @param permissionId 权限id
     */
    void deleteByMenuIdAndPermissionId(String menuId,String permissionId);
}
