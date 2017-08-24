package com.hxs.sms.action.core;

import com.hxs.sms.form.core.UserAddForm;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.LoginForm;
import com.hxs.sms.form.core.UserQueryForm;
import com.hxs.sms.form.core.UserUpdateForm;
import com.hxs.sms.model.core.User;
import com.hxs.sms.result.DataTableResult;
import com.hxs.sms.result.Result;
import com.hxs.sms.service.core.UserService;
import com.hxs.sms.web.HttpContext;
import com.hxs.sms.web.HttpSession;
import com.hxs.sms.web.ViewNames;
import com.hxs.sms.web.annotation.Login;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/core/user")
public class UserAction extends ViewAction {

    private final static int misLimitTimes = 5;
    private final static int lockLimitMinutes = 10;

    @Resource
    private UserService userService;


    @RequestMapping
    public ModelAndView index(@Login UserInfo userInfo) {
        ModelAndView mv = createModelAndView(userInfo, ViewNames.USER_VIEW);
        return mv;
    }

    @ResponseBody
    @RequestMapping("login")
    public Result login(LoginForm form) {
        HttpSession session = HttpContext.getSession();
        String userSessionKey = HttpSession.USER_SESSION_KEY;
        String misSessionKey = userSessionKey + "_mistimes_" + form.getLoginId();
        Integer misTimes = (Integer) session.getAttribute(misSessionKey);
        if (misTimes == null)
            misTimes = 0;
        String lockSessionKey = userSessionKey + "_locktime";
        if (misTimes >= misLimitTimes) {
            long nowTime = new Date().getTime();
            Long lockTime = (Long) session.getAttribute(lockSessionKey);
            if (lockTime == null) lockTime = 0L;
            long lockedMinutes = (nowTime - lockTime) / 1000 / 60;
            long diff = lockLimitMinutes - lockedMinutes;
            if (diff > 0) {
                return Result.error(Result.LOGIN_TOO_MANY_ERROR, diff);
            }
        }
        Subject subject = SecurityUtils.getSubject();
        // 已登陆则 跳到首页
        if (subject.isAuthenticated()) {
            return Result.ok();
        }
        try {
            // 身份验证
            subject.login(new UsernamePasswordToken(form.getLoginId(), form.getPassword()));
        } catch (AuthenticationException e) {
            // 身份验证失败
            return Result.error(Integer.parseInt(e.getMessage()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // 身份验证失败
            return Result.error("登录发生异常【" + e.getMessage() + "】");
        }
        Result result = userService.login(form);
        if (result.isOK()) {
            User user = (User) result.getValue();
            String userId = user.getId();
            String name = user.getName();
            String loginId = form.getLoginId();
            UserInfo userInfo;
            userInfo = new UserInfo(userId, name, loginId);
            session.setAttribute(userSessionKey, userInfo);//用户信息
            session.setAttribute(misSessionKey, 0);
            result.setResult(user);
        } else if (result.getErrcode() == Result.LOGIN_PWD_ERROR) {
            misTimes++;
            session.setAttribute(misSessionKey, misTimes);
            if (misTimes >= misLimitTimes) {
                long nowTime = new Date().getTime();
                session.setAttribute(lockSessionKey, nowTime);
            } else {
                session.setAttribute(lockSessionKey, null);
            }
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("query")
    public DataTableResult<User> query(UserQueryForm form) {
        return userService.query(form);
    }

    @ResponseBody
    @RequestMapping("add")
    public Result query(@Login UserInfo userInfo, UserAddForm form) {
        return userService.add(userInfo, form);
    }

    @ResponseBody
    @RequestMapping("update")
    public Result query(@Login UserInfo userInfo, UserUpdateForm form) {
        return userService.update(userInfo, form);
    }

    @ResponseBody
    @RequestMapping(value = "delete/{id}")
    public Result delete(@Login UserInfo userInfo, @PathVariable("id") String id) {
        return userService.delete(userInfo, id);
    }
}
