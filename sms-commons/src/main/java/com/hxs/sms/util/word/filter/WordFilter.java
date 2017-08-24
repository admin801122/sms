package com.hxs.sms.util.word.filter;


public class WordFilter {

    private WordProvider provider;

    public WordFilter(WordProvider provider) {
        this.provider = provider;
    }

    public String replace(String input, Replacement replacement) {
        if (input == null) return null;
        int pos = 0;
        StringBuilder buff = new StringBuilder(input);
        if (null != provider.getWords() && provider.getWords().size() > 0) {
            while (true) {
                boolean isBeak = false;
                for (Word node : provider.getWords()) {
                    if (node.match(buff, pos)) {
                        int len = node.length();
                        //String word = buff.substring(pos, pos + len);
                        String replace = replacement.replace(node);
                        buff.delete(pos, pos + len);
                        buff.insert(pos, replace);
                        pos = pos + replace.length() - 1;
                    }
                    if (pos >= buff.length()) {
                        isBeak = true;
                        break;
                    }
                }
                if (isBeak) {
                    break;
                } else {
                    pos++;
                }
            }
        }
        return buff.toString();
    }


    public String replace(String input) {
        Replacement replacement = new Replacement() {
            public String replace(Word word) {
                return word.replace();
            }
        };
        return this.replace(input, replacement);
    }

    public static void main(String[] args) {
        WordFilter filter = new WordFilter(new TestWordProvider());
        String result = filter.replace("中国共产党的法轮功的法轮功的共产党强奸她");
        System.out.println(result);
    }
}
