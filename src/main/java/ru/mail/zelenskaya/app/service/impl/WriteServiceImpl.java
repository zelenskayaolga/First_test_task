package ru.mail.zelenskaya.app.service.impl;

import ru.mail.zelenskaya.app.service.WriteService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class WriteServiceImpl implements WriteService {
    private static WriteService instance;

    private WriteServiceImpl() {
    }

    public static WriteService getInstance() {
        if (instance == null) {
            instance = new WriteServiceImpl();
        }
        return instance;
    }

    @Override
    public void writeToFile(List<String> listOfLines, String fileToWrite) {
        try {
            Files.write(Paths.get(fileToWrite), listOfLines, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
