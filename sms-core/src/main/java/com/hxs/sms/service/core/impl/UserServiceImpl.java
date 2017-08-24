package com.hxs.sms.service.core.impl;

import com.hxs.sms.form.core.UserAddForm;
import com.hxs.sms.form.core.UserQueryForm;
import com.hxs.sms.service.core.UserRoleService;
import com.hxs.sms.service.core.UserService;
import com.hxs.sms.UserInfo;
import com.hxs.sms.dao.core.UserDAO;
import com.hxs.sms.form.core.LoginForm;
import com.hxs.sms.form.core.UserUpdateForm;
import com.hxs.sms.model.BaseModel;
import com.hxs.sms.model.core.User;
import com.hxs.sms.result.DataTablePaginationResult;
import com.hxs.sms.result.DataTableResult;
import com.hxs.sms.result.Result;
import com.hxs.sms.util.CommonUtils;
import com.hxs.sms.util.Const;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： UserServiceImpl
 * @类描述： 用户服务接口实现
 * @创建人： huxinsheng
 * @创建时间： 2017-04-05 11:04
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDAO userDAO;

    @Resource
    UserRoleService userRoleService;

    public Result login(LoginForm form) {
        String loginId = form.getLoginId();
        User user = userDAO.findByLoginId(loginId);
        return Result.ok(user);
    }

    public User authentication(LoginForm loginForm) {
        return userDAO.authentication(loginForm);
    }

    public User findByLoginId(String loginId) {
        return userDAO.findByLoginId(loginId);
    }

    public DataTableResult<User> query(UserQueryForm form) {
        if (null != form) {
            long count = userDAO.count(form);
            List<User> list = userDAO.query(form);
            return new DataTablePaginationResult<User>(count, list, form);
        } else {
            return null;
        }
    }

    @Transactional
    public Result add(UserInfo userInfo, UserAddForm form) {
        User user = userDAO.findByLoginId(form.getLoginId());
        if (null != user) {
            return Result.error(Result.EXISTS, "登录id已存在.");
        }
        user = new User();
        BeanUtils.copyProperties(form, user);
        user.setId(BaseModel.newId());
        CommonUtils.fillingValue(userInfo, user, Const.ADD);
        userDAO.insert(user);
        return Result.ok();
    }

    @Transactional
    public Result update(UserInfo userInfo, UserUpdateForm form) {
        User user = new User();
        BeanUtils.copyProperties(form, user);
        CommonUtils.fillingValue(userInfo, user, Const.ADD);
        userDAO.update(user);
        return Result.ok();
    }

    @Transactional
    public Result delete(UserInfo userInfo, String id) {
        //删除用户角色信息
        userRoleService.deleteByUserIdAndRoleId(id, null);
        //删除用户信息
        userDAO.deleteById(id);
        return Result.ok();
    }
}
