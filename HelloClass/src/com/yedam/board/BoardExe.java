package com.yedam.board;

import java.util.Scanner;

public class BoardExe {

//추가(addBoard) 
 //수정 (modifyBoard) - 글번호, 바뀔내용, 바뀔제목 
//삭제 (removeBoard) - 글번호
//목록(boardList) - 상세화면 조회 글번호를 기준으로 수정 삭제 
 //조회가능 (글번호 -> 글반환)하는 메소드 필요 => getBoard


// 순번부여(nextSequence) - 현재 글 번호를 가져와 +1 을 하면 순번


	// 필드
	private Board[] boards; // 배열형태로 데이터 저장
	private Scanner scn = new Scanner(System.in);
	private int bno = 2;

	// 생성자
	public BoardExe() {
		boards = new Board[100];
		boards[0] = new Board(10, "날씨가 좋습니다.", "오늘 기온이 30도가 넘어가요", "홍길동");
		boards[1] = new Board(11, "날씨가 덥네요. ", "오늘 하루 힘내요", "홍길순");
		boards[2] = new Board(12, "날씨가 덥네요.12 ", "오늘 하루 힘내요", "홍길순");
		boards[3] = new Board(13, "날씨가 덥네요.13 ", "오늘 하루 힘내요", "홍길순");
		boards[4] = new Board(14, "날씨가 덥네요.14 ", "오늘 하루 힘내요", "홍길순");
		boards[5] = new Board(15, "날씨가 덥네요.15 ", "오늘 하루 힘내요", "홍길순");
		boards[6] = new Board(16, "날씨가 덥네요.16 ", "오늘 하루 힘내요", "홍길순");
		boards[7] = new Board(17, "날씨가 덥네요.17 ", "오늘 하루 힘내요", "홍길순");
		boards[8] = new Board(18, "날씨가 덥네요.18 ", "오늘 하루 힘내요", "홍길순");
		boards[9] = new Board(19, "날씨가 덥네요.19 ", "오늘 하루 힘내요", "홍길순");
		boards[10] = new Board(20, "날씨가 덥네요.20 ", "오늘 하루 힘내요", "홍길순");
	}

	// 메소드
	void execute() {
		boolean run = false;
		
		// 250521 과제
		// 로그인 3번의 기회를 주는데
		// 3번 후에는 로그인 실패라고 하고 프로그램 종료
		
		
		
		
		// 아이디를 입력해주세요
		
		// 1) 로그인 시도 횟수 카운터를 3으로 시작
		int loginCount = 3;
		// 2) 로그인 성공 플래그는 아직 false
		boolean loginCheck = false;

		// 3) loginCheck가 false(실패) 이고, 남은 횟수가 있을 때만 반복
		while (!loginCheck && loginCount > 0) {
		    // 사용자 입력
		    String userId = userMessage("아이디를 입력해주세요");
		    String passWd = userMessage("비밀번호를 입력해주세요");

		    // 로그인 검사
		    loginCheck = UserExe.login(userId, passWd);
		    if (loginCheck) {
		        System.out.println("로그인 성공\n");
		        run = true;
		    } else {
		        loginCount--;  // 실패했으니 남은 횟수 감소
		        System.out.printf("로그인 실패. 남은 기회: %d회\n\n", loginCount);
		    }
		}

		// 4) 3회 모두 실패했으면 execute() 종료
		if (!loginCheck) {
		    System.out.println("로그인 3회 실패. 프로그램을 종료합니다.");
		    return;
		}
		
//		while(loginCount < 3) {
//		if (loginCheck == true) {
//		  System.out.println("로그인 성공");
//		  run = true;
//		} else if (!loginCheck || loginCount == 0) {
//			loginCount--;
//			System.out.println("아이디와 비밀번호를 다시 확인해주세요\n");
//			System.out.printf("로그인 남은 횟수 : %d", loginCount);
//		  }
//		}
		
		
//		  if (!UserExe.login(userId, passWd) ) {
//		  System.out.println("아이디와 비밀번호를 확인하세요.");
//	
//		  return;
//		  }
//		  System.out.println("로그인 성공");


		// 로그인 성공이면 true 반환
		// 로그인 실패하면 false를 반환하여 while문을 못돌리게 하여 진행하지 못하도록 혹은 다시 입력하세요 ㄱㄱ
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
				modifyBoard();
				break;
			case 3: // 삭제
				removeBoard();
				break;
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
		int no = nextSequence(); // Integer.parseInt(userMessage("글번호를 입력하세요"));
		String title = userMessage("제목을 입력하세요");
		String content = userMessage("내용을 입력하세요");
		String writer = userMessage("작성자를 입력하세요");

		// Board인스턴스 선언하고 값을 지정
		Board board = new Board(no, title, content, writer);
		// 배열에 저장
		boards[bno++] = board;
		System.out.println("글 추가 성공");
	} // end of addBoard

