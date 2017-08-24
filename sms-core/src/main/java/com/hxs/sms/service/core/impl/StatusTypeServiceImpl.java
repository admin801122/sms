package com.hxs.sms.service.core.impl;

import com.hxs.sms.UserInfo;
import com.hxs.sms.dao.core.StatusTypeDAO;
import com.hxs.sms.form.core.StatusTypeAddForm;
import com.hxs.sms.form.core.StatusTypeQueryForm;
import com.hxs.sms.form.core.StatusTypeUpdateForm;
import com.hxs.sms.model.core.StatusType;
import com.hxs.sms.result.DataTablePaginationResult;
import com.hxs.sms.result.DataTableResult;
import com.hxs.sms.result.Result;
import com.hxs.sms.service.core.StatusTypeService;
import com.hxs.sms.util.CommonUtils;
import com.hxs.sms.util.Const;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： StatusTypeServiceImpl
 * @类描述： 状态类型管理服务接口实现类
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 11:07
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Service
public class StatusTypeServiceImpl implements StatusTypeService {
    @Resource
    private StatusTypeDAO statusTypeDAO;

    public List<StatusType> queryAll(StatusTypeQueryForm form) {
        form.setPagination(false);
        return statusTypeDAO.query(form);
    }

    public DataTableResult<StatusType> query(StatusTypeQueryForm form) {
        if (null != form) {
            long count = statusTypeDAO.count(form);
            List<StatusType> list = statusTypeDAO.query(form);
            return new DataTablePaginationResult<StatusType>(count, list, form);
        } else {
            return null;
        }
    }

    public Result add(UserInfo userInfo, StatusTypeAddForm form) {
        StatusType statusType = statusTypeDAO.findByIdAndName(null, form.getName());
        if (null != statusType) {
            return Result.error(Result.EXISTS, "状态类型名称已存在");
        }
        statusType = new StatusType();
        BeanUtils.copyProperties(form, statusType);
        CommonUtils.fillingValue(userInfo, statusType, Const.ADD);
        statusTypeDAO.insert(statusType);
        return Result.ok();
    }

    public Result update(UserInfo userInfo, StatusTypeUpdateForm form) {
        StatusType statusType = statusTypeDAO.findByIdAndName(form.getId(), form.getName());
        if (null != statusType) {
            return Result.error(Result.EXISTS, "状态类型名称已存在");
        }
        statusType = new StatusType();
        BeanUtils.copyProperties(form, statusType);
        CommonUtils.fillingValue(userInfo, statusType, !Const.ADD);
        statusTypeDAO.update(statusType);
        return Result.ok();
    }

    public Result delete(UserInfo userInfo, String id) {
        statusTypeDAO.deleteById(id);
        return Result.ok();
    }
}
