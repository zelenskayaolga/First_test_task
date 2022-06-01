package ru.mail.zelenskaya.app;

import ru.mail.zelenskaya.app.service.*;
import ru.mail.zelenskaya.app.service.impl.*;

import java.nio.file.Path;
import java.util.List;

import static ru.mail.zelenskaya.app.Constants.*;

public class Main {

    public static void main(String[] args) {
        GetAllPathsService getAllFilesService = GetAllPathsServiceImpl.getInstance();
        List<Path> pathsToAllFiles = getAllFilesService.getPathsOfFilesAllTypes(ROOT_FOLDER);

        GetPathsService getTxtFilesService = GetPathsServiceImpl.getInstance();
        List<Path> pathsToTxtFiles = getTxtFilesService.getPathsOfFilesOneType(pathsToAllFiles, TYPE_OF_FILE);

        SortService sortService = SortServiceImpl.getInstance();
        sortService.sortList(pathsToTxtFiles);

        ReadService readService = ReadServiceImpl.getInstance();
        List<String> listOfLines = readService.readFiles(pathsToTxtFiles);

        WriteService writeService = WriteServiceImpl.getInstance();
        writeService.writeToFile(listOfLines, FILE_TO_WRITE);
        System.out.println("The text is written to a file with the name '" + FILE_TO_WRITE + "'");
    }
}
