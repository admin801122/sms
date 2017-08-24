package com.hxs.sms.dao.core;

import com.hxs.sms.model.core.Menu;
import com.hxs.sms.form.core.MenuQueryForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @项目名称： hxs-sms
 * @类名称： MenuDAO
 * @类描述： 菜单数据持久接口
 * @创建人： huxinsheng
 * @创建时间： 2017-04-06 09:39
 * @联系方式： hxsysh@gmail.com
 * @修改备注：
 */
@Repository("dw.menuDAO")
public interface MenuDAO {
    List<Menu> findByEntity(MenuQueryForm form);

    List<Menu> findByParent(@Param("parent") String parent);

    Menu findByMenuName(@Param("id") String id, @Param("name") String name);

    int insert(Menu menu);

    int update(Menu form);

    String getNewCode();

    int deleteById(@Param("id") String id);

    void deleteByParent(@Param("id") String id);
}
