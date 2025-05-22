package com.yedam.exception;

/*
 * 1) 일반 예외 - 컴파일러가 에러부분을 파악함.
 * 2) 실행 예외 - 실행시점에 엘가 발생하는 경우.
 */
public class ExceptionExe {

	public static void main(String[] args) {
		// 2) 실행 예외
		String numStr = "a";
		int num = 0;
		try {
			num = Integer.parseInt(numStr);
		} catch (NumberFormatException e) {
			// 예외가 발생하면 대체할 코드
			System.out.println("일반예외발생.");
		}
		System.out.println(num);

		try {
			Class.forName("java.util.Scanner");
		} catch (ClassNotFoundException e) {  // 이러한 클래스는 없다라는 말
			e.printStackTrace();
		}

		System.out.println("end of program");
	}
}
