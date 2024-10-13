package com.deavensoft.training.cleancode_solutions.naming.task3;

//An integer number in base 10 which is divisible by the sum of its digits is said to be a Harshad Number. An n-Harshad number is an integer number divisible by the sum of its digit in base n.
//Below are the first few Harshad Numbers represented in base 10:
//		1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 18, 20...
public class HarshadNumbersPrinter {

	public static void main(String[] args) {
		printHarshadNumbers();
	}

	private static void printHarshadNumbers() {
		long lim = 1000;

		for (int i = 1; i <= lim; i++) {

			if (i % getSumOfDigitsFor(i) == 0) {
				System.out.println(i);
			}
		}
	}

	private static int getSumOfDigitsFor(int number) {
		int sum = 0;

		while (number != 0) {
			sum += number % 10;
			number = number / 10;
		}

		return sum;
	}
}
