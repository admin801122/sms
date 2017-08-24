package com.hxs.sms.model.core;

public class SensitiveWord {
	
	private String word;//敏感词
	
	private String replaceMode;//敏感词替换

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getReplaceMode() {
		return replaceMode;
	}

	public void setReplaceMode(String replaceMode) {
		this.replaceMode = replaceMode;
	}
	
	
}
