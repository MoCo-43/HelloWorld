package com.yedam.condition;

import java.util.Scanner;

public class LoopExe {
	public static void main(String[] args) {
		test2();

	}

	public static void test() {
		// while vs do..while
		boolean run = false;

		while (run) {
			System.out.println("while문");
			run = !run;
		}

		// do.. while 먼저 블록을 실행한 뒤 조건을 검사
		do {
			System.out.println("do-while문");
			run = !run;
		} while (run = !run);
		System.out.println("end of prog.");
	}

	// 가위 바위 보 게임
	/*
	 * "가위(1)", "바위(2)", "보(3)" / 게임종료(4) math.random() 생성을 할때 1, 2, 3 입력값을 받아 가위바위보
	 * 게임을 한 뒤 누가 이기는지 출력하시오. 이길 때 "You Won", 졌을 때 "You Lose", 비기면 "Tie"
	 */
	public static void test2() {
		 System.out.printf("가위바위보 게임을 시작합니다.\n가위(1) 바위(2) 보(3) 게임종료(4)");
		 int com_Value = (int) (Math.random() * 3) +1;
		 Scanner scn = new Scanner(System.in);
		 int my_Value = Integer.parseInt(scn.nextLine());
		 System.out.printf("입력 값 : %d\n", my_Value);

		 
		 boolean g_Start = false;
		 // switch case 문으로 바꿔야 될듯?
		 while (g_Start=true) {
			 if (com_Value == my_Value) {
				 System.out.printf("컴퓨터가 낸 값 : %d", com_Value);
				 System.out.printf("\nTie");
				 break;
			 } else if (com_Value > my_Value) {
				 System.out.printf("컴퓨터가 낸 값 : %d", com_Value);
				 System.out.printf("\nYou lose");
				 break;
			 } else if (com_Value < my_Value) {
				 System.out.printf("컴퓨터가 낸 값 : %d", com_Value);
				 System.out.printf("\nYou Won");
				 break;
			 } else if (my_Value == 4){
				 System.out.printf("게임을 종료합니다.");
				 break;
			 } 	
			 scn.close();
		 } 	
		 
	 }

}
