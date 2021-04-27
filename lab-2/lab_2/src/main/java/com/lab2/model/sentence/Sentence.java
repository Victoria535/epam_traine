package com.lab2.model.sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class implements the class Sentence.
 * <p>
 * Date: apr 25, 2021
 *
 * @author Symaniuk Victoryia
 */
public class Sentence extends AbstractSentence {
    @Override
    public List<String> divideBySentences(String listParagraphs) {
        setListSentence(new ArrayList<>());
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = pattern.matcher(listParagraphs);
        String sentence;
        while (matcher.find()) {
            sentence = matcher.group();
            getListSentence().add(sentence);
        }
        return getListSentence();
    }
}
