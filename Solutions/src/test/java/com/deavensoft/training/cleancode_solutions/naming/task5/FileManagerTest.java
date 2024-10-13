package com.deavensoft.training.cleancode_solutions.naming.task5;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.deavensoft.training.cleancode_solutions.naming.task5.thirdpartyjar.InvalidFileTypeException;

import java.io.File;
import java.util.List;
import org.junit.jupiter.api.Test;

class FileManagerTest {

    FileManager fileManager = new FileManager();

    @Test
    void should_listAllImageFiles() {
        List<String> imageList = fileManager.getImageList();
        assertNotNull(imageList);
        assertEquals(imageList.size(), 1);
        assertEquals(imageList.getFirst(), "java.png");
    }

    @Test
    void should_listAllDocumentFiles() {
        List<String> documentFiles = fileManager.getDocumentList();
        assertNotNull(documentFiles);
        assertEquals(documentFiles.size(), 1);
        assertEquals(documentFiles.getFirst(), "sample.doc");
    }

    @Test
    void should_retrieveFile_when_validImage() {
        File image = fileManager.retrieve("java.png");
        assertTrue(image.exists());
    }

    @Test
    void should_throwException_when_unsupportedImageType() {
        assertThrows(InvalidFileTypeException.class, () -> fileManager.retrieve("invalidImage.img"));
    }

    @Test
    void should_returnEmpty_when_noImageExists() {
        File image = fileManager.retrieve("invalidImage.jpg");
        assertFalse(image.exists());
    }

    @Test
    void should_retrieveFile_when_validDocument() {
        File document = fileManager.retrieve("sample.doc");
        assertTrue(document.exists());
    }

    @Test
    void should_throwException_when_unsupportedDocumentType() {
        assertThrows(InvalidFileTypeException.class, () -> fileManager.retrieve("invalidDoc.java"));
    }

    @Test
    void should_throwException_when_retrieveFileWithNoExtension() {
        assertThrows(InvalidFileTypeException.class, () ->fileManager.retrieve("noExtension"));
    }

    @Test
    void should_returnEmpty_when_noDocumentExists() {
        File document = fileManager.retrieve("invalidDoc.pdf");
        assertFalse(document.exists());
    }
}
