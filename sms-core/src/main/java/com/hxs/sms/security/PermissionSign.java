package com.hxs.sms.security;

/**
 * 权限标识配置类, <br>
 * 与 permission 权限表 中的 permission_sign 字段 相对应 <br>
 * 使用:
 * <p/>
 * <pre>
 * &#064;RequiresPermissions(value = PermissionConfig.USER_CREATE)
 * public String create() {
 *     return &quot;拥有user:create权限,能访问&quot;;
 * }
 * </pre>
 *
 * @author HuXinsheng
 * @since 2016-03-15 10:43
 **/
public class PermissionSign {

    /**
     * 系统访问 标识
     */
    public static final String SYSTEM_ACCESS = "system:access";

    /**
     * 系统管理主菜单权限 标识
     */
    public static final String SYSTEM_MANAGE = "systemmanage:*";

    /**
     * 系统菜单管理菜单权限 标识
     */
    public static final String MENU_MANAGE = "menumanage:*";

    /**
     * 角色管理菜单权限 标识
     */
    public static final String ROLE_MANAGE = "rolemanage:*";

}
