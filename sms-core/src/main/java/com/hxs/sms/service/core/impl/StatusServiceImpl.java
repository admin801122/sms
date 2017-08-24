package com.hxs.sms.service.core.impl;

import com.hxs.sms.UserInfo;
import com.hxs.sms.dao.core.StatusDAO;
import com.hxs.sms.form.core.StatusAddForm;
import com.hxs.sms.form.core.StatusQueryForm;
import com.hxs.sms.form.core.StatusUpdateForm;
import com.hxs.sms.model.core.Status;
import com.hxs.sms.result.DataTablePaginationResult;
import com.hxs.sms.result.DataTableResult;
import com.hxs.sms.result.Result;
import com.hxs.sms.service.core.StatusService;
import com.hxs.sms.util.CommonUtils;
import com.hxs.sms.util.Const;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： StatusServiceImpl
 * @类描述： 状态信息管理接口实现类
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 13:56
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Service
public class StatusServiceImpl implements StatusService {

    @Resource
    private StatusDAO statusDAO;

    public DataTableResult<Status> query(StatusQueryForm form) {
        if (null != form) {
            long count = statusDAO.count(form);
            List<Status> list = statusDAO.query(form);
            return new DataTablePaginationResult<Status>(count, list, form);
        } else {
            return null;
        }
    }

    public List<Status> queryByType(String type) {
        return statusDAO.queryByType(type);
    }

    @Transactional
    public Result add(UserInfo userInfo, StatusAddForm form) {
        Status status = statusDAO.findExistsByCondition(null, form.getType(), form.getValue(), form.getName());
        if (null != status) {
            return Result.error(Result.EXISTS, "状态值已存在");
        }
        status = new Status();
        BeanUtils.copyProperties(form, status);
        CommonUtils.fillingValue(userInfo, status, Const.ADD);
        statusDAO.insert(status);
        return Result.ok();
    }

    @Transactional
    public Result update(UserInfo userInfo, StatusUpdateForm form) {
        Status status = statusDAO.findExistsByCondition(form.getId(), form.getType(), form.getValue(), form.getName());
        if (null != status) {
            return Result.error(Result.EXISTS, "状态值已存在");
        }
        status = new Status();
        BeanUtils.copyProperties(form, status);
        CommonUtils.fillingValue(userInfo, status, !Const.ADD);
        statusDAO.update(status);
        return Result.ok();
    }

    @Transactional
    public Result updateStatus(UserInfo userInfo, StatusUpdateForm form) {
        Status status = new Status();
        BeanUtils.copyProperties(form, status);
        statusDAO.updateStatus(status);
        return Result.ok();
    }
}
