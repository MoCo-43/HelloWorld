package com.yedam.exception;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExceptionExe2 {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("1.메뉴 2.종료");
			System.out.print("선택>> ");
			int menu = 0;

			while (true) { // 적절한 값을 선택할때 까지 반복
				try {
					menu = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException | NoSuchElementException e) {
					System.out.printf("1.메뉴 2.종료");
					System.out.printf("메뉴를 다시 선택하세요");
					continue;  // 반복하게 끔 계속 실행하게 하려면
				}
				break;  // 정상적인 실행 가능하게 끔 
			}
			
			switch (menu) {
			case 1:
				백업();
				break;
			case 2:
				run = false;
				break;
			default:
				System.out.println("없는 메뉴를 선택하여 종료합니다.");
			}
		System.out.println("end of prog.");

		}
		scn.close();  // 리소스를 반환
	}

	
	
	public static void 백업() {
		// NullPointerExecption
		// NumberFormatException
		// ClassCastException
		// ArrayIndexOutOfBoundException

		Scanner scanner = new Scanner(System.in);
		// Resource leak : 'scanner' is never used.
		String str = scanner.nextLine();
		try {
			System.out.print(str.toString());
			int num = Integer.parseInt("a");
		} catch (NullPointerException | NumberFormatException e) {
			System.out.println("Null 값을 참조.");
		}
		/*
		 * } catch(NumberFormatException e) { System.out.println("포맷 비정상."); }
		 */
		finally {
			// 정상실행, 예외발생 반드시 실행해야할 코드
		}

		System.out.println("end of prog.");
	}

}
