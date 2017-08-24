package com.hxs.sms.model.core;

import com.hxs.sms.model.BaseModel;
import lombok.Data;

/**
 * @项目名称： hxs-sms
 * @类名称： Permission
 * @类描述： 权限数据实体对象
 * @创建人： huxinsheng
 * @创建时间： 2017-03-31 17:42
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Data
public class Permission extends BaseModel {
    /**
     * 权限Id
     */
    private String id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限标识
     */
    private String sign;
    /**
     * 权限描述
     */
    private String desc;
    /**
     * 是否选中
     */
    private boolean checked;
}
