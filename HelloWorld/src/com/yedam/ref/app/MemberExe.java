package com.yedam.ref.app;

import java.util.Scanner;
  
public class MemberExe {

	/*
	 * 회원 추가, 수정, 삭제, 조회 기능
	 * 
	 * 1)추가
	 *   - 아이디, 이름, 전화번호, 포인트
	 * 2)수정
	 *   - 아이디를 물어본 뒤, 전화번호를 입력받아 수정 가능하게 만들기
	 *   - 아이디
	 *   - 전화번호 (바뀔항목)
	 * 3)삭제
	 *   - 아이디 물어본 뒤, 없다면 없다라고 출력  
	 *   
	 *  4)조회
	 *    - 이름(조회)
	 */
public static void main(String[] args) {
	boolean run = true;
	Member[] members = new Member[10];
	Scanner scanner = new Scanner(System.in);
	while(run) {
		System.out.println("==================회원관리===================");
		System.out.println("1.회원가입 2.회원수정 3.회원삭제 4.회원조회 5.종료");
		System.out.println("===========================================");
		
		int selectNo = Integer.parseInt(scanner.nextLine());
	
		// 회원가입
		switch (selectNo) {
		case 1: // 추가
			System.out.printf("추가하실 아이디를 입력해주세요>>  ");
			String id = scanner.nextLine();
			System.out.printf("추가하실 이름을 입력해주세요>>  ");
			String name = scanner.nextLine();
			System.out.printf("추가하실 전화번호를 입력해주세요>>  ");
			String telephone = scanner.nextLine();
			System.out.printf("포인트 입력해 주세요>> ");
			int id_Point = Integer.parseInt(scanner.nextLine());

			// 인스턴스 생성
			Member member = new Member();
			member.id=id;
			member.name=name;			
			member.telephone=telephone;			
			member.id_Point=id_Point;
			
			// 배열에 추가
			for (int i=0; i<members.length; i++) {
			  if (members[i] == null) {
				  members[i] = member;
				  System.out.println("등록완료");
			      }
			}
			break;
		  
          // 회원수정
		case 2: 
			System.out.println("회원의 아이디를 입력해주세요>> ");
			id = scanner.nextLine();
			System.out.println("수정하실 회원의 전화번호를 입력해주세요>> ");
			telephone = scanner.nextLine();
			
			// 같은 값을 찾아서 변경하기.
			for (int i = 0; i < members.length; i++) {
				if (members[i] != null) {
					if (members[i].id.equals(id)) {
						members[i].telephone = telephone;
						System.out.println("전화번호 수정완료.");
					}
				}
			}
			break;
		  
		  // 회원삭제
		case 3:
			System.out.print("아이디를 입력하세요>> ");
			id = scanner.nextLine();

			// 같은 값을 찾아서 삭제하기.
			for (int i = 0; i < members.length; i++) {
				if (members[i] != null) {
					if (members[i].id.equals(id)) {
						members[i] = null;
						System.out.println("회원 삭제완료.");
					}
				}
			}
			break;	
			
		  // 회원조회
		case 4: // 조회.
			System.out.print("아이디를 입력>> ");
			id = scanner.nextLine();

			// 조회.
			System.out.printf("%-10s %-5s %-15s\n", "유저ID", "회원명", "전화번호");
			for (int i = 0; i < members.length; i++) {
				if (members[i] != null && (id.equals("") || id.equals(members[i].id))) {
					System.out.printf("%-10s %-5s %-15s\n", members[i].id, members[i].name,
							members[i].telephone);
				}
			}
			break;
		 // 프로그램 종료
		case 5: // 종료.
			run = false;
			break;
			
		default:
			System.out.println("메뉴를 다시 선택하세요.");
		}
		}
	scanner.close();
  }
}
