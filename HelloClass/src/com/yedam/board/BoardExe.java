package com.yedam.board;

import java.util.Scanner;

public class BoardExe {

	// 필드
	private Board[] boards; // 데이터 저장
	private Scanner scn = new Scanner(System.in);
	private int bno = 0;

	// 생성자
	public BoardExe() {
		boards = new Board[100];
		boards[0] = new Board(10, "날씨가 좋습니다.", "오늘 기온이 30도가 넘어가요", "홍길동");
		boards[1] = new Board(11, "날씨가 덥네요. ", "오늘 하루 힘내요", "홍길순");
	}

	// 메소드
	void execute() {
		boolean run = true;
		while (run) {
			System.out.println("------------------------------------------");
			System.out.println("1.추가   2.수정   3.삭제   4.목록   5.종료");
			System.out.println("------------------------------------------");
			System.out.println("선택>> ");

			int selectNo = Integer.parseInt(scn.nextLine());

			switch (selectNo) {
			case 1: // 추가
				addBoard();
				break;
			case 2: // 수정

			case 3: // 삭제

			case 4: // 목록
				boardList();
				break;
			case 5: // 종료
				run = false;
				System.out.println("종료합니다");
                break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			} // end of switch
		} // end of while
	} // end of execute.

	// 기능
	// "글번호를 입력하세요>> " >> 1 enter
	// "제목을 입력하세요>> " " 오늘은 덥네요." enter
	// "내용을 입력하세요>> " " 오늘 기온이 30도가 넘습니다... " enter
	// "작성자를 입력하세요>> " "홍길동"
	// "추가 성공" / "추가 실패" 메세지출력
	void addBoard() {
		System.out.printf("글번호를 입력하세요>>  ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.printf("제목을 입력하세요>>  ");
		String title = scn.nextLine();
		System.out.printf("내용을 입력하세요>>  ");
		String content = scn.nextLine();
		System.out.printf("작성자를 입력하세요>>  ");
		String writer = scn.nextLine();

		// Board인스턴스 선언하고 값을 지정
		Board board = new Board(no, title, content, writer);
		// 배열에 저장
		boards[bno++] = board;
		System.out.println("글 추가 성공");
	} // end of addBoard

	/* 기능 */
	/* 글번호 제목 작성자
      ========================
	   1 날씨가 좋아요 홍길동
	   2 클래스 멋짐! 홍길동
	   3 자바어려움 박석민
	   4 그래도 열심히 김민규
	 -------------------------------
	   상세보기: 글번호입력, 메뉴로 이동(q)
	   ----------------------------- */

	// 글이 없다면
	// ** 등록된 글이 없습니다 **
	void boardList() {
		System.out.println("글번호     제목               작성자");
		System.out.println("=================================");
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				boards[i].showInfo();
			}
		}
		// 상세보기
		System.out.println("---------------------------------");
		System.out.println("  상세보기: 글번호입력, 메뉴로 이동(q)  ");
		System.out.println("---------------------------------");
		String str = scn.nextLine();
		if (str.equals("q")) {
			return;
		} else {
			int no = Integer.parseInt(str);  // 글번호
			// 배열에서 조쇠
			for (int i=0; i<boards.length; i++) {
				if (boards[i] != null && boards[i].getBoardNo() == no) {
					boards[i].showAllInfo();
				}
			}
		}
		System.out.println();
		
	}
	
	void boardDel() {
		System.out.println("삭제 하실 글 제목을 고르세요");	
	}
}