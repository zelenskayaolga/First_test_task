package ru.mail.zelenskaya.app.service.impl;

import ru.mail.zelenskaya.app.service.GetAllPathsService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GetAllPathsServiceImpl implements GetAllPathsService {
    private static GetAllPathsService instance;

    private GetAllPathsServiceImpl() {
    }

    public static GetAllPathsService getInstance() {
        if (instance == null) {
            instance = new GetAllPathsServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Path> getPathsOfFilesAllTypes(String directory) {
        try {
            return Files.walk(Paths.get(directory))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }
}
