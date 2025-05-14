package com.yedam;

public class JSExe {
	public static void main(String[] args) {
		test2();
	} // end of main

	public static void test() {
		int sum = 0;
		// 1 ~ 10 까지의 누적
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println("결과 : " + sum);
	} // end of test
	
	public static void test2() {
		int sum = 0;
		for (int i = 0; i <= 5; i++) {
			int result = (int) (Math.random() * 10) + 1; // 1 <= x < 11 // 임의의 수 1 ~ 10사이의를 생성
			sum += result;

		}
		System.out.println("결과 : " + sum);
	}
} // end of class
