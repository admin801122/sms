package com.hxs.sms.result;

import java.util.List;

public class DataTableResult<T> {

    private List<T> rows;

    private long iTotalDisplayRecords;

    protected DataTableResult(long count, List<T> rows) {
        this.iTotalDisplayRecords = count;
        this.rows = rows;
    }

    public DataTableResult(List<T> rows) {
        this.iTotalDisplayRecords = rows.size();
        this.rows = rows;
    }

    public List<T> getRows() {
        return rows;
    }

    public long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }
}
