package com.hxs.sms.service.core;

import com.hxs.sms.form.core.StatusTypeAddForm;
import com.hxs.sms.form.core.StatusTypeQueryForm;
import com.hxs.sms.form.core.StatusTypeUpdateForm;
import com.hxs.sms.UserInfo;
import com.hxs.sms.model.core.StatusType;
import com.hxs.sms.result.DataTableResult;
import com.hxs.sms.result.Result;

import java.util.List;

public interface StatusTypeService {

    /**
     * 查询所有状态类型
     *
     * @param form 查询条件
     * @return 状态类型列表
     */
    List<StatusType> queryAll(StatusTypeQueryForm form);

    /**
     * 查询状态类型
     *
     * @param form 查询条件
     * @return 状态类型列表
     */
    DataTableResult<StatusType> query(StatusTypeQueryForm form);

    /**
     * 添加状态类型
     *
     * @param userInfo   操作用户
     * @param statusType 状态类型数据
     * @return 操作结果
     */
    Result add(UserInfo userInfo, StatusTypeAddForm statusType);

    /**
     * 更新状态类型
     *
     * @param userInfo   操作用户
     * @param statusType 状态类型数据
     * @return 操作结果
     */
    Result update(UserInfo userInfo, StatusTypeUpdateForm statusType);

    /**
     * 删除状态类型
     *
     * @param userInfo 操作用户
     * @param id       状态类型id
     * @return 操作结果
     */
    Result delete(UserInfo userInfo, String id);

}
