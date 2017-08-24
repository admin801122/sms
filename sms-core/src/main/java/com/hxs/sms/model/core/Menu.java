package com.hxs.sms.model.core;

import com.hxs.sms.model.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： Menu
 * @类描述：系统菜单实体
 * @创建人： huxinsheng
 * @创建时间： 2017-03-31 17:31
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Data
public class Menu extends BaseModel {
    /**
     * 菜单主键Id
     */
    private String id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 父菜单名称
     */
    private String parentName;
    /**
     * 菜单地址
     */
    private String url;
    /**
     * 菜单级别
     */
    private Integer level;
    /**
     * 菜单顺序
     */
    private Integer seq;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 父菜单ID
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
     * 子菜单列表
     */
    private List<Menu> subMenus;
    /**
     * 菜单拥有权限列表
     */
    private List<Permission> permissions;
    /**
     * 是否选中
     */
    private boolean checked;
}
