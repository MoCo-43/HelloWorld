package com.yedam.operator;

public class OperatorExe {

	public static void main(String[] args) {
		test5();
	}

	// 연습1
	public static void test() {
		// 증가, 감소 연scanner close 자바산자(++, --)
		byte num1 = -128;
//    	num1 = 128; // 범위초과
		num1 = 127;
		num1++; // Overflow 발생
		System.out.println(num1);

//		char ch1 = 'A';
//		ch1 = 66;
//		ch1 = '가'; 
//		System.out.println((int) ch1); // UNICODE 숫자가 출력됨

		// AtoZ 출력
		char ch1 = 'a';
		ch1 = 0x0444;
		for (int i = 1; i <= 26; i++) {
			System.out.println(ch1++);
		}
	}

	// 연습2 byte, short, long, int, char
	public static void test1() {
		byte num1 = 10;
		byte num2 = 20;
		byte sum = (byte) (num1 + num2); // 연산 할 시 정수타입(int)으로 연산되므로 에러 발생, 그러므로 데이터 타입 통일 시켜줌
		System.out.println(sum);

		// 래퍼 클래스 (Wrapper Class)
		long num3 = 100000000000L; // 정수 리터럴 int형태의 데이터타입이 아니라고 선언 해줌
		long num4 = 100L;
		System.out.println(Integer.MAX_VALUE); // int의 최대 범위
		System.out.println(num4);
	}

	public static void test2() {
		int num1 = 10;
		int num2 = 20;

		int result = ++num1 + num2++;
		System.out.printf("num1=>%d, num2=>%d result=>%d", num1, num2, result);

		boolean isTrue = true;
		if (isTrue) {
			System.out.println("참입니다.");
		}

		// == 부정은 !=, > 부정은 <=, >= 부정은 <
		result = 30;
		if (!(result != 30)) {
			System.out.println("result 는 30보다 작거나 같다.");
		}

		if (!(--num1 <= 10)) {
			System.out.printf("num1 => %d", num1);
		}
		if (!(--num1 <= 10 || num2 < 20)) {
			System.out.printf("num1, num2 => %d %d", num1, num2);
		}
	}

	public static void test3() {
		boolean isTrue = true;
		for (int i = 1; i <= 10; i++) {
			if (isTrue) {
				System.out.printf("i의 값은 %d\n", i);
			}
			isTrue = !isTrue; // 토글 (on -> off, off -> on)
		}
	}

	// 간이 캘린더
	public static void test4() {
		int mon = 1; // 월정보
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		int space = getSpace(mon);
		int lastDate = getLastDate(mon);

		// 빈공간
		for (int s = 1; s <= space; s++) {
			System.out.printf("%4s", " ");
		}

		// 날짜출력
		for (int day = 1; day <= lastDate; day++) {
			System.out.printf("%4d", day); // ___
			if ((day + space) % 7 == 0) {
				System.out.println();
			}
		}
	}

	// "월" 정보를 입력하면 "공란"반환하는 메소드 getSpace();

	public static int getSpace(int month) {
		int space = 0;
		if (month == 1) { // 1월달
			space = 3;
		} else if (month == 3 || month == 2) { // 2, 3월달
			space = 6;
		} else if (month == 4) { // 4월달
			space = 2;
		} else if (month == 5) { // 5월달
			space = 4;
		} else if (month == 7) { // 7월달
			space = 2;
		} else if (month == 8) { // 8월달
			space = 3;
		}
		return space;
	} // end of getSpace

	// "월" 정보를 입력하면 말일을 알려주는 메소드 getLastDate(월)
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch (month) {
		case 2:
			lastDate = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
			break;
		}
		return lastDate;
	} // end of getLastDate

	// 3항 연산자
	public static void test5() {
		// 60점 이상이면 합격, 미만이면 불합격
		String pass = "";
		int score = (int) (Math.random() * 100);
//		pass = (score >= 60) ? "합격" : "불합격";

		//if 문구
		// if(score > 60) {
//			pass = "합격";
//		} else {
//			pass="불합격";
//		}
		
		// <<과제>>  합격, 불합격, 불불합격 if문으로 만들어 출력하는 프로그램 
		System.out.printf("점수 : %d\n합격여부 : %s ", score, pass);

		// 80점이상 우수, 70점 합격, 나머지는 불합격
		pass = (score >= 80) ? (score >= 70) ? "우수" : "합격" : "불합격";
		System.out.printf("점수 : %d\n합격여부 : %s ", score, pass);
	}
	
	
}