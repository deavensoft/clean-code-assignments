package com.deavensoft.training.cleancode_solutions.naming.task5;

import com.deavensoft.training.cleancode_solutions.naming.task5.service.PredicateImpl;
import com.deavensoft.training.cleancode_solutions.naming.task5.thirdpartyjar.InvalidDirectoryException;
import com.deavensoft.training.cleancode_solutions.naming.task5.thirdpartyjar.InvalidFileTypeException;
import com.deavensoft.training.cleancode_solutions.naming.task5.thirdpartyjar.Predicate;
import com.deavensoft.training.cleancode_solutions.naming.task5.thirdpartyjar.PropertyUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public final class FileManager {

    private static final String[] IMAGES = {"jpg", "png"};
    private static final String[] TEXT_DOCS = {"pdf", "doc"};

    private String basePath = PropertyUtil.loadProperty("basePath");
    private final String DIR_PATH = basePath + File.separator;

    public File retrieve(String fileName) {
        validateType(fileName);
        return Paths.get(DIR_PATH, fileName).toFile();
    }

    public List<String> getImageList() {
        return files(basePath, IMAGES);
    }

    public List<String> getDocumentList() {
        return files(basePath, TEXT_DOCS);
    }

    private void validateType(String fileName) {
        if (isInvalidType(fileName)) {
            throw new InvalidFileTypeException("File type not Supported: " + fileName);
        }
    }

    private boolean isInvalidType(String fileName) {
        return isInvalidImage(fileName) && isInvalidDocument(fileName);
    }

    private boolean isInvalidImage(String fileName) {
        Predicate<String> fileExtensionPredicateService = new PredicateImpl(IMAGES);
        return !fileExtensionPredicateService.test(fileName);
    }

    private boolean isInvalidDocument(String fileName) {
        Predicate<String> documentExtensionsPredicate = new PredicateImpl(TEXT_DOCS);
        return !documentExtensionsPredicate.test(fileName);
    }

    private List<String> files(String directoryPath, String[] allowedExtensions) {
        final Predicate<String> fileExtensionPredicateService = new PredicateImpl(allowedExtensions);
        FilenameFilter filenameFilterByPredicate = getFilenameFilterByPredicate(fileExtensionPredicateService);
        return Arrays.asList(directory(directoryPath).list(filenameFilterByPredicate));
    }

    private FilenameFilter getFilenameFilterByPredicate(Predicate<String> fileExtensionPredicateService) {
        return (dir, str) -> fileExtensionPredicateService.test(str);
    }

    private File directory(String directoryPath) {
        File directory = new File(directoryPath);
        validateDirectory(directory);
        return directory;
    }

    private void validateDirectory(File directoryInstance) {
        if (directoryInstance != null && isNotDirectory(directoryInstance)) {
            throw new InvalidDirectoryException("Invalid directory found: " + directoryInstance.getAbsolutePath());
        }
    }

    private boolean isNotDirectory(File dir) {
        return !dir.isDirectory();
    }

}