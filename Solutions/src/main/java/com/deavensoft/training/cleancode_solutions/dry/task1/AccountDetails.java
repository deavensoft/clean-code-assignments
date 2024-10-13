package com.deavensoft.training.cleancode_solutions.dry.task1;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountDetails {
    private LocalDate birthDate;
    private int age;
    private BigDecimal balance;
    private LocalDate startDate;

    LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
