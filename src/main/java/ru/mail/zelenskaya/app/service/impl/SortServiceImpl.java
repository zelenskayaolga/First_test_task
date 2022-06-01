package ru.mail.zelenskaya.app.service.impl;

import ru.mail.zelenskaya.app.service.SortService;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class SortServiceImpl implements SortService {
    private static SortService instance;

    private SortServiceImpl() {
    }

    public static SortService getInstance() {
        if (instance == null) {
            instance = new SortServiceImpl();
        }
        return instance;
    }

    @Override
    public void sortList(List<Path> pathsToTxtFiles) {
        pathsToTxtFiles.sort(Comparator.comparing(Path::getFileName));
    }
}
