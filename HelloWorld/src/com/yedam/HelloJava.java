package com.yedam;

// 데이터타입이 중요 함
// ctrl+shift+f => 정렬
public class HelloJava {
	public static void main(String[] args) {
		// 데이터 타입 => int 정수 double 실수 boolean 참 거짓
		int num1 = 10; // 초기화
		double num2 = 20; // 자동형변환(promotion) 발생

		// num1 = num2; // 큰 값을 작은 값에 넣으려면 에러가 남
		num1 = (int) num2; // 강제형변환(casting)

		int num3 = 100;
		double num4 = 200;
		double result = (double) num3 + num4;
		System.out.println("결과는 " + result);

		// 20 + 30 => 50
//		System.out.println("결과는 " + 20 + 30); // 문자열로 출력 됨 
		System.out.println("결과는 " + (20 + 30));

	}
}
