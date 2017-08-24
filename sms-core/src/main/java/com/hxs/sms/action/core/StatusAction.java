package com.hxs.sms.action.core;

import com.hxs.sms.form.core.StatusAddForm;
import com.hxs.sms.form.core.StatusQueryForm;
import com.hxs.sms.form.core.StatusUpdateForm;
import com.hxs.sms.model.core.Status;
import com.hxs.sms.service.core.StatusService;
import com.hxs.sms.UserInfo;
import com.hxs.sms.result.DataTableResult;
import com.hxs.sms.result.Result;
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
 * @类名称： StatusAction
 * @类描述： 状态信息管理控制器
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 11:10
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Controller
@RequestMapping("/core/status")
public class StatusAction extends ViewAction {
    @Resource
    StatusService statusService;

    @RequestMapping
    public ModelAndView index(@Login UserInfo userInfo) {
        ModelAndView mv = createModelAndView(userInfo, ViewNames.STATUS_VIEW);
        return mv;
    }

    @ResponseBody
    @RequestMapping("query")
    public DataTableResult<Status> query(StatusQueryForm form) {
        return statusService.query(form);
    }

    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@Login UserInfo userInfo, StatusAddForm form) {
        return statusService.add(userInfo, form);
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(@Login UserInfo userInfo, StatusUpdateForm form) {
        return statusService.update(userInfo, form);
    }

    @ResponseBody
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    public Result updateStatus(@Login UserInfo userInfo, StatusUpdateForm form) {
        return statusService.updateStatus(userInfo, form);
    }

    @ResponseBody
    @RequestMapping(value = "queryByType/{type}")
    public List<Status> queryByType(@PathVariable("type") String type) {
        return statusService.queryByType(type);
    }
}
