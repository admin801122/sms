package com.hxs.sms.action.core;

import com.hxs.sms.form.core.PermissionAddForm;
import com.hxs.sms.model.core.Permission;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.PermissionQueryForm;
import com.hxs.sms.form.core.PermissionUpdateForm;
import com.hxs.sms.result.DataTableResult;
import com.hxs.sms.result.Result;
import com.hxs.sms.service.core.PermissionService;
import com.hxs.sms.web.ViewNames;
import com.hxs.sms.web.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @项目名称： hxs-sms
 * @类名称： PermissionAction
 * @类描述： 权限管理控制器
 * @创建人： huxinsheng
 * @创建时间： 2017-04-06 16:17
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Controller
@RequestMapping("/core/permission")
public class PermissionAction extends ViewAction {
    @Resource
    PermissionService permissionService;

    @RequestMapping
    public ModelAndView index(@Login UserInfo userInfo) {
        ModelAndView mv = createModelAndView(userInfo, ViewNames.PERMISSION_VIEW);
        return mv;
    }

    @ResponseBody
    @RequestMapping("query")
    public DataTableResult<Permission> query(PermissionQueryForm form) {
        return permissionService.query(form);
    }

    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@Login UserInfo userInfo, PermissionAddForm form) {
        return permissionService.add(userInfo, form);
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(@Login UserInfo userInfo, PermissionUpdateForm form) {
        return permissionService.update(userInfo, form);
    }

    @ResponseBody
    @RequestMapping(value = "delete/{id}")
    public Result delete(@Login UserInfo userInfo, @PathVariable("id") String id) {
        return permissionService.delete(userInfo, id);
    }
}
