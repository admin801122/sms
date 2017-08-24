package com.hxs.sms.service.core.impl;

import com.hxs.sms.dao.core.MenuPermissionDAO;
import com.hxs.sms.form.core.MenuPermissionDeleteForm;
import com.hxs.sms.model.core.Permission;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.MenuPermissionAddForm;
import com.hxs.sms.form.core.MenuPermissionQueryForm;
import com.hxs.sms.model.core.MenuPermission;
import com.hxs.sms.result.Result;
import com.hxs.sms.service.core.MenuPermissionService;
import com.hxs.sms.util.CommonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： MenuPermissionServiceImpl
 * @类描述：菜单权限管理服务接口实现类
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 08:54
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Service
public class MenuPermissionServiceImpl implements MenuPermissionService {
    @Resource
    MenuPermissionDAO menuPermissionDAO;

    public List<Permission> query(MenuPermissionQueryForm form) {
        return menuPermissionDAO.findPermissionByEntity(form);
    }

    @Transactional
    public Result add(UserInfo userInfo, MenuPermissionAddForm form) {
        String temp = form.getPermissionId();
        MenuPermissionDeleteForm deleteForm = new MenuPermissionDeleteForm();
        deleteForm.setMenuId(form.getMenuId());
        menuPermissionDAO.deleteBySelective(deleteForm);
        if (StringUtils.isNotEmpty(temp)) {
            String[] permissionIdArray = temp.split(",");
            List<MenuPermission> menuPermissions = new ArrayList<MenuPermission>();
            for (String permissionId : permissionIdArray) {
                MenuPermission menuPermission = new MenuPermission();
                menuPermission.setMenuId(form.getMenuId());
                menuPermission.setPermissionId(permissionId);
                CommonUtils.fillingValue(userInfo, menuPermission, true);
                menuPermissions.add(menuPermission);
            }
            if (CollectionUtils.isNotEmpty(menuPermissions)) {
                menuPermissionDAO.insertAll(menuPermissions);
            }
        }
        return Result.ok();
    }

    public void deleteByMenuIdAndPermissionId(String menuId, String permissionId) {
        menuPermissionDAO.deleteByMenuId(menuId, permissionId);
    }
}
