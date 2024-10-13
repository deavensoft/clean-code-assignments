package com.deavensoft.training.cleancode_solutions.dry.task1;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InterestCalculator {
    private static final int AGE = 60;
    private static final double INTEREST_PERCENT_RATE = 4.5d;
    private static final double SENIOR_PERCENT_RATE = 5.5d;
    private static final int BONUS_AGE = 13;

    public BigDecimal calculateInterest(AccountDetails accountDetails) {
        if (isAccountStartedAfterBonusAge(accountDetails)) {
            return doCalculateInterest(accountDetails);
        }

        return BigDecimal.ZERO;
    }

    private boolean isAccountStartedAfterBonusAge(AccountDetails accountDetails) {
        return durationBetweenDatesInYears(accountDetails.getBirthDate(), accountDetails.getStartDate()) > BONUS_AGE;
    }

    private BigDecimal doCalculateInterest(AccountDetails accountDetails) {
        return BigDecimal.valueOf(calculateResult(accountDetails));
    }

    private double calculateResult(AccountDetails accountDetails) {
        double interestRate = determineRate(accountDetails);

        return accountDetails.getBalance().doubleValue()
                * durationSinceStartDateInYears(accountDetails.getStartDate()) * interestRate / 100;
    }

    private double determineRate(AccountDetails accountDetails) {
        return AGE <= accountDetails.getAge() ? SENIOR_PERCENT_RATE : INTEREST_PERCENT_RATE;
    }


    private int durationBetweenDatesInYears(LocalDate from, LocalDate to) {
        return calculateYearDifference(from, to);
    }

    private int durationSinceStartDateInYears(LocalDate startDate) {
        return calculateYearDifference(startDate, LocalDate.now());

    }

    private int calculateYearDifference(LocalDate startDate, LocalDate endDate) {
        return endDate.getYear() - startDate.getYear();
    }
}
