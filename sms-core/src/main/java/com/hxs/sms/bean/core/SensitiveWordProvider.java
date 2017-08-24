package com.hxs.sms.bean.core;

import com.hxs.sms.model.core.SensitiveWord;
import com.hxs.sms.service.core.SensitiveWordService;
import com.hxs.sms.util.word.filter.Word;
import com.hxs.sms.util.word.filter.WordProvider;
import com.hxs.sms.web.HttpContext;

import java.util.ArrayList;
import java.util.List;

public class SensitiveWordProvider implements WordProvider {

    private static List<Word> WORDS;

    public List<Word> getWords() {
        if (WORDS != null && WORDS.size() > 0) {
            return WORDS;
        }
        synchronized (this) {
            if (WORDS != null && WORDS.size() > 0) {
                return WORDS;
            }
            SensitiveWordService sensitiveWordService;
            sensitiveWordService = HttpContext.getBean(SensitiveWordService.class);
            List<SensitiveWord> swList = sensitiveWordService.getAll();
            List<Word> words = new ArrayList<Word>(swList.size());
            for (SensitiveWord sw : swList) {
                String word = sw.getWord();
                String mode = sw.getReplaceMode();
                words.add(new Word(word, mode));
            }
            WORDS = words;
        }
        return WORDS;
    }

    public static void setChanged() {
        WORDS = null;
    }

}
