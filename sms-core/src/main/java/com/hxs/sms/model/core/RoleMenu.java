package com.hxs.sms.model.core;

import com.hxs.sms.model.BaseModel;
import lombok.Data;

/**
 * @项目名称： hxs-sms
 * @类名称： RoleMenu
 * @类描述： 角色菜单数据实体
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 16:42
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Data
public class RoleMenu extends BaseModel{
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 菜单id
     */
    private String menuId;
}
