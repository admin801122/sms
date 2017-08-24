package com.hxs.sms.action.core;

import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.StatusTypeAddForm;
import com.hxs.sms.form.core.StatusTypeQueryForm;
import com.hxs.sms.form.core.StatusTypeUpdateForm;
import com.hxs.sms.model.core.StatusType;
import com.hxs.sms.result.DataTableResult;
import com.hxs.sms.result.Result;
import com.hxs.sms.service.core.StatusTypeService;
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
 * @类名称： StatusTypeAction
 * @类描述： 状态类型管理控制器
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 11:10
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Controller
@RequestMapping("/core/type")
public class StatusTypeAction extends ViewAction{
    @Resource
    StatusTypeService statusTypeService;

    @RequestMapping
    public ModelAndView index(@Login UserInfo userInfo) {
        ModelAndView mv = createModelAndView(userInfo, ViewNames.TYPE_VIEW);
        return mv;
    }

    @ResponseBody
    @RequestMapping("query")
    public DataTableResult<StatusType> query(StatusTypeQueryForm form) {
        return statusTypeService.query(form);
    }

    @ResponseBody
    @RequestMapping("queryAll")
    public List<StatusType> queryAll(StatusTypeQueryForm form) {
        return statusTypeService.queryAll(form);
    }

    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@Login UserInfo userInfo, StatusTypeAddForm form) {
        return statusTypeService.add(userInfo, form);
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(@Login UserInfo userInfo, StatusTypeUpdateForm form) {
        return statusTypeService.update(userInfo, form);
    }

    @ResponseBody
    @RequestMapping(value = "delete/{id}")
    public Result delete(@Login UserInfo userInfo, @PathVariable("id") String id) {
        return statusTypeService.delete(userInfo, id);
    }
}
