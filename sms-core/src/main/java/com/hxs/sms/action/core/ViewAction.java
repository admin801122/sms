package com.hxs.sms.action.core;

import com.hxs.sms.UserInfo;
import org.springframework.web.servlet.ModelAndView;

public class ViewAction {

    protected ModelAndView createModelAndView(UserInfo userInfo, String viewName) {
        return new ModelAndView(viewName);
    }

}
