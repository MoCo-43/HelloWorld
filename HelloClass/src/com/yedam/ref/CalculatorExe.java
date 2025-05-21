package com.yedam.ref;

// 실행클래스
public class CalculatorExe {
	public static void main(String[] args) {
		int a = 20, b = 30;

		// sum의 기능활용 // 인스턴스 멤버
		Calculator c1 = new Calculator();
		c1.sum(a, b); // 정적메소드

		// static
		// 인스턴스를 생성하지 않더라도 바로 실행 가능
		Calculator.static_sum(a, b);
		
		
		// 인스턴스 생성 후 실행가능
//		CalculatorExe ce = new CalculatorExe();
//		ce.printStar();
		
		
		// static이면 바로 실행 가능
		printStar();
	}
	
	
	static void printStar() {
		System.out.println("*");
	}
}
