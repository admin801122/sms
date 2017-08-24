package com.hxs.sms.model.core;

import com.hxs.sms.model.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： Role
 * @类描述： 角色数据实体对象
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 15:55
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Data
public class Role extends BaseModel {
    /**
     * 主键id
     */
    private String id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色描述
     */
    private String desc;
    /**
     * 角色标识
     */
    private String sign;
    /**
     * 角色拥有菜单列表
     */
    private List<Menu> menus;
    /**
     * 是否选中
     */
    private boolean checked;
}
