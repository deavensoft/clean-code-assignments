package com.deavensoft.training.cleancode_solutions.naming.task5.thirdpartyjar;

public class InvalidFileTypeException extends RuntimeException {
    String message;
    public InvalidFileTypeException(String s) {
        super();
        this.message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
