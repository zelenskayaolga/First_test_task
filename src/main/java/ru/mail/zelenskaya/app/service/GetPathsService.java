package ru.mail.zelenskaya.app.service;

import java.nio.file.Path;
import java.util.List;

public interface GetPathsService {
    List<Path> getPathsOfFilesOneType(List<Path> pathsToAllFiles,
                                      String typeOfFile);
}
