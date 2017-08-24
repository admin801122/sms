package com.hxs.sms.util.word.filter;

/**
 * 过滤词
 * @author kingsy
 *
 */
public class Word {
	
	private char[] chars;
	
	private String replaceMode;

	public Word(String word , String mode) {
		this.chars = word.toCharArray();
		this.replaceMode = mode;
	}

	public boolean match(StringBuilder input, int pos) {
		int charsCount = chars.length;
		if (pos + charsCount > input.length()) {
			return false;
		}
		for (int i = 0; i < charsCount; i++) {
			char character = input.charAt(pos + i);
			if (chars[i] != character) {
				return false;
			}
		}
		return true;
	}

	public int length() {
		return chars.length;
	}
	
	public String replace(){
		if(this.replaceMode.equals("{BANNED}")){
			return "";
		}
		return this.replaceMode;
	}
}
