package com.deavensoft.training.cleancode.complextask.task1.thirdpartyjar;

public interface Command {
    boolean canProcess(String command);
    void process(String command);


}