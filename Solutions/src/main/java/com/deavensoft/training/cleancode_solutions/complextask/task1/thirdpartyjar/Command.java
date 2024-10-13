package com.deavensoft.training.cleancode_solutions.complextask.task1.thirdpartyjar;

public interface Command {
    boolean canProcess(String command);
    void process(String command);


}