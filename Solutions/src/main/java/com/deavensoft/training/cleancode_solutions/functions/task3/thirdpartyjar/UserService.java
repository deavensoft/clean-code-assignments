package com.deavensoft.training.cleancode_solutions.functions.task3.thirdpartyjar;

public interface UserService {

    boolean isPasswordCorrect(User user, String password);

    User getUserByName(String userName);

}
