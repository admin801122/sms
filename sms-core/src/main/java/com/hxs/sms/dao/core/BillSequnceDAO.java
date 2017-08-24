package com.hxs.sms.dao.core;

import com.hxs.sms.model.core.BillSequnce;
import com.hxs.sms.model.core.BillSequnceKey;
import org.springframework.stereotype.Repository;

@Repository
public interface BillSequnceDAO {

    BillSequnce getByKey(BillSequnceKey key);

    void add(BillSequnce sequnce);

    void update(BillSequnce sequnce);
}
