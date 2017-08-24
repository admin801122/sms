package com.hxs.sms.dao.core;

import com.hxs.sms.form.core.LoginForm;
import com.hxs.sms.form.core.UserQueryForm;
import com.hxs.sms.model.core.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： UserDAO
 * @类描述： 用户数据持久接口
 * @创建人： huxinsheng
 * @创建时间： 2017-04-05 11:08
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Repository
public interface UserDAO {
    User findByLoginId(String loginId);

    long count(UserQueryForm form);

    List<User> query(UserQueryForm form);

    void insert(User user);

    void update(User user);

    void deleteById(String id);

    User authentication(LoginForm loginForm);
}
