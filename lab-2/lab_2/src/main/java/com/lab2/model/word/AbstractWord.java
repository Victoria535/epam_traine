package com.lab2.model.word;

import java.util.List;

/**
 * Abstract word.
 * <p>
 * Date: apr 25, 2021
 *
 * @author Symaniuk Victoryia
 */
public abstract class AbstractWord {
    /**
     * Regular expression for word.
     */
    protected static final String WORD_REGEX = "\\w+";
    /**
     * Regular expression for mail.
     */
    protected static final String WORD_MAIL_REGEX =
            "([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}";
    /**
     * Regular expression for phone.
     */
    protected static final String WORD_PHONE_REGEX = "\\+\\d{3}\\(\\d{2}\\)\\d{3}-\\d{2}-\\d{2}\\b";

    private List<String> listWord;

    /**
     * @return field listWord
     */
    public List<String> getListWord() {
        return listWord;
    }

    /**
     * Method for setting field listWord.
     *
     * @param listWord List list of word
     */
    public void setListWord(List<String> listWord) {
        this.listWord = listWord;
    }

    /**
     * Method for divided sentence by words.
     *
     * @param sentence String sentence from text
     * @return List list of words
     */
    public abstract List<String> divideByWords(String sentence);
}
