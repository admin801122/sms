package com.hxs.sms.model.core;

import lombok.Data;

/**
 * @项目名称： portal
 * @类名称： TreeJson
 * @类描述：树JSON实体
 * @创建人： HuXinsheng
 * @创建时间： 2017/3/5 15:18
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Data
public class TreeJson<T> {
    private String id;
    /**
     * 级别
     */
    private Integer level;
    /**
     * 父ID
     */
    private String parent;
    /**
     * 是否叶子节点
     */
    private boolean leaf;
    /**
     * 是否展开
     */
    private boolean expanded;
    /**
     * 节点图标
     */
    private String icon;
    /**
     * 数据对象
     */
    private T entity;
}
