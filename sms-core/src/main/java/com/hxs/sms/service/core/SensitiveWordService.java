package com.hxs.sms.service.core;


import com.hxs.sms.form.core.SensitiveWordAddForm;
import com.hxs.sms.form.core.SensitiveWordDeleteForm;
import com.hxs.sms.form.core.SensitiveWordQueryForm;
import com.hxs.sms.model.core.SensitiveWord;
import com.hxs.sms.UserInfo;
import com.hxs.sms.result.QueryResult;
import com.hxs.sms.result.Result;

import java.util.List;


public interface SensitiveWordService {
	
	public QueryResult<SensitiveWord> query(UserInfo userInfo, SensitiveWordQueryForm form);

	public Result add(UserInfo userInfo, SensitiveWordAddForm form);
	
	public Result delete(UserInfo userInfo, SensitiveWordDeleteForm form);
	
	public List<SensitiveWord> getAll();


}
