package com.hxs.sms.action.core;

import com.hxs.sms.model.core.Permission;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.MenuPermissionAddForm;
import com.hxs.sms.form.core.MenuPermissionQueryForm;
import com.hxs.sms.result.Result;
import com.hxs.sms.service.core.MenuPermissionService;
import com.hxs.sms.web.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： MenuPermissionAction
 * @类描述： 菜单权限管理控制器
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 08:52
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Controller
@RequestMapping("/core/menuPermission")
public class MenuPermissionAction {
    @Resource
    MenuPermissionService menuPermissionService;

    @RequestMapping("query")
    @ResponseBody
    public List<Permission> query(MenuPermissionQueryForm form) {
        return menuPermissionService.query(form);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@Login UserInfo userInfo, MenuPermissionAddForm form) {
        return menuPermissionService.add(userInfo, form);
    }
}
