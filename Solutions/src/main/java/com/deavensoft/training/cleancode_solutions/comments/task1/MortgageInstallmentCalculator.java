package com.deavensoft.training.cleancode_solutions.comments.task1;

import com.deavensoft.training.cleancode_solutions.comments.task1.thirdpartyjar.InvalidInputException;

class MortgageInstallmentCalculator {
    private static final int COUNT_OF_MONTHS_IN_YEAR = 12;

    static double calculateMonthlyPayment(int principalAmount, int mortgageTermInYears, double interestRate) {
        defineValues(principalAmount, mortgageTermInYears, interestRate);
        return doCalculateMonthlyPayment(principalAmount, mortgageTermInYears, interestRate);
    }

    private static double doCalculateMonthlyPayment(int principalAmount, int mortgageTermInYears, double interestRate) {
        double mortgageTermInMonth = convertYearsTermInMonth(mortgageTermInYears);
        if (rateValueZero(interestRate)) {
            return principalAmount / mortgageTermInMonth;
        }

        interestRate = convertIntoDecimal(interestRate);
        double monthlyRate = convertIntoMonthlyRate(interestRate);
        return calculateMonthlyPayment(principalAmount, mortgageTermInMonth, monthlyRate);
    }

    private static void defineValues(int principalAmount, int mortgageTermInYears, double interestRate) {
        if (principalAmount < 0 || mortgageTermInYears <= 0 || interestRate < 0) {
            throw new InvalidInputException("Negative values are not allowed");
        }
    }

    private static double convertIntoDecimal(double interestRate) {
        return interestRate / 100.0;
    }

    private static double convertYearsTermInMonth(int mortgageTermInYears) {
        return mortgageTermInYears * COUNT_OF_MONTHS_IN_YEAR;
    }

    private static boolean rateValueZero(double interestRate) {
        return interestRate == 0;
    }

    private static double convertIntoMonthlyRate(double interestRate) {
        return interestRate / 12.0;
    }

    private static double calculateMonthlyPayment(int principalAmount, double tmorgageTermInMonthm, double monthlyRate) {
        return (principalAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -tmorgageTermInMonthm));
    }
}