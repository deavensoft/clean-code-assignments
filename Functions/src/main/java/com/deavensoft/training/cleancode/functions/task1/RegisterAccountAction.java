package com.deavensoft.training.cleancode.functions.task1;

import com.deavensoft.training.cleancode.functions.task1.thirdpartyjar.Account;
import com.deavensoft.training.cleancode.functions.task1.thirdpartyjar.AccountManager;
import com.deavensoft.training.cleancode.functions.task1.thirdpartyjar.Address;
import com.deavensoft.training.cleancode.functions.task1.thirdpartyjar.PasswordChecker;
import com.deavensoft.training.cleancode.functions.task1.thirdpartyjar.WrongAccountNameException;
import com.deavensoft.training.cleancode.functions.task1.thirdpartyjar.WrongPasswordException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.deavensoft.training.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {


    private PasswordChecker passwordChecker;
    private AccountManager accountManager;

    public void register(Account account) {
        if (account.getName().length() <= 5){
            throw new WrongAccountNameException();
        }
        String password = account.getPassword();
        if (password.length() <= 8) {
            if (passwordChecker.validate(password) != OK) {
                throw new WrongPasswordException();
            }
        }

        account.setCreatedDate(new Date());
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(account.getHomeAddress());
        addresses.add(account.getWorkAddress());
        addresses.add(account.getAdditionalAddress());
        account.setAddresses(addresses);
        accountManager.create(account);
    }


    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {

        this.passwordChecker = passwordChecker;
    }

}
