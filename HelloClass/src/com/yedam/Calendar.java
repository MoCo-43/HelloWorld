package com.yedam;

public class Calendar {


	// 윤년계산기
	
	/*
	 *
https://chloe-ki.tistory.com/entry/java-leap-year-code-with-if-else-conditional-statement


답안 코드
https://blog.naver.com/heartflow89/220966558486

윤년이란?
지구가 태양을 한 번 공전하는 데 걸리는 시간을 일 년으로 두었는데, 사실은 그 시간이 365일이 아닌 365일 5시간 49분 가량이다. 
일 년에 5시간 49분씩 4 년이 지나면 약 하루가 되는데, 이를 맞추기 위해 4 년마다 한 번씩 2월을 하루 늘리고 이를 윤년이라 한다. 
단, 이렇게 계산하게 되면 매년 11분 가량이 초과되어 계산된다. 
이는 131년이 지나면 하루(대략 400년에 3일)가 되기 때문에 대부분의 국가에서 반영하는 
그레고리력에서는 400년에 3일을 제외시키기 위해 100년마다 한 번 윤년을 없애고 400년 마다 다시 하루를 추가해 윤년을 둔다. 
정리하면 다음과 같은 방법으로 윤년을 계산할 수 있다.
☞ 연도가 4로 나누어 떨어지면 윤년이다. ex) 2020년, 2024년, 2028년, ...
☞ 연도가 100으로 나누어 떨어지면 윤년이 아니다. ex) 2100년, 2200년, 2300년, ...
☞ 연도가 400으로 나누어 떨어지면 윤년이다. ex) 2000년, 2400년, 2800년, ...
예를 들면 2000년은 100의 배수이지만 400으로 나누어 떨어지기 때문에 윤년이다. 이를 알면 조건문을 활용하여 코드화하는 것은 쉽다. 두 가지 알고리즘을 생각해보았다.

알고리즘 1) 4로 나누어 떨어지면 우선 윤년으로 판단하고, 그 중 400이 아닌 100으로만 나누어 떨어지는 경우를 평년으로 판단한다.
알고리즘 2) 주어진 연도가 400으로 나누어 떨어지면 윤년으로 판단하고 종료한다. 
아닐 경우 100으로 나누어 떨어지면 평년으로 판단하고 종료한다. 
그것도 아닐 경우 4로 나누어 떨어지면 윤년으로 판단하고 종료한다. 
이 외의 모든 케이스는 평년이다. 


	 * 
	 * 내가 한 경우
	 *   => 경우의 수 전부 대입
	 * 4
	 * 100
	 * 400
	 * 
	 * 4 or 100
	 * 4 or 100 or 400
	 * 
	 * 100 or 400
	 * 
	 * 
	 * 
	 */
	static boolean isLeapYear(int year) {
		// 윤년이면 true, 평년이면 false
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		  } else {
			  return false;
		}
	} // end of isLeapYear

         
	
	
	
	
	static void showMonth() {
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
		} else if (month == 9) { // 9월달
			space = 1;
		} else if (month == 10) { // 10월달
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
}