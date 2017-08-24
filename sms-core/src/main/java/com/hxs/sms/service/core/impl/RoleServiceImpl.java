package com.hxs.sms.service.core.impl;

import com.hxs.sms.form.core.RoleAddForm;
import com.hxs.sms.form.core.RoleQueryForm;
import com.hxs.sms.form.core.RoleUpdateForm;
import com.hxs.sms.model.core.BillSequnceKey;
import com.hxs.sms.model.core.Menu;
import com.hxs.sms.model.core.Role;
import com.hxs.sms.model.core.TreeJson;
import com.hxs.sms.service.core.*;
import com.hxs.sms.UserInfo;
import com.hxs.sms.dao.core.RoleDAO;
import com.hxs.sms.result.Result;
import com.hxs.sms.util.CommonUtils;
import com.hxs.sms.util.Const;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： RoleServiceImpl
 * @类描述： 角色管理服务接口实现类
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 16:20
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleDAO roleDAO;

    @Resource
    BillService billService;

    @Resource
    RoleMenuService roleMenuService;

    @Resource
    RoleMenuPermissionService roleMenuPermissionService;

    @Resource
    UserRoleService userRoleService;

    public List<Object> query(RoleQueryForm form) {
        form.setPagination(false);
        String parent = "0";
        form.setParent(parent);
        List<Role> roles = roleDAO.findByEntity(form);
        List<Object> treeJsons = new ArrayList<Object>();
        if (CollectionUtils.isNotEmpty(roles)) {
            for (Role r : roles) {

                List<Menu> menuList = r.getMenus();
                TreeJson<Role> roleTreeJson = new TreeJson<Role>();
                roleTreeJson.setId(r.getId());
                roleTreeJson.setLevel(0);
                roleTreeJson.setParent(parent);
                roleTreeJson.setEntity(r);
                treeJsons.add(roleTreeJson);
                if (CollectionUtils.isEmpty(menuList)) {
                    roleTreeJson.setLeaf(true);
                    roleTreeJson.setExpanded(true);
                } else {
                    buildMenuJson(treeJsons, menuList, roleTreeJson);
                }

            }
        }
        return treeJsons;
    }

    private void buildMenuJson(List<Object> roleJsonList, List<Menu> menuList, TreeJson roleJson) {
        for (Menu menu : menuList) {
            TreeJson rj = new TreeJson();
            rj.setId(menu.getId() + "_" + roleJson.getId());
            rj.setIcon(menu.getIcon());
            rj.setParent(roleJson.getId());
            rj.setParent(roleJson.getId());
            rj.setLevel(menu.getLevel() + 1);
            rj.setEntity(menu);
            List<Menu> childMenus = menu.getSubMenus();
            if (CollectionUtils.isEmpty(childMenus)) {
                rj.setLeaf(true);
                rj.setExpanded(true);
            } else {
                rj.setLeaf(false);
                rj.setExpanded(false);
                //menu.setChildMenu(null);
            }
            roleJsonList.add(rj);
            if (CollectionUtils.isNotEmpty(childMenus)) {
                buildMenuJson(roleJsonList, childMenus, rj);
            }
        }
    }

    public Result add(UserInfo userInfo, RoleAddForm form) {
        Role role = roleDAO.findExistsByName(null, form.getName(), form.getSign());
        if (null != role) {
            return Result.error(Result.EXISTS, "角色信息已存在.");
        }
        role = new Role();
        BeanUtils.copyProperties(form, role);
        String id = billService.newBillNo(new BillSequnceKey("roleId"));
        role.setId(id);
        CommonUtils.fillingValue(userInfo, role, Const.ADD);
        roleDAO.insert(role);
        return Result.ok(role);
    }

    public Result update(UserInfo userInfo, RoleUpdateForm form) {
        Role role = roleDAO.findExistsByName(form.getId(), form.getName(), form.getSign());
        if (null != role) {
            return Result.error(Result.EXISTS, "角色信息已存在.");
        }
        role = new Role();
        BeanUtils.copyProperties(form, role);
        CommonUtils.fillingValue(userInfo, role, !Const.ADD);
        roleDAO.update(role);
        return Result.ok(role);
    }

    public Result delete(UserInfo userInfo, String id) {
        //角色菜单资源
        roleMenuPermissionService.deleteByRoleIdAndMenuIdAndPermissionId(id, null, null);
        //角色菜单信息
        roleMenuService.deleteByRoleIdAndMenuId(id, null);
        //用户角色信息
        userRoleService.deleteByUserIdAndRoleId(null, id);
        //角色信息
        roleDAO.deleteById(id);
        return Result.ok();
    }
}
