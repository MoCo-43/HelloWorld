package com.yedam;

import java.util.Scanner;

public class ObjectExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("년도를 입력하세요>> ");
		int year = 0;

		while(true) {
		try {
		  year = Integer.parseInt(scn.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("년도입력은 숫자로만 해주세요>> ");
			continue;
		  }
		break;
		}
		
		Calendar.isLeapYear(year);
		if (Calendar.isLeapYear(year) == true) {
			System.out.printf("%d년은 윤년입니다.\n", year);
		} else {
			System.out.printf("%d년은 윤년이 아닙니다.\n", year);
		}
		scn.close();
		
		// 호출
//		Calendar.showMonth();
	}
}