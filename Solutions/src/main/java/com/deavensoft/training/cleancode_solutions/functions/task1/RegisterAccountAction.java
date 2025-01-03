package com.deavensoft.training.cleancode_solutions.functions.task1;

import com.deavensoft.training.cleancode_solutions.functions.task1.thirdpartyjar.Account;
import com.deavensoft.training.cleancode_solutions.functions.task1.thirdpartyjar.AccountManager;
import com.deavensoft.training.cleancode_solutions.functions.task1.thirdpartyjar.Address;
import com.deavensoft.training.cleancode_solutions.functions.task1.thirdpartyjar.PasswordChecker;
import com.deavensoft.training.cleancode_solutions.functions.task1.thirdpartyjar.WrongAccountNameException;
import com.deavensoft.training.cleancode_solutions.functions.task1.thirdpartyjar.WrongPasswordException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.deavensoft.training.cleancode_solutions.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {
    private PasswordChecker passwordChecker;
    private AccountManager accountManager;

    public void register(Account account) {
        validate(account);
        fillAccount(account);
        accountManager.create(account);
    }

    private void fillAccount(Account account) {
        account.setCreatedDate(new Date());
        account.setAddresses(getAddresses(account));
    }

    private void validate(Account account) {
        validateAccountName(account);
        validateAccountPassword(account);
    }

    private void validateAccountName(Account account) {
        if (account.getName().length() <= 5) {
            throw new WrongAccountNameException();
        }
    }

    private void validateAccountPassword(Account account) {
        String password = account.getPassword();

        if (password.length() <= 8 && isNotValidPassword(password)) {
            throw new WrongPasswordException();
        }
    }

    private boolean isNotValidPassword(String password) {
        return passwordChecker.validate(password) != OK;
    }

    private List<Address> getAddresses(Account account) {
        List<Address> addresses = new ArrayList<>();
        addresses.add(account.getHomeAddress());
        addresses.add(account.getWorkAddress());
        addresses.add(account.getAdditionalAddress());
        return addresses;
    }


    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }

}
