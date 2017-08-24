package com.hxs.sms.action.core;

import com.hxs.sms.form.core.RoleMenuQueryForm;
import com.hxs.sms.service.core.RoleMenuService;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.RoleMenuAddForm;
import com.hxs.sms.result.Result;
import com.hxs.sms.web.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @项目名称： hxs-sms
 * @类名称： RoleMenuAction
 * @类描述： 角色菜单管理控制器
 * @创建人： huxinsheng
 * @创建时间： 2017-04-08 09:50
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Controller
@RequestMapping("/core/roleMenu")
public class RoleMenuAction {
    @Resource
    RoleMenuService roleMenuService;

    @RequestMapping(value = "/query")
    @ResponseBody
    public Object query(RoleMenuQueryForm form) {
        Object treeJsonModels = roleMenuService.queryByEntity(form);
        return treeJsonModels;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public Result save(@Login UserInfo userInfo, RoleMenuAddForm form) {
        return roleMenuService.add(userInfo, form);
    }
}
