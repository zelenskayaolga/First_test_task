package ru.mail.zelenskaya.app.service.impl;

import ru.mail.zelenskaya.app.service.GetPathsService;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GetPathsServiceImpl implements GetPathsService {
    private static GetPathsService instance;

    private GetPathsServiceImpl() {
    }

    public static GetPathsService getInstance() {
        if (instance == null) {
            instance = new GetPathsServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Path> getPathsOfFilesOneType(List<Path> pathsToAllFiles, String typeOfFile) {
        List<Path> pathsToTxtFiles = new ArrayList<>();
        for (Path pathsToFile : pathsToAllFiles) {
            Path fileName = pathsToFile.getFileName();
            if (String.valueOf(fileName).contains(typeOfFile)) {
                pathsToTxtFiles.add(pathsToFile);
            }
        }
        return pathsToTxtFiles;
    }
}
