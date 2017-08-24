package com.hxs.sms.service.core.impl;

import com.hxs.sms.dao.core.UserRoleDAO;
import com.hxs.sms.form.core.UserRoleAddForm;
import com.hxs.sms.form.core.UserRoleQueryForm;
import com.hxs.sms.model.core.Role;
import com.hxs.sms.service.core.UserRoleService;
import com.hxs.sms.UserInfo;
import com.hxs.sms.model.core.UserRole;
import com.hxs.sms.result.Result;
import com.hxs.sms.util.CommonUtils;
import com.hxs.sms.util.Const;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： UserRoleServiceImpl
 * @类描述： 用户角色管理服务接口实现类
 * @创建人： huxinsheng
 * @创建时间： 2017-04-08 15:32
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    UserRoleDAO userRoleDAO;

    public List<Role> findByEntity(UserRoleQueryForm form) {
        return userRoleDAO.findByEntity(form);
    }

    @Transactional
    public Result add(UserInfo userInfo, UserRoleAddForm form) {
        this.deleteByUserIdAndRoleId(form.getUserId(), null);
        String temp = form.getRoleId();
        if (StringUtils.isNotEmpty(temp)) {
            List<UserRole> userRoles = new ArrayList<UserRole>();
            String[] roleIdArray = temp.split(",");
            for (String s : roleIdArray) {
                UserRole userRole = new UserRole();
                userRole.setUserId(form.getUserId());
                userRole.setRoleId(s);
                CommonUtils.fillingValue(userInfo, userRole, Const.ADD);
                userRoles.add(userRole);
            }
            if (CollectionUtils.isNotEmpty(userRoles)) {
                userRoleDAO.insertAll(userRoles);
            }
        }
        return Result.ok();
    }

    public void deleteByUserIdAndRoleId(String userId, String roleId) {
        userRoleDAO.deleteByUserIdAndRoleId(userId, roleId);
    }
}
