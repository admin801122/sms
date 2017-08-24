package com.hxs.sms.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StrUtils {

	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}

	/*
	 * 去掉乱码
	 */
	public static String trimMessy(String str) {
		StringBuffer buff = new StringBuffer(str.length());
		for (int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			if (character >= 0x00 && character <= 0x7F) {
				buff.append(character);
			} else if (isChinese(character)) {
				buff.append(character);
			}
		}
		return buff.toString();
	}

	public static String bytes2Hex(byte[] bytes) {
		char[] res = new char[bytes.length * 2];
		final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'A', 'B', 'C', 'D', 'E', 'F' };
		for (int i = 0, j = 0; i < bytes.length; i++) {
			res[j++] = hexDigits[bytes[i] >>> 4 & 0x0f];
			res[j++] = hexDigits[bytes[i] & 0x0f];
		}
		return new String(res);
	}

	public static boolean isEmpty(String value) {
		return value == null || value.length() == 0;
	}

	public static String firstToUpperCase(String str) {
		if(isEmpty(str)){
			return str;
		}
		char[] array = str.toCharArray();
		array[0] = Character.toUpperCase(array[0]);
		return new String(array);
	}
	
	public static String firstToLowerCase(String str) {
		if(isEmpty(str)){
			return str;
		}
		char[] array = str.toCharArray();
		array[0] = Character.toLowerCase(array[0]);
		return new String(array);
	}

	public static boolean equals(String value1, String value2) {
		if(value1 == null){
			return value2 == null;
		}
		return value1.equals(value2);
	}

	public static String getNonceStr() {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		int maxPos = str.length();
		String noceStr = "";
		for (int i = 0; i < 32; i++) {
			noceStr += String.valueOf(str.charAt((int) Math.floor(Math.random() * maxPos)));
		}
		return noceStr;
	}
	/**
	 * 对象NULL处理
	 */
	public static String null2Blank(Object o) {
		String result = "";
		if (o == null || "null".equals(o)) {
			result = "";
		} else {
			if (o instanceof Integer ||o instanceof Double ) {
				result = String.valueOf(o);
			} else if (o instanceof Timestamp || o instanceof Date) {
				Timestamp ts = (Timestamp) o;
				DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				try {
					result = sdf.format(ts);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				result = (String) o;
			}
		}

		return result;
	}
}