	/* 기능 */
	/*
	 * 글번호 제목 작성자 ======================== 1 날씨가 좋아요 홍길동 2 클래스 멋짐! 홍길동 3 자바어려움 박석민 4
	 * 그래도 열심히 김민규 ------------------------------- 상세보기: 글번호입력, 메뉴로 이동(q)
	 * -----------------------------
	 */

	// 글이 없다면
	// ** 등록된 글이 없습니다 **
	void boardList() {
//		sort();
		int page = 1; // 1페이지
		// while반복
		while (true) {
			int start = (page - 1) * 5; // 시작 번호
			int end = (page * 5); // 1페이지에서 마지막까지 보여줄 변수

			System.out.println("글번호     제목               작성자");
			System.out.println("=================================");
			for (int i = start; i < end; i++) { // 1페이지에서 5개만 보이게 끔 함
				if (boards[i] != null) {
					boards[i].showInfo();
				}
			}
			// 상세보기
			System.out.println("------------------------------------------------------");
			System.out.println("      상세보기: 글번호입력, 이전:p, 다음:n  메뉴로 이동:q      ");
			System.out.println("------------------------------------------------------");
			String str = scn.nextLine();
			// 메뉴 상세
			if (str.equals("q")) {
				break;
			} else if (str.equals("n")) {
				page++;
			} else if (str.equals("p")) {
				page--;
			}  else{
				int no = Integer.parseInt(str); // 글번호
				// 배열에서 조회
				Board sboard = getBoard(no);
				if (sboard == null) {
					System.out.println("조회결과 없습니다.");
					return;
				}
				sboard.showAllInfo();
			}
		}
		System.out.println();
	} // end of boardList

	// 수정
	void modifyBoard() {
		int bno = userMenu("수정할 글 번호 입력");
		Board result = getBoard(bno);
		if (result == null) {
			System.out.println("조회한 결과가 없습니다.");
			return;
		}
		String title = userMessage("수정할 제목 입력");
		result.setTitle(title);
		String content = userMessage("수정할 내용 입력");
		result.setContent(content);
		//
		System.out.println("수정완료.");
	} // end of modifyBoard

	// 삭제
	void removeBoard() {
		int bno = userMenu("삭제할 글 번호 입력");
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				boards[i] = null;
				System.out.println("삭제완료");
			}
		}
	} // end of removeBoard

	// 단건조회(getBoard)
	// 글번호를 활용해서 배열에서 조회하고 Board 반환.
	Board getBoard(int bno) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				return boards[i];
			}
		}
		return null; // 만약 조건에 맞는 글 번호가 없다면 null 반환
	}

	// <문자열> 사용자의 입력값을 반환(간편하게 사용하기 위해)
	String userMessage(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine(); // 사용자가 입력한 값을 반환
	}

	// <정수> 사용자의 입력값을 반환
	int userMenu(String msg) {
		System.out.print(msg + ">> ");
		return Integer.parseInt(scn.nextLine()); // 사용자가 입력한 값을 반환
	}

	// 순번생성
	int nextSequence() {
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && max < boards[i].getBoardNo()) {
				max = boards[i].getBoardNo();
			}
		}
		return max + 1;
	}
	
	// 정렬
	void sort() {
		Board temp = null;
		for (int j = 0; j < boards.length - 1; j++) {
			for (int i = 0; i < boards.length - 1; i++) {
				if (boards[i + 1] == null) {
					continue;
				}
				if (boards[i] == null) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
					continue;
				}
				if (boards[i].getBoardNo() < boards[i + 1].getBoardNo()) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
				}
			}
		}
	} // end of sort.
}