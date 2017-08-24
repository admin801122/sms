package com.hxs.sms.model.core;

import com.hxs.sms.model.BaseModel;
import lombok.Data;

/**
 * @项目名称： hxs-sms
 * @类名称： Status
 * @类描述： 状态信息数据实体
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 13:43
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Data
public class Status extends BaseModel {
    /**
     * 状态id
     */
    private Integer id;
    /**
     * 状态名称
     */
    private String name;
    /**
     * 状态值
     */
    private String value;
    /**
     * 状态类型
     */
    private Integer type;
    /**
     * 数据状态
     */
    private boolean status;
    /**
     * 状态描述
     */
    private String desc;

    /**
     * 状态类型实体
     */
    private StatusType statusType;
}
