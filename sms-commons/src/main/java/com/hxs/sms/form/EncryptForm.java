package com.hxs.sms.form;

import java.lang.reflect.Method;

import com.hxs.sms.util.StrUtils;
import org.apache.commons.codec.digest.DigestUtils;

public abstract class EncryptForm extends BaseForm{

	public abstract void encrypt();
	
	protected void encrypt(String fieldName) {
		try {
			String name = StrUtils.firstToUpperCase(fieldName);
			Method method = getClass().getMethod("get" + name);
			String value  = (String)method.invoke(this);
			if(!StrUtils.isEmpty(value)){
				value =  DigestUtils.sha1Hex(value);
			}
			method = getClass().getMethod("set" + name , String.class);
			method.invoke(this , value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
