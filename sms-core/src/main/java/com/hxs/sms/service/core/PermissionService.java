package com.hxs.sms.service.core;

import com.hxs.sms.form.core.PermissionAddForm;
import com.hxs.sms.form.core.PermissionUpdateForm;
import com.hxs.sms.model.core.Permission;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.PermissionQueryForm;
import com.hxs.sms.result.DataTableResult;
import com.hxs.sms.result.Result;

/**
 * @项目名称： hxs-sms
 * @类名称： PermissionService
 * @类描述： 权限管理服务接口
 * @创建人： huxinsheng
 * @创建时间： 2017-04-06 16:37
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
public interface PermissionService {
    /**
     * 查询权限信息
     *
     * @param form 查询条件
     * @return 查询返回结果
     */
    DataTableResult<Permission> query(PermissionQueryForm form);

    /**
     * 添加权限信息
     *
     * @param userInfo 操作用户
     * @param form     权限信息
     * @return 操作结果
     */
    Result add(UserInfo userInfo, PermissionAddForm form);

    /**
     * 更新权限信息
     *
     * @param userInfo 操作用户
     * @param form     权限信息
     * @return 操作结果
     */
    Result update(UserInfo userInfo, PermissionUpdateForm form);

    /**
     * 删除权限信息
     *
     * @param userInfo 操作用户
     * @param id       权限Id
     * @return 操作结果
     */
    Result delete(UserInfo userInfo, String id);
}
