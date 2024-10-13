package com.deavensoft.training.cleancode.dry.task1;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountDetails {
    private LocalDate birth;
    private int age;
    private BigDecimal balance;
    private LocalDate startDate;

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
