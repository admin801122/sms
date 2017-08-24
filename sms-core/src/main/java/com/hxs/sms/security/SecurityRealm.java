package com.hxs.sms.security;

import com.hxs.sms.model.core.Role;
import com.hxs.sms.service.core.RoleMenuPermissionService;
import com.hxs.sms.service.core.UserService;
import com.hxs.sms.form.core.LoginForm;
import com.hxs.sms.model.core.User;
import com.hxs.sms.result.Result;
import lombok.extern.log4j.Log4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户身份验证,授权 Realm 组件
 *
 * @author HuXinsheng
 * @since 2016-03-15 10:43
 **/
@Component("securityRealm")
@Log4j
public class SecurityRealm extends AuthorizingRealm {

    private static final String OR_OPERATOR = " or ";

    private static final String AND_OPERATOR = " and ";

    private static final String NOT_OPERATOR = "not ";

    @Resource
    UserService userService;

    @Resource
    RoleMenuPermissionService roleMenuPermissionService;

    /**
     * 权限检查
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        DefaultAuthorizationInfo authorizationInfo = new DefaultAuthorizationInfo();
        String loginId = String.valueOf(principals.getPrimaryPrincipal());
        try {
            final User user = userService.findByLoginId(loginId);
            if (null != user) {
                final List<Role> roleList = user.getRoles();
                if (CollectionUtils.isNotEmpty(roleList)) {
                    List<String> roles = new ArrayList<String>();
                    Set<String> roleCodes = new HashSet<String>();
                    for (Role role : roleList) {
                        //添加角色验证
                        roles.add(role.getSign());
                        roleCodes.add(role.getId());
                        //添加权限验证
                    }
                    List<String> list = new ArrayList<String>(roleCodes);
                    List<String> permissionSignList = roleMenuPermissionService.findByRoleIds(list);
                    authorizationInfo.addStringPermissions(permissionSignList);
                    authorizationInfo.addRoles(roles);
                }
            }
            return authorizationInfo;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /*CasToken casToken = (CasToken) token;

        if (token == null) {
            return null;
        }

        String ticket = (String) casToken.getCredentials();
        if (!StringUtils.hasText(ticket)) {
            return null;
        }
        TicketValidator ticketValidator = ensureTicketValidator();*/
        try {

            /*Assertion casAssertion = ticketValidator.validate(ticket, getCasService());
            // get principal, user id and attributes
            AttributePrincipal casPrincipal = casAssertion.getPrincipal();
            String username = casPrincipal.getName();


            Map<String, Object> attributes = casPrincipal.getAttributes();
            // refresh authentication token (user id + remember me)
            casToken.setUserId(username);
            String rememberMeAttributeName = getRememberMeAttributeName();
            String rememberMeStringValue = (String) attributes.get(rememberMeAttributeName);
            boolean isRemembered = rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
            if (isRemembered) {
                casToken.setRememberMe(true);
            }*/

            String loginId = String.valueOf(token.getPrincipal());
            String password = new String((char[]) token.getCredentials());
            // 通过数据库进行验证
            final User authentication = userService.authentication(new LoginForm(loginId, password));
            if (authentication == null) {
                throw new AuthenticationException(String.valueOf(Result.LOGIN_PWD_ERROR));
            } else if (authentication.isDisabled()) {
                throw new AuthenticationException(String.valueOf(Result.LOGIN_DISABLED_ERROR));
            }
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginId, password, getName());
            return authenticationInfo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 支持or and not 关键词  不支持and or混用
     *
     * @param principals
     * @param permission
     * @return
     */
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        if (permission.contains(OR_OPERATOR)) {
            String[] permissions = permission.split(OR_OPERATOR);
            for (String orPermission : permissions) {
                if (isPermittedWithNotOperator(principals, orPermission)) {
                    return true;
                }
            }
            return false;
        } else if (permission.contains(AND_OPERATOR)) {
            String[] permissions = permission.split(AND_OPERATOR);
            for (String orPermission : permissions) {
                if (!isPermittedWithNotOperator(principals, orPermission)) {
                    return false;
                }
            }
            return true;
        } else {
            return isPermittedWithNotOperator(principals, permission);
        }
    }

    private boolean isPermittedWithNotOperator(PrincipalCollection principals, String permission) {
        if (permission.startsWith(NOT_OPERATOR)) {
            return !super.isPermitted(principals, permission.substring(NOT_OPERATOR.length()));
        } else {
            return super.isPermitted(principals, permission);
        }
    }
}
