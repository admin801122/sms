package com.hxs.sms.service.core.impl;

import com.hxs.sms.dao.core.RoleMenuDAO;
import com.hxs.sms.form.core.RoleMenuAddForm;
import com.hxs.sms.form.core.RoleMenuQueryForm;
import com.hxs.sms.model.core.Menu;
import com.hxs.sms.model.core.RoleMenu;
import com.hxs.sms.service.core.RoleMenuService;
import com.hxs.sms.UserInfo;
import com.hxs.sms.model.AdditionalParameters;
import com.hxs.sms.model.TreeJsonModel;
import com.hxs.sms.result.Result;
import com.hxs.sms.util.CommonUtils;
import com.hxs.sms.util.Const;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @项目名称： hxs-sms
 * @类名称： RoleMenuServiceImpl
 * @类描述： 角色菜单服务接口实现类
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 16:51
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Resource
    RoleMenuDAO roleMenuDAO;

    public Object queryByEntity(RoleMenuQueryForm form) {
        List<Menu> menuList = roleMenuDAO.queryByEntity(form);
        Map<String, TreeJsonModel> treeJsonModelMap = new LinkedHashMap<String, TreeJsonModel>();
        build(menuList, treeJsonModelMap);
        return treeJsonModelMap;
    }

    private void build(List<Menu> menus, Map<String, TreeJsonModel> treeJsonModelMap) {
        if (CollectionUtils.isNotEmpty(menus)) {
            for (Object obj : menus) {
                Menu menu = (Menu) obj;
                TreeJsonModel treeJsonModel = new TreeJsonModel();
                treeJsonModel.setId(menu.getId());
                treeJsonModel.setCode(menu.getId());
                treeJsonModel.setName(menu.getName());
                AdditionalParameters additionalParameters = new AdditionalParameters();
                additionalParameters.setItemSelected(menu.isChecked());
                treeJsonModel.setParent(menu.getParent());
                if (CollectionUtils.isNotEmpty(menu.getSubMenus())) {
                    treeJsonModel.setType("folder");
                    Map<String, TreeJsonModel> childrenMap = new HashMap<String, TreeJsonModel>();
                    build(menu.getSubMenus(), childrenMap);
                    additionalParameters.setChildren(childrenMap);
                    additionalParameters.setItemSelected(false);
                } else {
                    treeJsonModel.setType("item");
                }
                treeJsonModel.setAdditionalParameters(additionalParameters);
                treeJsonModelMap.put(menu.getName(), treeJsonModel);
            }
        }
    }

    public Result add(UserInfo userInfo, RoleMenuAddForm form) {
        this.deleteByRoleIdAndMenuId(form.getRoleId(), null);
        String temp = form.getMenuId();
        if (StringUtils.isNotEmpty(temp)) {
            List<RoleMenu> roleMenus = new ArrayList<RoleMenu>();
            String[] menuIdArray = temp.split(",");
            for (String s : menuIdArray) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(form.getRoleId());
                roleMenu.setMenuId(s);
                CommonUtils.fillingValue(userInfo, roleMenu, Const.ADD);
                roleMenus.add(roleMenu);
            }
            if (CollectionUtils.isNotEmpty(roleMenus)) {
                roleMenuDAO.insertAll(roleMenus);
            }
        }
        return Result.ok();
    }

    public void deleteByRoleIdAndMenuId(String roleId, String menuId) {
        roleMenuDAO.deleteByRoleIdAndMenuId(roleId, menuId);
    }
}
