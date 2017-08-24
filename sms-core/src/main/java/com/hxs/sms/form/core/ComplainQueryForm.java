package com.hxs.sms.form.core;

import com.hxs.sms.form.PaginationForm;

public class ComplainQueryForm extends PaginationForm{
	
	private String categoryId;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
}
