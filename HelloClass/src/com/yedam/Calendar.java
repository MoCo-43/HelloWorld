package com.yedam;

public class Calendar {


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