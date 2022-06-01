package ru.mail.zelenskaya.app.service.impl;

import ru.mail.zelenskaya.app.service.ReadService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadServiceImpl implements ReadService {
    private static ReadService instance;

    private ReadServiceImpl() {
    }

    public static ReadService getInstance() {
        if (instance == null) {
            instance = new ReadServiceImpl();
        }
        return instance;
    }

    @Override
    public List<String> readFiles(List<Path> pathsToTxtFiles) {
        List<String> listOfLines = new ArrayList<>();
        for (Path pathToTxtFile : pathsToTxtFiles) {
            String fileName = String.valueOf(pathToTxtFile);
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String textFromFiles;
                while ((textFromFiles = br.readLine()) != null) {
                    listOfLines.add(textFromFiles);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        return listOfLines;
    }
}
