package com.hxs.sms.model.core;

import com.hxs.sms.model.BaseModel;
import lombok.Data;

/**
 * @项目名称： hxs-sms
 * @类名称： MenuPermission
 * @类描述： 菜单权限实体
 * @创建人： huxinsheng
 * @创建时间： 2017-04-07 09:00
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Data
public class MenuPermission extends BaseModel {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 菜单id
     */
    private String menuId;
    /**
     * 权限id
     */
    private String permissionId;
}
