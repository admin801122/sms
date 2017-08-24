package com.hxs.sms.dao.core;

import com.hxs.sms.form.core.SensitiveWordQueryForm;
import com.hxs.sms.model.core.SensitiveWord;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SensitiveWordDAO {

    List<SensitiveWord> query(SensitiveWordQueryForm form);

    void add(SensitiveWord word);

    void delete(SensitiveWord word);

    long count(SensitiveWordQueryForm form);

    List<SensitiveWord> getAll();
}
