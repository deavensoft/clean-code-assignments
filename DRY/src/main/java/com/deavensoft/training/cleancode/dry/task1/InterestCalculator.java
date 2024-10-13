package com.deavensoft.training.cleancode.dry.task1;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InterestCalculator {

    private static final int AGE = 60;
    private static final double INTEREST_PERCENT = 4.5d;
    private static final double SENIOR_PERCENT = 5.5d;
    private static final int BONUS_AGE = 13;


    public BigDecimal calculateInterest(AccountDetails accountDetails) {
        if (isAccountStartedAfterBonusAge(accountDetails)) {
            return interest(accountDetails);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private boolean isAccountStartedAfterBonusAge(AccountDetails accountDetails) {
        return durationBetweenDatesInYears(accountDetails.getBirth(), accountDetails.getStartDate()) > BONUS_AGE;
    }

    private int durationBetweenDatesInYears(LocalDate from, LocalDate to) {
        return to.getYear() - from.getYear();
    }

    private BigDecimal interest(AccountDetails accountDetails) {
        double interest = 0;
        if (isAccountStartedAfterBonusAge(accountDetails)) {
            if (AGE <= accountDetails.getAge()) {
                //interest = (PrincipalAmount * DurationInYears * AnnualInterestRate) / 100
                interest = accountDetails.getBalance().doubleValue()
                        * durationSinceStartDateInYears(accountDetails.getStartDate()) * SENIOR_PERCENT / 100;
            } else {
                interest = accountDetails.getBalance().doubleValue()
                        * durationSinceStartDateInYears(accountDetails.getStartDate()) * INTEREST_PERCENT / 100;
            }
        }
        return BigDecimal.valueOf(interest);
    }

    private int durationSinceStartDateInYears(LocalDate startDate) {
        LocalDate now = LocalDate.now();

        return now.getYear() - startDate.getYear();

    }
}
