package com.hxs.sms.service.core;

import com.hxs.sms.UserInfo;
import com.hxs.sms.form.core.StatusAddForm;
import com.hxs.sms.form.core.StatusQueryForm;
import com.hxs.sms.form.core.StatusUpdateForm;
import com.hxs.sms.result.DataTableResult;
import com.hxs.sms.result.Result;

import java.util.List;

import com.hxs.sms.model.core.Status;


public interface StatusService {
    /**
     * 查询状态信息
     *
     * @param form 查询条件
     * @return 状态信息列表
     */
    DataTableResult<Status> query(StatusQueryForm form);

    /**
     * 根据状态类型查询状态列表
     *
     * @param type 状态类型
     * @return 状态信息列表
     */
    List<Status> queryByType(String type);

    /**
     * 添加状态信息
     *
     * @param userInfo 操作用户
     * @param form     状态信息
     * @return 操作结果
     */
    Result add(UserInfo userInfo, StatusAddForm form);

    /**
     * 更新状态信息
     *
     * @param userInfo 操作用户
     * @param form     状态信息
     * @return 操作结果
     */
    Result update(UserInfo userInfo, StatusUpdateForm form);

    /**
     * 更新数据状态
     *
     * @param userInfo 操作用户
     * @param form     状态信息
     * @return 操作结果
     */
    Result updateStatus(UserInfo userInfo, StatusUpdateForm form);
}
