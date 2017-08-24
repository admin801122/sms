package com.hxs.sms.util.word.filter;

import java.util.ArrayList;
import java.util.List;

public class TestWordProvider implements WordProvider{

	public List<Word> getWords() {
		List<Word> words = new ArrayList<Word>();
		words.add(new Word("共产党","GCD"));
		words.add(new Word("法轮功","{BANNED}"));
		words.add(new Word("强奸","**"));
		return words;
	}

}
