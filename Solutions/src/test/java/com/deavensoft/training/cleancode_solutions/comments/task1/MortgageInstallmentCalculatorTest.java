package com.deavensoft.training.cleancode_solutions.comments.task1;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.deavensoft.training.cleancode_solutions.comments.task1.thirdpartyjar.InvalidInputException;
import org.junit.jupiter.api.Test;


class MortgageInstallmentCalculatorTest {

    @Test
    void shouldCalculateMonthlyPaymentWhenAmountsAreSmall() {
        double monthlyPaymentAmount = MortgageInstallmentCalculator.calculateMonthlyPayment(1000, 1, 12);
        assertEquals(88.84d, monthlyPaymentAmount, 0.01d);
    }

    @Test
    void shouldCalculateMonthlyPaymentWhenAmountIsLarge() {
        double monthlyPaymentAmount = MortgageInstallmentCalculator.calculateMonthlyPayment(10000000, 1, 12);
        assertEquals(888487.88d, monthlyPaymentAmount, 0.01d);
    }

    @Test
    void shouldCalculateMonthlyPaymentWhenPrincipalIsZero() {
        double monthlyPaymentAmount = MortgageInstallmentCalculator.calculateMonthlyPayment(0, 1, 12);
        assertEquals(0, monthlyPaymentAmount, 0.01d);
    }

    @Test
    void shouldCalculateMonthlyPaymentWhenInterestRateIsZero() {
        double monthlyPaymentAmount = MortgageInstallmentCalculator.calculateMonthlyPayment(1000, 1, 0);
        assertEquals(83.33, monthlyPaymentAmount, 0.01d);
    }

    @Test
    void shouldThrowInvalidInputExceptionOnNegativeTenure() {
        assertThrows(InvalidInputException.class, () -> MortgageInstallmentCalculator.calculateMonthlyPayment(20, -10, 14.5));
    }

    @Test
    void shouldThrowInvalidInputExceptionOnNegativeInterestRate() {
        assertThrows(InvalidInputException.class, () -> MortgageInstallmentCalculator.calculateMonthlyPayment(20, 1, -12));
    }

    @Test
    void shouldThrowInvalidInputExceptionOnNegativePrincipalAmount() {
        assertThrows(InvalidInputException.class, () -> MortgageInstallmentCalculator.calculateMonthlyPayment(-20, 10, 14.5));
    }
}