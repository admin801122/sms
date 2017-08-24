package com.hxs.sms.web.support;

import com.hxs.sms.result.Result;
import com.hxs.sms.web.HttpContext;
import com.hxs.sms.web.HttpSession;
import com.hxs.sms.web.annotation.Login;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            boolean requireLogin;
            HandlerMethod method = (HandlerMethod) handler;
            requireLogin = method.getBeanType().getAnnotation(Login.class) != null;
            if (!requireLogin) {
                requireLogin = method.getMethodAnnotation(Login.class) != null;
            }
            if (!requireLogin) {
                MethodParameter[] parameters = method.getMethodParameters();
                for (MethodParameter param : parameters) {
                    if (param.hasParameterAnnotation(Login.class)) {
                        requireLogin = true;
                        break;
                    }
                }
            }
            if (requireLogin) {
                HttpSession session = HttpContext.getSession();
                Object userId = session.getAttribute(HttpSession.USER_SESSION_KEY);
                if (userId == null) {
                    ResponseBody responseBody = method.getMethodAnnotation(ResponseBody.class);
                    if (responseBody == null) {
                        response.sendRedirect("/login");
                    } else {
                        ObjectMapper mapper = new ObjectMapper();
                        Result result = Result.error(Result.LOGIN_REQUIRE);
                        response.setCharacterEncoding("utf-8");
                        mapper.writeValue(response.getWriter(), result);
                    }
                    return false;
                }
            }
        }
        return true;
    }


    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }


    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
