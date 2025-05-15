package com.yedam.operator;
import java.util.Scanner;

public class ScannerExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int balance = 0; // 계좌의 금액

		while (true) {
			System.out.println("1.입금 2.출금 3.잔액 4.종료");
			int menu = Integer.parseInt(scn.nextLine()); // Integer.parseInt("30");
			if (menu == 1) {
				System.out.print("입금액 최대한도는 100,000만원까지입니다.>>");
				int inBalance = Integer.parseInt(scn.nextLine());
				if (inBalance+balance == 100000 || inBalance > 100000)  {
					System.out.println("100,000만원을 초과하여 입금이 되지 않습니다.");
					break;
				} else {
					balance += inBalance;
					continue;
				}
			} else if (menu == 2) {
				System.out.println("출금액을 입력>>");
				int outBalance = Integer.parseInt(scn.nextLine());
				if (outBalance < 100000 || outBalance > balance) { // ((outBalance == balance) ? balance > 100000 : )
					System.out.println("출금 하실 수 없습니다");
					break;
				} else {
					balance -= outBalance;
					continue;
				}
			} else if (menu == 3) {
				System.out.printf("현 잔액>> %d\n", balance);
				continue;
			} else if (menu == 4) {
				System.out.println("프로그램을 종료 합니다.");
				break;
			}
		} // end of while
		scn.close();
		System.out.println("End of Program.");
	} // end of main
}

// while 문은 언제까지 반복될지 모를때 유용
/*
 * 
 * Scanner scn = new Scanner(System.in); while(true) {
 * System.out.println("1.메뉴 2.메뉴 3.메뉴 4.종료"); int menu =
 * Integer.parseInt(scn.nextLine()); // Integer.parseInt("30"); if (menu == 1) {
 * System.out.println("1번 메뉴를 선택했습니다."); } else if(menu == 2) {
 * System.out.println("2번 메뉴를 선택했습니다."); } else if(menu == 3) {
 * System.out.println("3번 메뉴를 선택했습니다."); } else if(menu == 4) {
 * System.out.println("프로그램을 종료 합니다."); break; } else {
 * System.out.println("1번 ~ 4번중에 선택하세요."); } } //end of while scn.close();
 * System.out.println("End of Program.");
 * 
 */

//
