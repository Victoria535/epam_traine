package com.lab2.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.lab2.printable.Printable.printWarning;

/**
 * Class implements the class ReadFromFile.
 * <p>
 * Date: apr 25, 2021
 *
 * @author Symaniuk Victoryia
 */
public class ReadFromFileImpl implements ReadFromFile {
    @Override
    public String readFile(String file) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException ex) {
            printWarning(ex.getMessage());
        }
        return stringBuilder.toString();
    }
}
