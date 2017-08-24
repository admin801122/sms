package com.hxs.sms.action.core;

import com.hxs.sms.service.core.RoleMenuPermissionService;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.RoleMenuPermissionAddForm;
import com.hxs.sms.form.core.RoleMenuPermissionQueryForm;
import com.hxs.sms.model.core.RoleMenuPermission;
import com.hxs.sms.result.Result;
import com.hxs.sms.web.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： RoleMenuPermissionAction
 * @类描述： 角色菜单权限管理控制器
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 18:49
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Controller
@RequestMapping("/core/roleMenuPermission")
public class RoleMenuPermissionAction {
    @Resource
    RoleMenuPermissionService roleMenuPermissionService;

    @RequestMapping("/query")
    @ResponseBody
    public List<RoleMenuPermission> query(RoleMenuPermissionQueryForm roleMenuPermission) {
        return roleMenuPermissionService.query(roleMenuPermission);
    }

    @RequestMapping("add")
    @ResponseBody
    public Result add(@Login UserInfo userInfo, RoleMenuPermissionAddForm form) {
        return roleMenuPermissionService.add(userInfo, form);
    }
}
