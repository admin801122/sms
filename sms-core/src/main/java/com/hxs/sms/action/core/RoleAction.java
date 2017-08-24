package com.hxs.sms.action.core;

import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.RoleAddForm;
import com.hxs.sms.form.core.RoleQueryForm;
import com.hxs.sms.form.core.RoleUpdateForm;
import com.hxs.sms.result.Result;
import com.hxs.sms.service.core.RoleService;
import com.hxs.sms.web.ViewNames;
import com.hxs.sms.web.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： RoleAction
 * @类描述： 角色管理控制器
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 17:16
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Controller
@RequestMapping("/core/role")
public class RoleAction extends ViewAction {
    @Resource
    RoleService roleService;

    @RequestMapping
    public ModelAndView index(@Login UserInfo userInfo) {
        ModelAndView mv = createModelAndView(userInfo, ViewNames.ROLE_VIEW);
        return mv;
    }

    @RequestMapping(value = "query")
    @ResponseBody
    public List<Object> query(RoleQueryForm form) {
        return roleService.query(form);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@Login UserInfo userInfo, RoleAddForm form) {
        return roleService.add(userInfo, form);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@Login UserInfo userInfo, RoleUpdateForm form) {
        return roleService.update(userInfo, form);
    }

    @RequestMapping(value = "delete/{id}")
    @ResponseBody
    public Result delete(@Login UserInfo userInfo, @PathVariable("id") String id) {
        return roleService.delete(userInfo, id);
    }
}
