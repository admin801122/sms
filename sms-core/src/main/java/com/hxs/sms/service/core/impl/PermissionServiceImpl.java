package com.hxs.sms.service.core.impl;

import com.hxs.sms.form.core.PermissionAddForm;
import com.hxs.sms.form.core.PermissionUpdateForm;
import com.hxs.sms.model.core.Permission;
import com.hxs.sms.service.core.MenuPermissionService;
import com.hxs.sms.service.core.PermissionService;
import com.hxs.sms.service.core.RoleMenuPermissionService;
import com.hxs.sms.UserInfo;
import com.hxs.sms.dao.core.PermissionDAO;
import com.hxs.sms.form.core.PermissionQueryForm;
import com.hxs.sms.model.core.BillSequnceKey;
import com.hxs.sms.service.core.BillService;
import com.hxs.sms.result.DataTablePaginationResult;
import com.hxs.sms.result.DataTableResult;
import com.hxs.sms.result.Result;
import com.hxs.sms.util.CommonUtils;
import com.hxs.sms.util.Const;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： PermissionServiceImpl
 * @类描述： 权限管理服务接口实现类
 * @创建人： huxinsheng
 * @创建时间： 2017-04-06 16:32
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    PermissionDAO permissionDAO;

    @Resource
    RoleMenuPermissionService roleMenuPermissionService;

    @Resource
    MenuPermissionService menuPermissionService;

    @Resource
    BillService billService;

    public DataTableResult<Permission> query(PermissionQueryForm form) {
        if (null != form) {
            long count = permissionDAO.count(form);
            List<Permission> list = permissionDAO.query(form);
            return new DataTablePaginationResult<Permission>(count, list, form);
        } else {
            return null;
        }
    }

    @Transactional
    public Result add(UserInfo userInfo, PermissionAddForm form) {
        Permission permission = permissionDAO.findByIdAndName(null, form.getName());
        if (null != permission) {
            return Result.error(Result.EXISTS, "权限名称已存在");
        }
        permission = new Permission();
        BeanUtils.copyProperties(form, permission);
        CommonUtils.fillingValue(userInfo, permission, Const.ADD);
        String id = billService.newBillNo(new BillSequnceKey("permissionId"));
        permission.setId(id);
        permissionDAO.insert(permission);
        return Result.ok();
    }

    @Transactional
    public Result update(UserInfo userInfo, PermissionUpdateForm form) {
        Permission permission = permissionDAO.findByIdAndName(form.getId(), form.getName());
        if (null != permission) {
            return Result.error(Result.EXISTS, "权限名称已存在");
        }
        permission = new Permission();
        BeanUtils.copyProperties(form, permission);
        CommonUtils.fillingValue(userInfo, permission, !Const.ADD);
        permissionDAO.update(permission);
        return Result.ok();
    }

    @Transactional
    public Result delete(UserInfo userInfo, String id) {
        Permission permission = permissionDAO.findByIdAndName(id, null);
        //角色菜单权限信息
        roleMenuPermissionService.deleteByRoleIdAndMenuIdAndPermissionId(null, null, id);
        //菜单权限信息
        menuPermissionService.deleteByMenuIdAndPermissionId(id, null);
        permissionDAO.deleteById(id);
        return Result.ok();
    }

}
