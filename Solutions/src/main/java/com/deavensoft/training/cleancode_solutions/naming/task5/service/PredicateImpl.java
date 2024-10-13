package com.deavensoft.training.cleancode_solutions.naming.task5.service;

import com.deavensoft.training.cleancode_solutions.naming.task5.thirdpartyjar.Predicate;

public class PredicateImpl implements Predicate<String> {

    private String[] extensions;

    public PredicateImpl(String[] extensions) {
        this.extensions = extensions;
    }

    @Override
    public boolean test(String fileName) {
        for (String extension : extensions) {

            if (fileName.toLowerCase().endsWith(extension)) {
                return true;
            }
        }

        return false;
    }
}
