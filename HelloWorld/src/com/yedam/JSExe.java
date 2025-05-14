package com.yedam;

// Heaven JAVA
// 자바 좋아
public class JSExe {

	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 30;
		System.out.println(num1 == num2);

		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1);
		System.out.println(str2);
		// 문자열을 비교할 경우에는 equals 사용
		System.out.println(str1.equals(str2));
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

		// 임의의 수를 생성 1 ~ 100사이의 임의의 값을 생성
		int sum = 0;
		for (int i = 0; i <= 5; i++) {
			int result = (int) (Math.random() * 100) + 1; // 1 <= x < 11
			sum += result;
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
	} // end of test2

} // end of class
