package com.deavensoft.training.cleancode.naming.task3;

//An integer number in base 10 which is divisible by the sum of its digits is said to be a Harshad Number. An n-Harshad number is an integer number divisible by the sum of its digit in base n.
//Below are the first few Harshad Numbers represented in base 10:
//		1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 18, 20...
public class H {

	// print some Harshad numbers
	public static void main(String[] args) {
		long L = 1000; // limit the seq of Harshad numbers
		for (int i = 1; i <= L; i++) {
			if (i % loop(i) == 0) {
				System.out.println(i);
			}
		}
	}

	private static int loop(int N) {
		int S = 0;
		while (N != 0) {
            S += N % 10;
            N = N / 10;
        }
		return S;
	}

}
