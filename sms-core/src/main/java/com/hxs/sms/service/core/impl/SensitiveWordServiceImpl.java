package com.hxs.sms.service.core.impl;

import com.hxs.sms.UserInfo;
import com.hxs.sms.bean.core.SensitiveWordProvider;
import com.hxs.sms.dao.core.SensitiveWordDAO;
import com.hxs.sms.form.core.SensitiveWordAddForm;
import com.hxs.sms.form.core.SensitiveWordDeleteForm;
import com.hxs.sms.form.core.SensitiveWordQueryForm;
import com.hxs.sms.model.core.SensitiveWord;
import com.hxs.sms.result.PaginationResult;
import com.hxs.sms.result.QueryResult;
import com.hxs.sms.result.Result;
import com.hxs.sms.service.core.SensitiveWordService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("Core.SensitiveWordServiceImpl")
public class SensitiveWordServiceImpl implements SensitiveWordService{

	@Resource
	SensitiveWordDAO sensitiveWordDAO;
	
	static Log logger = LogFactory.getLog(SensitiveWordServiceImpl.class);
	
	public QueryResult<SensitiveWord> query(UserInfo userInfo,
			SensitiveWordQueryForm form) {
		long count = sensitiveWordDAO.count(form);
		List<SensitiveWord> list = sensitiveWordDAO.query(form);
		return new PaginationResult<SensitiveWord>(count,list,form);
	}
	@Transactional
	public Result add(UserInfo userInfo, SensitiveWordAddForm form) {
		if(form == null||form.getWord()==""){
			return Result.error("敏感词不能为空");
		}
		//数据按空格或等号切成数组
		String[] lines = form.getWord().split("\n");
		for (String line : lines) {
			String[] array = line.trim().split("=",2);
			String mode = "";
			String word = array[0];
			if(array.length  == 2){
				mode = array[1];
			}
			SensitiveWord sw = new SensitiveWord();
			sw.setWord(word);
			sw.setReplaceMode(mode);
			sensitiveWordDAO.delete(sw);
			sensitiveWordDAO.add(sw);
		}
		SensitiveWordProvider.setChanged();
		return Result.ok();
	}
	
	@Transactional
	public Result delete(UserInfo userInfo, SensitiveWordDeleteForm form) {
		SensitiveWord sensitiveWord = new SensitiveWord();
		BeanUtils.copyProperties(form,sensitiveWord);
		sensitiveWordDAO.delete(sensitiveWord);
		SensitiveWordProvider.setChanged();
		return Result.ok(sensitiveWord);
	}
	
	public List<SensitiveWord> getAll() {
		return sensitiveWordDAO.getAll();
	}

	
	
}
