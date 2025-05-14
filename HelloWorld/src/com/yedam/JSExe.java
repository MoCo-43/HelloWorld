package com.yedam;

import java.util.Scanner;

public class JSExe {

	public static void main(String[] args) {
//		int num1 = 30;
//		int num2 = 30;
//		System.out.println(num1 == num2);
//
//		String str1 = new String("Hello");
//		String str2 = new String("Hello");
//		System.out.println(str1);
//		System.out.println(str2);
//		// 문자열을 비교할 경우에는 equals 사용
//		System.out.println(str1.equals(str2));
//
//		String str3 = "30";
//		int num3 = 30;
//		System.out.println(str3.equals("" + num3));
//		int num4 = Integer.parseInt(str3); // 문자열숫자
//		System.out.println(num3 == num4); // 30 vs "30" -> 30
//
//		// 문자열을 비교할 경우에는 equals 사용
//		System.out.println(str1.equals(str2));		

		// test2(); // 평균을 구하기(소수점까지 출력)
		// test3(); //
		// test4(); // 스캐너 사용
		// test5();
		test5();
		//test5_2();
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

//		// 임의의 수를 생성 1 ~ 100사이의 임의의 값을 생성
//		int sum = 0;
//		for (int i = 0; i <= 5; i++) {
//			int result = (int) (Math.random() * 100) + 1; // 1 <= x < 11
//			sum += result;
//		}
		System.out.println("결과 : " + sum);
	} // end of test

	public static void test2() {
		/*
		 * 임의의 수를 생성(1 ~ 100) 후 임의의 수를 나누어 나눈거에 평균을 구해라? 평균 173/5 => 34.6
		 */
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
			int result = (int) (Math.random() * 100) + 1;
			sum += result;
		}
		double avg = sum / 7.0;
		avg = Math.round(avg * 100) / 100.0;
		System.out.println("합계 : " + sum + ", 평균(avg) : " + avg);
		System.out.println("평균 : " + Math.round(sum) / 5.0);
//		System.out.println(Math.round(23.678 * 100) / 100.0); // 소수점 둘째자리 표시?
	} // end of test2

	public static void test3() {
		/*
		 * 임의의 수를 생성(30 ~ 100) 후 임의의 수를 생성해 나누어 나눈거에 평균을 구해라? 평균 173/5 => 34.6
		 */
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			int result = (int) (Math.random() * 71) + 30;
			System.out.println(result);
			sum += result;
		}
		double avg = sum / 3.0;
		avg = Math.round(avg * 100) / 100.0;
		System.out.println("합계 : " + sum + ", 평균(avg) : " + avg);
//		System.out.println(Math.round(46.47); // EX) 4646.7 *100 을 math.round는 첫번째 자리 반올림 하여 4647 => 그다음 100.0을 나누게 된다면 46.47이라는 값으로 나옴 
	} // end of test3

//	public static void test4() {
//	   	// 사용자의 입력값을 읽어들이기
//	   Scanner scn = new Scanner(System.in);
//	   System.out.println("학생의 점수를 입력>>");
//	   String value = scn.nextLine(); // 입력값을 문자열형태로 반환
//	   int score = Integer.parseInt(value);
////	   System.out.println("입력값은 " + value);
//	} // end of test4

	public static void test4() {
		// 사용자의 입력값을 읽어들이기
		Scanner scn = new Scanner(System.in);
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			System.out.println("학생의 점수를 입력>>");
			String value = scn.nextLine(); // 입력값을 문자열형태로 반환
			int score = Integer.parseInt(value);
			sum += score;
		}
		double avg = sum / 3.0;
		avg = Math.round(avg * 100) / 100.0;
		System.out.println("합계 :" + sum + ", 평균 :" + avg);
	} // end of test4

	public static void test5() {

		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("메세지 입력 종료하려면 quit>>");
			String msg = scn.nextLine();
			// equals로 비교
			if (msg.equals("quit")) {
				break;
			}
			System.out.println("입력한 값은 " + msg);
		}
		System.out.println("end of program.");
	} // end of test5

	// test5 변형
	// 홍길동 김민규 최석영 이라는 이름을 입력하면 반복문 종료
	// 친구목록은 홍길동, 김민규, 최석영 입니다. => 출력
	public static void test5_1() {

		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("친구이름 입력(공백으로 친구이름 구분), 종료하려면 quit>>");
			String msg = scn.nextLine();
			// equals로 비교
			if (msg.equals("홍길동 김민규 최석영")) {
				System.out.println("친구목록은 " + msg + " 입니다.");
				break;
			} else if (msg.equals("quit")) {
				continue;
			} else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
		}
	} // end of test5_1
	
	// 교수님 작성한 test5_1 코드 
	// 홍길동 김민규 최석영
	public static void test5_2() {
	Scanner scn = new Scanner(System.in);
	String str = "친구목록은 ";
	while(true) {
		System.out.println("친구이름 입력, 종료하려면 quit>>");
		String msg = scn.nextLine();
		
		if (msg.equals("quit")) {
			str += " 입니다.";
			break;
		}
		str += msg + ", ";
	}
	System.out.println(str);
	} // end of test5_2
} // end of class