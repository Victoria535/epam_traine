package com.lab2.model.sentence;

import java.util.List;

/**
 * Abstract sentence.
 * <p>
 * Date: apr 25, 2021
 *
 * @author Symaniuk Victoryia
 */
public abstract class AbstractSentence {
    /**
     * Regular expression for sentence.
     */
    protected static final String REGEX_SENTENCE = "([A-Z][a-z].*?[.:!?](?=$| [A-Z]))";

    private List<String> listSentence;

    /**
     * @return field listSentence
     */
    public List<String> getListSentence() {
        return listSentence;
    }

    /**
     * Method for setting field listSentence.
     *
     * @param listSentence List list of sentences
     */
    public void setListSentence(List<String> listSentence) {
        this.listSentence = listSentence;
    }

    /**
     * Method divided paragraph by sentences.
     *
     * @param text text reading from file
     * @return List list of sentences
     */
    public abstract List<String> divideBySentences(String text);
}
