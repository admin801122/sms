package com.hxs.sms.service.core;

import com.hxs.sms.form.core.RoleQueryForm;
import com.hxs.sms.form.core.RoleUpdateForm;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.RoleAddForm;
import com.hxs.sms.result.Result;

import java.util.List;

public interface RoleService {
    /**
     * 查询角色信息
     *
     * @param form 查询条件
     * @return 角色信息列表
     */
    List<Object> query(RoleQueryForm form);

    /**
     * 添加角色信息
     *
     * @param userInfo 操作用户
     * @param form     角色信息
     * @return 操作结果
     */
    Result add(UserInfo userInfo, RoleAddForm form);

    /**
     * 更新角色信息
     *
     * @param userInfo 操作用户
     * @param form     角色信息
     * @return 操作结果
     */
    Result update(UserInfo userInfo, RoleUpdateForm form);

    /**
     * 删除角色信息
     *
     * @param userInfo 操作用户
     * @param id       角色id
     * @return 操作结果
     */
    Result delete(UserInfo userInfo, String id);
}
