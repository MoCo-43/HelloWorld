package com.yedam.ref.app;

import java.util.Scanner;
  
public class MemberExe {
	static Member[] members = null;
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
	int allMember=0;
	Scanner scanner = new Scanner(System.in);
	while(run) {
		System.out.println("==================회원관리===================");
		System.out.println("1.회원가입 2.회원수정 3.회원삭제 4.회원조회 5.종료");
		System.out.println("===========================================");
		
		int selectNo = Integer.parseInt(scanner.nextLine());
	
		// 회원가입
		if (selectNo == 1) {
			System.out.println("추가할 회원 수>> ");
			allMember=Integer.parseInt(scanner.nextLine());
			members=new Member[allMember];	// 배열의 크기를 지정
		  for(int i = 0; i<members.length; i++) {
			System.out.printf("추가하실 아이디를 입력해주세요>>  ");
			String id = scanner.nextLine();
			System.out.printf("추가하실 이름을 입력해주세요>>  ");
			String name = scanner.nextLine();
			System.out.printf("추가하실 전화번호를 입력해주세요>>  ");
			String telephone = scanner.nextLine();
			System.out.printf("가입시 1000포인트 적립\n");
			int id_Point = 1000;

				
			// 인스턴스 생성
			Member member = new Member();
			member.id=id;
			member.name=name;			
			member.telephone=telephone;			
			member.id_Point=id_Point;			
			
			// 배열에 저장
			members[i] = member;
			}
		  
          // 회원수정
		} else if (selectNo == 2) {
			System.out.println("수정하실 회원의 아이디를 입력해주세요>> ");
		  
		  // 회원삭제
		} else if (selectNo == 3) {
			
			
		  // 회원조회
		} else if (selectNo == 4) {
			System.out.println("id를 입력해주세요>>");
			String id = scanner.nextLine();
			for(int i=0; i<members.length; i++) {
				
			}
			if (members == id) {
				System.out.println(allMember);
			}
		 // 프로그램 종료
		} else if (selectNo == 5) {
			run=false;
		}
	}
	scanner.close();
  }
}
