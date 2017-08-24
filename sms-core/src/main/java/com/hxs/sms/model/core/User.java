package com.hxs.sms.model.core;

import com.hxs.sms.model.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： User
 * @类描述： 系统用户数据实体
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 10:54
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Data
public class User extends BaseModel {
    /**
     * 主键id
     */
    private String id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 登录id
     */
    private String loginId;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 是否禁用
     */
    private boolean disabled;
    /**
     * 用户角色列表
     */
    private List<Role> roles;
}
