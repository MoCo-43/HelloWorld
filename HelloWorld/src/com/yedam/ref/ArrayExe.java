package com.yedam.ref;

import java.util.Scanner;
// 미완성
public class ArrayExe {
	public static void main(String[] args) {
		friendApp();
	}

	// 친구정보 관리
	public static void friendApp() {
		Scanner scn = new Scanner(System.in);
		// 배열선언
		String[] friendAry = new String[10];


		boolean run = true;

		while (run) {
			// 메뉴선택
			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 추가 
				// 동일한 이름 있는지 확인, 추가하겠습니까 확인 후 추가 취소
				System.out.printf("이름을 입력하세요>> ");
				String name = scn.nextLine();
				name = scn.nextLine();
				// 이름이 존재하는 지를 확인 boolean 만들어서 중복 찾기
				
				// 존재하는 이름이라면 추가 할까요? 1추가 2취소
				// 2취소를 누르면 다시 원래대로 돌아가도록 continue;
				
				// 1추가 누르게 된다면
				// 배열 null인지 확인 후
				// 추가
				if (item == name && name == null) {
					System.out.println("리스트에 사람이 있습니다.");
					break;
				}
						break;
						
			case 2: // 목록조회
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						System.out.printf("friendAry[%d]번째의 값: %s\n", i, friendAry[i]);
					}
				}
				break;
			case 3: // 삭제 
				
				// 친구가 없다면 삭제할 친구 없다고 출력
				
				// 친구이름이 있는지 확인 boolean값 및 for if문을 돌림
				// 이름을 못찾는다면 목록에 친구가 없다는 메시지를 출력
				
				System.out.println("삭제할 친구 이름>>");
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null && friendAry[i].equals(name)) {
						friendAry[i] = null;
					}
				}
				break;
			case 4: // 종료
				System.out.println("프로그램을 종료합니다");
				break;

			}
			System.out.println("end of prog.");
		}
	}

	// 문자열 배열 삭제 기능
	public static void deleteAry() {
		Scanner scn = new Scanner(System.in);
		// 배열선언
		String[] stringAry = new String[10];
		stringAry[0] = "홍길동";
		stringAry[1] = "김친구";
		stringAry[2] = "김태완";
		stringAry[3] = "김태희";

		System.out.println("삭제할 친구 이름>>");
		String name = scn.nextLine();

		// 삭제할 친구이름을 검색
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null && stringAry[i].equals(name)) {
				stringAry[i] = null; // 삭제
			}
		}
		// 입력값 출력
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}
		System.out.println("end of prog.");

	}

	// 문자열 배열
	public static void strAry() {
		Scanner scn = new Scanner(System.in);
		// 배열 선언
		String[] stringAry = new String[10];

		while (true) {
			System.out.printf("이름을 입력하세요>>");
			String name = scn.nextLine();
			if (name.equals("quit")) {
				break; // while문 중료
			}

			for (int i = 0; i <= stringAry.length; i++) {
				// 빈공간(null) 체크
				if (stringAry[i] == null) {
					stringAry[i] = name;
					System.out.printf("입력성공.");
					break; // 안넣으면 계속 null값에 채워 넣게 됨
				}
			} // end of for

		} // end of while

		// 입력값 출력
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}
		System.out.println("end of prog.");
	} // end of main
} // end of class
