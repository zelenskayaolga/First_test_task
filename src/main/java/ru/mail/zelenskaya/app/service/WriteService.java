package ru.mail.zelenskaya.app.service;

import java.util.List;

public interface WriteService {
    void writeToFile(List<String> listOfLines, String fileToWrite);
}
