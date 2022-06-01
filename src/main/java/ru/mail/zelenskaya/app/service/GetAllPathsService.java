package ru.mail.zelenskaya.app.service;

import java.nio.file.Path;
import java.util.List;

public interface GetAllPathsService {
    List<Path> getPathsOfFilesAllTypes(String directory);
}
