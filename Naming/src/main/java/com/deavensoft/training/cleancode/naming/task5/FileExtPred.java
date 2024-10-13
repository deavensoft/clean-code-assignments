package com.deavensoft.training.cleancode.naming.task5;


import com.deavensoft.training.cleancode.naming.task5.thirdpartyjar.Predicate;

public class FileExtPred implements Predicate<String> {

    private String[] extns;

    FileExtPred(String[] extns) {
        this.extns = extns;
    }

    @Override
    public boolean test(String fileName) {
        for (String extension : extns) {
            if (fileName.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}
