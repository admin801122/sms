package com.hxs.sms.service.core;

import com.hxs.sms.form.core.UserAddForm;
import com.hxs.sms.form.core.UserQueryForm;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.LoginForm;
import com.hxs.sms.form.core.UserUpdateForm;
import com.hxs.sms.model.core.User;
import com.hxs.sms.result.DataTableResult;
import com.hxs.sms.result.Result;

/**
 * @项目名称： hxs-sms
 * @类名称： UserService
 * @类描述： 用户服务接口
 * @创建人： huxinsheng
 * @创建时间： 2017-04-05 11:04
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param form 登录form对象
     * @return 登录结果
     */
    Result login(LoginForm form);

    /**
     * 查询系统用户信息
     *
     * @param form 查询条件
     * @return 系统用户列表
     */
    DataTableResult<User> query(UserQueryForm form);

    /**
     * 添加用户信息
     *
     * @param userInfo 操作用户
     * @param form     用户信息
     * @return 操作结果
     */
    Result add(UserInfo userInfo, UserAddForm form);

    /**
     * 更新用户信息
     *
     * @param userInfo 操作用户
     * @param form     用户信息
     * @return 操作结果
     */
    Result update(UserInfo userInfo, UserUpdateForm form);

    /**
     * 删除用户信息
     *
     * @param userInfo 操作用户
     * @param id       用户id
     * @return 操作结果
     */
    Result delete(UserInfo userInfo, String id);

    /**
     * 根据登录id查询用户信息
     *
     * @param loginId 登录id
     * @return 用户信息
     */
    User findByLoginId(String loginId);

    /**
     * 用户验证
     *
     * @param loginForm 登录数据实体
     * @return 登录用户信息
     */
    User authentication(LoginForm loginForm);
}
