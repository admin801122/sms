package com.hxs.sms.form;

public class DataTablePaginationForm extends QueryForm {

    private int iDisplayStart;

    private int iDisplayLength;

    public DataTablePaginationForm() {
        isPagination = true;
    }

    public int getiDisplayStart() {
        return iDisplayStart;
    }

    public void setiDisplayStart(int iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }

    public int getiDisplayLength() {
        return iDisplayLength;
    }

    public void setiDisplayLength(int iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
    }
}
