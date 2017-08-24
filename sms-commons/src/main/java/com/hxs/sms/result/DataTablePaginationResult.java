package com.hxs.sms.result;

import com.hxs.sms.form.DataTablePaginationForm;

import java.util.List;

public class DataTablePaginationResult<T> extends DataTableResult<T> {

    private long iTotalRecords;

    public DataTablePaginationResult(long count, List<T> list, DataTablePaginationForm form) {
        super(count, list);
        this.iTotalRecords = count;
    }

    public long getiTotalRecords() {
        return iTotalRecords;
    }
}
