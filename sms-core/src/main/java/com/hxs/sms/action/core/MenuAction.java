package com.hxs.sms.action.core;

import com.hxs.sms.form.core.MenuUpdateForm;
import com.hxs.sms.service.core.MenuService;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.MenuAddForm;
import com.hxs.sms.form.core.MenuQueryForm;
import com.hxs.sms.model.core.Menu;
import com.hxs.sms.result.Result;
import com.hxs.sms.web.ViewNames;
import com.hxs.sms.web.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： MenuAction
 * @类描述： 系统菜单管理控制器
 * @创建人： huxinsheng
 * @创建时间： 2017-04-06 09:00
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Controller
@RequestMapping("/core/menu")
public class MenuAction extends ViewAction {

    @Resource(name = "dw.menuService")
    MenuService menuService;

    @RequestMapping
    public ModelAndView index(@Login UserInfo userInfo) {
        ModelAndView mv = createModelAndView(userInfo, ViewNames.MENU_VIEW);
        return mv;
    }

    @RequestMapping(value = "query")
    @ResponseBody
    public List<Menu> query(MenuQueryForm form) {
        return menuService.query(form);
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public Result add(@Login UserInfo userInfo, MenuAddForm form) {
        return menuService.add(userInfo, form);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public Result update(@Login UserInfo userInfo, MenuUpdateForm form) {
        return menuService.update(userInfo, form);
    }

    @RequestMapping(value = "delete/{id}")
    @ResponseBody
    public Result delete(@Login UserInfo userInfo, @PathVariable("id") String id) {
        return menuService.delete(userInfo, id);
    }
}
