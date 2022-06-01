package ru.mail.zelenskaya.app.service;

import java.nio.file.Path;
import java.util.List;

public interface SortService {
    void sortList(List<Path> pathsToTxtFiles);
}
