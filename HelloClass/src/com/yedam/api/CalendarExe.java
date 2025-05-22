package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * Calendar : 날짜, 시간 관련
 * Date : 날짜, 시간
 */

public class CalendarExe {
	
	public static void main(String[] args) {
		makeCalendar(2025, 5);

		
	}	
	
	// 달력
	public static void makeCalendar(int year, int month) {
		// 년도와 달이 입력되면 만들어지는 캘린더 만들기
		// HelloWorld/src/OperatorExe.java에서 참고


		// 대충 이렇게 될듯?
		// makeCalendar 참고
		// int years() {}
		// int months() {}
		// 
		
		System.out.printf("       %d년 %02d월\n"                  , year, month);
		System.out.printf("====================================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
			

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
          Calendar now = Calendar.getInstance();
          now.set(2025,  month - 1, 1);  // 1월달 시작점이 달라서
          space = now.get(Calendar.DAY_OF_WEEK);
          return space;
		} // end of getSpace

		// "월" 정보를 입력하면 말일을 알려주는 메소드 getLastDate(월)
		public static int getLastDate(int month) {
			int lastDate = 31;
			Calendar now = Calendar.getInstance();
			now.set(2025, month -1, 1);  // 5월로 설정
		    lastDate = now.getActualMaximum(Calendar.DATE);
		    return lastDate;
		} // end of getLastDate
	

	
	
	public static void date() {	
		// GMT 기준시 출력
		// 대한민국 서울 기준 GMT +9
	  Date today= new Date();
	  System.out.println(today.toGMTString());  // 중앙선은 작동은 되나 곳 사라질 수 있다는 표시
//	  System.out.println(today.toString());
	  
	  // 2025-05-12 13:22:38 와 같이 내가 익숙한 방식으로 보고 싶을때
	  // (1)우리가 익숙한 날짜 및 시간 표기는 없으나 시간을 String 값으로 반환해서 만들어야 됨
	  // (2)생성자의 매게값으로 포맷지정
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //  ex) 2025-05-12 13:22:38
	  String timeStr = sdf.format(today);  // Date -> String.
	  System.out.println(timeStr);
	  
	  // SimpleDateFormat 로 시간 조정
	  try {
	    today = sdf.parse("2025-08-01 09:00:00");  // String -> Date
	  } catch(ParseException e) {
		  e.printStackTrace();
	  } System.out.println(today);
	
	
    }
	
	
	public static void Cal() {
		// Calendar 클래스
		Calendar now = Calendar.getInstance();
		
		// 시간변경 가능
		// 년/월/일
		// 2025/1월/1일로 지정
		// 2024년으로 지정
		now.set(2025, 0, 1);
		now.set(Calendar.YEAR, 2024);  // 년도 지정 할 경우
		
		
		// 요일
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		switch(dayOfWeek) {
		case 1 : System.out.println("일요일"); break;
		case 2 : System.out.println("월요일"); break;
		case 3 : System.out.println("화요일"); break;
		}
		
		
		System.out.printf("%d년도 %d월 %d일 %d요일 마지막 달 : %d \n", now.get(Calendar.YEAR)  // .get(Calendar.Year) 대신 .get(1)해도 같음
		, now.get(Calendar.MONTH) // 월 출력  1월은 0부터 시작 => 4는 5월이라는 뜻
		, now.get(Calendar.DATE)  // 일
		, now.get(Calendar.DAY_OF_WEEK) // 날짜 250522기준 5 출력 => 일요일이 1이니까 => 5면 목요일
		, now.getActualMaximum(Calendar.DATE)  // 이번달의 마지막 달 출력
		);
	}
}
