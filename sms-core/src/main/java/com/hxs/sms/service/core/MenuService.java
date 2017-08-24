package com.hxs.sms.service.core;

import com.hxs.sms.form.core.MenuUpdateForm;
import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.MenuAddForm;
import com.hxs.sms.form.core.MenuQueryForm;
import com.hxs.sms.model.core.Menu;
import com.hxs.sms.result.Result;

import java.util.List;


/**
 * @项目名称： hxs-sms
 * @类名称： MenuService
 * @类描述： 菜单管理服务
 * @创建人： huxinsheng
 * @创建时间： 2017-03-31 18:07
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
public interface MenuService {

    /**
     * 根据父ID查询对应子菜单列表
     *
     * @param form 查询条件
     * @return 父菜单下子菜单列表
     */
    List<Menu> query(MenuQueryForm form);

    /**
     * 根据多条件查询菜单列表
     *
     * @param form 查询条件
     * @return 菜单列表
     */
    List<Menu> findByEntity(MenuQueryForm form);

    /**
     * 添加菜单信息
     *
     * @param userInfo 操作用户
     * @param form     菜单信息
     * @return 操作结果
     */
    Result add(UserInfo userInfo, MenuAddForm form);

    /**
     * 更新菜单信息
     *
     * @param userInfo 操作用户
     * @param form     要更新的菜单信息
     * @return 操作结果
     */
    Result update(UserInfo userInfo, MenuUpdateForm form);

    /**
     * 删除菜单信息
     *
     * @param userInfo 操作用户
     * @param id       要删除的菜单ID
     * @return 操作结果
     */
    Result delete(UserInfo userInfo, String id);

}
