package com.lab2.worker;

import java.util.List;
import java.util.Map;

/**
 * Worker.
 * <p>
 * Date: apr 25, 2021
 *
 * @author Symaniuk Victoryia
 */
public interface Worker {
    /**
     * Regular expression for square brackets.
     */
    String REGEX = "((^\\[)|(\\]$))";
    /**
     * Constant variable for name file..
     */
    String FILE = "text.txt";

    /**
     * This method read file.
     *
     * @return text from file
     */
    String readFile();

    /**
     * This method divided paragraph on sentences.
     *
     * @param listParagraphs list of paragraphs
     * @return List list of sentence
     */
    List<String> divideOnSentences(String listParagraphs);

    /**
     * This method divided sentence on words and count them.
     *
     * @param listSentence List<String> list sentences
     */
    void divideAndCountWords(List<String> listSentence);

    /**
     * This method counts the number of identical words in sentences.
     *
     * @param listSentence List<String> list of sentences
     * @param listWords    List<String> list of words
     * @return Map<String, Long>
     */
    Map<String, Long> countWords(List<String> listSentence, List<String> listWords);

    /**
     * Method get max number of identical words in sentences.
     *
     * @param map Map<String, Long>
     * @return max words in sentences
     */
    Long getMaxWords(Map<String, Long> map);

    /**
     * Method for run program.
     */
    void run();
}
