package com.hxs.sms.action.core;

import com.hxs.sms.UserInfo;
import com.hxs.sms.web.ViewNames;
import com.hxs.sms.web.annotation.Login;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexAction extends ViewAction {

    @Login
    @RequestMapping
    public ModelAndView index(@Login UserInfo userInfo) {
        ModelAndView mv = createModelAndView(userInfo, ViewNames.INDEX_VIEW);
        return mv;
    }
    @RequestMapping("404")
    public ModelAndView error404(@Login UserInfo userInfo) {
        ModelAndView mv = createModelAndView(userInfo, ViewNames.ERROR_404);
        return mv;
    }
    @RequestMapping("print")
    public String index() {
        return "print";
    }

    @RequestMapping("register")
    public String register() {
        return "register";
    }

    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    @RequestMapping("login")
    public ModelAndView login() {
        return new ModelAndView(ViewNames.LOGIN_VIEW);
    }
}
