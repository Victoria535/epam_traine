package com.lab2.model.word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class implements the class AbstractWord.
 * <p>
 * Date: apr 25, 2021
 *
 * @author Symaniuk Victoryia
 */
public class Word extends AbstractWord {
    @Override
    public List<String> divideByWords(String sentence) {
        setListWord(new ArrayList<>());

        Pattern patternWord = Pattern.compile(WORD_REGEX);
        Pattern patternMail = Pattern.compile(WORD_MAIL_REGEX);
        Pattern patternPhone = Pattern.compile(WORD_PHONE_REGEX);

        findWord(patternMail.matcher(sentence));
        findWord(patternPhone.matcher(sentence));
        findWord(patternWord.matcher(sentence));
        return getListWord();
    }

    /**
     * Method for find words in the text by the specified regular expression.
     *
     * @param matcher regular expression
     */
    private void findWord(Matcher matcher) {
        String word;
        while (matcher.find()) {
            word = matcher.group();
            getListWord().add(word + " ");
        }
    }
}
