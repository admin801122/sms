package com.hxs.sms.service.core.impl;

import com.hxs.sms.dao.core.BillDAO;
import com.hxs.sms.dao.core.BillSequnceDAO;
import com.hxs.sms.model.core.Bill;
import com.hxs.sms.model.core.BillSequnce;
import com.hxs.sms.model.core.BillSequnceKey;
import com.hxs.sms.service.core.BillService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class BillServiceImpl implements BillService {

    @Resource
    BillDAO billDAO;

    @Resource
    BillSequnceDAO billSequnceDAO;

    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    @Transactional
    public String newBillNo(BillSequnceKey key) {
        lock.writeLock().lock();// 加锁
        try {
            Bill bill = billDAO.getByCode(key.getCode());
            int seqVal = 1;
            BillSequnce sequnce = billSequnceDAO.getByKey(key);
            if (sequnce == null) {
                sequnce = new BillSequnce();
                sequnce.setCode(key.getCode());
                sequnce.setSequnce(seqVal);
                billSequnceDAO.add(sequnce);
            } else {
                seqVal = sequnce.getSequnce() + 1;
                sequnce.setSequnce(seqVal);
                billSequnceDAO.update(sequnce);
            }
            int num = bill.getNum();
            String prefix = bill.getPrefix();
            String dateFormat = bill.getDateFormat();
            if (dateFormat == null) dateFormat = "";
            if (prefix == null) prefix = "";
            StringBuilder buff = new StringBuilder();
            buff.append(prefix);
            buff.append(new SimpleDateFormat(dateFormat).format(new Date()));
            buff.append(StringUtils.leftPad(String.valueOf(seqVal), num, '0'));
            return buff.toString();
        } finally {
            lock.writeLock().unlock();// 解锁
        }
    }

}
