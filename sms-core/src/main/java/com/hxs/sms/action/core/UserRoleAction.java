package com.hxs.sms.action.core;

import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.UserRoleAddForm;
import com.hxs.sms.form.core.UserRoleQueryForm;
import com.hxs.sms.model.core.Role;
import com.hxs.sms.result.Result;
import com.hxs.sms.service.core.UserRoleService;
import com.hxs.sms.web.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： UserRoleAction
 * @类描述： 用户角色管理控制器
 * @创建人： huxinsheng
 * @创建时间： 2017-04-08 15:30
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Controller
@RequestMapping("/core/userRole")
public class UserRoleAction {
    @Resource
    UserRoleService userRoleService;

    @RequestMapping(value = "/query")
    @ResponseBody
    public List<Role> query(UserRoleQueryForm form) {
        return userRoleService.findByEntity(form);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public Result add(@Login UserInfo userInfo, UserRoleAddForm form) {
        return userRoleService.add(userInfo, form);
    }
}
