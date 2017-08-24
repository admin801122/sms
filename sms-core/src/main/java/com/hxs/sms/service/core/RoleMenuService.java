package com.hxs.sms.service.core;

import com.hxs.sms.form.core.RoleMenuQueryForm;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.RoleMenuAddForm;
import com.hxs.sms.result.Result;

/**
 * @项目名称： hxs-sms
 * @类名称： RoleMenuService
 * @类描述： 角色菜单服务接口
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 16:51
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
public interface RoleMenuService {

    /**
     * 根据条件查询菜单和已选菜单信息列表
     *
     * @param form 查询条件
     * @return 菜单列表
     */
    Object queryByEntity(RoleMenuQueryForm form);

    /**
     * 添加角色菜单信息
     *
     * @param userInfo 操作用户
     * @param form     角色菜单信息
     * @return 操作结果
     */
    Result add(UserInfo userInfo, RoleMenuAddForm form);

    /**
     * 根据角色id和菜单id删除角色菜单信息
     *
     * @param roleId 角色id
     * @param menuId 菜单id
     */
    void deleteByRoleIdAndMenuId(String roleId,String menuId);
}
