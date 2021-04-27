package com.lab2.worker;

import com.lab2.io.ReadFromFileImpl;
import com.lab2.model.sentence.AbstractSentence;
import com.lab2.model.sentence.Sentence;
import com.lab2.model.word.AbstractWord;
import com.lab2.model.word.Word;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.lab2.printable.Printable.printInfo;
import static com.lab2.printable.Printable.printList;

/**
 * Class implements the interface Worker.
 * <p>
 * Date: apr 25, 2021
 *
 * @author Symaniuk Victoryia
 */
public class WorkerImpl implements Worker {
    @Override
    public String readFile() {
        String text = new ReadFromFileImpl().readFile(FILE);
        printInfo("\nTEXT: {}", text);
        return text;
    }

    @Override
    public List<String> divideOnSentences(String text) {
        AbstractSentence sentences = new Sentence();
        return sentences.divideBySentences(text);
    }

    @Override
    public void divideAndCountWords(List<String> listSentence) {
        Map<String, Long> map = null;
        AbstractWord words = new Word();
        for (int i = 0; i < listSentence.size(); i++) {
            List<String> listWords = words.divideByWords(listSentence.get(i));
            map = countWords(listSentence, listWords);
        }
        Long maxWords;
        if (map != null) {
            maxWords = getMaxWords(map);
            filterMap(map, maxWords);
        }
    }

    /**
     * Method for printing map.
     *
     * @param map      Map map for print
     * @param maxWords filter for map
     */
    private void filterMap(Map<String, Long> map, Long maxWords) {
        Map<String, Long> resultMap = map.entrySet().stream()
                .filter(e -> e.getValue().equals(maxWords))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        printInfo("\nRESULT: \nword \"{}\" appears {} times in sentence",
                resultMap.keySet().toString().replaceAll(REGEX, ""),
                resultMap.values().toString().replaceAll(REGEX, ""));
    }

    @Override
    public Long getMaxWords(Map<String, Long> map) {
        return map.values().stream().max(Long::compareTo).orElse(null);
    }

    @Override
    public Map<String, Long> countWords(List<String> listSentence, List<String> listWords) {
        Map<String, Long> map = new LinkedHashMap<>();
        for (String word : listWords) {
            long count = listSentence.stream()
                    .filter(w -> (w.toLowerCase() + " ")
                            .contains(word.toLowerCase())).count();
            map.put(word.toLowerCase(), count);
        }
        return map;
    }

    @Override
    public void run() {
        String text = readFile();
        List<String> listSentences = divideOnSentences(text);
        printInfo("SENTENCES:");
        printList(listSentences);
        divideAndCountWords(listSentences);
    }
}
