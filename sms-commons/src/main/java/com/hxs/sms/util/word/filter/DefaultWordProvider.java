package com.hxs.sms.util.word.filter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.hxs.sms.result.Result;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.LogFactory;

public class DefaultWordProvider implements WordProvider{

	private static List<Word> words;
	
	static{
		words = new ArrayList<Word>();
		try {
			InputStream input = DefaultWordProvider.class.getResourceAsStream("/sensitive_words.txt");
			List<?> lines = IOUtils.readLines(input);
			for (Object obj : lines) {
				String line = obj.toString().trim();
				String[] array = line.split("=",2);
				if(array.length == 2){
					String word = array[0];
					String mode = array[1];
					words.add(new Word(word, mode));
				}
			}
		} catch (Exception e) {
			LogFactory.getLog(Result.class).error(null , e);
		}
	} 
	
	public List<Word> getWords() {
		return words;
	}

}
