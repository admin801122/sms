package com.hxs.sms.dao.core;

import com.hxs.sms.model.core.Bill;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDAO {

    Bill getByCode(String code);
}
