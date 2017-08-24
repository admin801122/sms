package com.hxs.sms.web.support;

import com.hxs.sms.web.HttpContext;
import com.hxs.sms.web.HttpSession;
import com.hxs.sms.web.annotation.Captcha;
import com.hxs.sms.web.annotation.Login;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class SessionArgumentResolver implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Login.class)
                || parameter.hasParameterAnnotation(Captcha.class);
    }

    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        Object value = null;
        HttpSession session = HttpContext.getSession();
        if (parameter.hasParameterAnnotation(Login.class)) {
            value = session.getAttribute(HttpSession.USER_SESSION_KEY);
        } else if (parameter.hasParameterAnnotation(Captcha.class)) {
            value = session.getAttribute(HttpSession.CAPTCHA_SESSION_KEY);
        }
        return value;
    }

}
