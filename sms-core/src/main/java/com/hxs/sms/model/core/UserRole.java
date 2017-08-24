package com.hxs.sms.model.core;

import com.hxs.sms.model.BaseModel;
import lombok.Data;

/**
 * @项目名称： hxs-sms
 * @类名称： UserRole
 * @类描述： 用户角色数据实体
 * @创建人： huxinsheng
 * @创建时间： 2017-04-08 15:30
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Data
public class UserRole extends BaseModel {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 角色id
     */
    private String roleId;
}
