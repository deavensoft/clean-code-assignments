package com.deavensoft.training.cleancode_solutions.functions.task3;

import com.deavensoft.training.cleancode_solutions.functions.task3.thirdpartyjar.Controller;
import com.deavensoft.training.cleancode_solutions.functions.task3.thirdpartyjar.User;

public abstract class UserController implements Controller {

    private UserAuthenticator userAuthenticator;

    protected UserController(UserAuthenticator userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
    }

    public void authenticateUser(String userName, String password) {
        User user = userAuthenticator.loginUser(userName, password);

        if (user == null)
            generateFailLoginResponse();
        else
            generateSuccessLoginResponse(userName);
    }

}
