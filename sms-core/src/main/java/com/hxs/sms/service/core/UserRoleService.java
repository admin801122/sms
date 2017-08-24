package com.hxs.sms.service.core;

import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.UserRoleAddForm;
import com.hxs.sms.form.core.UserRoleQueryForm;
import com.hxs.sms.model.core.Role;
import com.hxs.sms.result.Result;

import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： UserRoleService
 * @类描述： 用户角色管理服务接口
 * @创建人： huxinsheng
 * @创建时间： 2017-04-08 15:32
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
public interface UserRoleService {
    /**
     * 查询用户角色信息
     *
     * @param form 查询条件
     * @return 角色信息列表
     */
    List<Role> findByEntity(UserRoleQueryForm form);

    /**
     * 添加用户角色关联信息
     *
     * @param userInfo 操作用户
     * @param userRole 用户角色信息
     * @return 操作结果
     */
    Result add(UserInfo userInfo, UserRoleAddForm userRole);

    /**
     * 删除用户角色关联信息
     *
     * @param userId 用户id
     * @param roleId 角色id
     */
    void deleteByUserIdAndRoleId(String userId, String roleId);
}
