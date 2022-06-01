package ru.mail.zelenskaya.app.service;

import java.nio.file.Path;
import java.util.List;

public interface ReadService {
    List<String> readFiles(List<Path> pathsToTxtFiles);
}
