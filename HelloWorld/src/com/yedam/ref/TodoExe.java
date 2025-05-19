package com.yedam.ref;

import java.util.Scanner;

// p223 연습문제 6번
public class TodoExe {
	static Student[] scores = null;  // 학생점수저장
	public static void main(String[] args) {
		init();
		// 인스턴스 생성 후 코드 고침
		boolean run = true;  // 반복문 실행/종료
		int studentNum = 0;  // 학생수
		Scanner scanner = new Scanner(System.in);
		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 |5.종료");
			System.out.println("----------------------------------------------");
            System.out.println("선택>>>");
			int selectNo = Integer.parseInt(scanner.nextLine());
			// 배열의 선언없이 메뉴를 선택할 경우에는 NullPointer예외.
			if(selectNo == 2 || selectNo == 3 || selectNo == 4) {
				if (scores == null) {
					System.out.println("학생수를 지정하세요.");
					continue;
				}
			}
			
			if (selectNo == 1) {  // 학생수 지정
				System.out.println("학생수>> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new Student[studentNum];   // 배열의 크기지정
				
			} else if (selectNo == 2) {  // 점수입력
			    for (int i = 0; i < scores.length; i++) {
			        System.out.printf("students[%d] 이름>> ", i);
			        String name = scanner.nextLine();
			        System.out.printf("students[%d] 점수>> ", i);
			        int score = Integer.parseInt(scanner.nextLine());
			        System.out.printf("students[%d] 키>> ", i);
			        double height = Double.parseDouble(scanner.nextLine());
			        System.out.printf("students[%d] 성별>> ", i);
			        String gender = scanner.nextLine();
			        Gender gen = Gender.MALE;  // = Gender.MALE; 초기값으로 지정
			        if(gender.equals("남") || gender.equals("남자")) {  // 성별을 남 혹은 남자로 입력했을때 생성한 열거타입으로 입력되게 함
			        	gen=Gender.MALE;
			        } else if (gender.equals("여") || gender.equals("여자")) {
			        	gen=Gender.FEMALE;
			        }


			        // Student 인스턴스 생성 후 배열에 저장
			        Student student = new Student();
			        student.studentName = name;
			        student.score = score;
			        student.height=height;
			        student.gender=gen;
			        
			        scores[i] = student;  // 배열에 저장
			    }
			}
			else if (selectNo == 3) {
				// 배열의 합이 0이면 점수입력하세요.
				int sum = 0;
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i].score; // 점수 누적.
				}
				// 점수입력하도록 메세지 보여주기.
				if (sum == 0) {
					System.out.println("점수를 입력하세요.");
					continue;
				}
				// 성별 검색 기능 추가
				System.out.println("검색조건 ex)남 또는 여 >> ");
				String keyword = scanner.nextLine(); // "남", "여", "Enter"
				Gender gen = Gender.MALE;  // 초기화
		        if(keyword.equals("남") || keyword.equals("남자") ||   // 성별을 남 혹은 남자로 입력했을때 생성한 열거타입으로 입력되게 함
		        	keyword.equals("M") || keyword.equals("Man")) {
		        	gen=Gender.MALE;
		        } else if (keyword.equals("여") || keyword.equals("여자") ||
		        	keyword.equals("W") || keyword.equals("Women")) {
		        	gen=Gender.FEMALE;
		        }
				// "이름, 점수, 키" 출력.
				for (int i = 0; i < scores.length; i++) {
					// 입력했던 값이 공백이거나(남녀 상과없이 다 보여주겠다는 의미) 혹은 남 또는 여	라고 입력이 되면
					if(keyword.equals("") || gen == scores[i].gender) {
						System.out.printf("scores[%d]> 이름:%s, 점수:%d, 키:%.1f, 성별:%s\n", i, scores[i].studentName, scores[i].score, scores[i].height, scores[i].gender);
					}
				}
			} else if (selectNo == 4) { // 분석(최고점수, 평균)
				int max = 0, sum = 0; // 최고점수, 합계 변수선언.
				double avg = 0; // 평균 변수 선언.
				Student maxStd = new Student(); // 최고점수를 받은 학생의 정보를 저장.
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i].score; // 점수 누적.
					if (max < scores[i].score) {
						max = scores[i].score;
						maxStd.score = scores[i].score;
						maxStd.studentName = scores[i].studentName;
						maxStd.height=scores[i].height;
						maxStd.gender=scores[i].gender;
					}
				}
				avg = 1.0 * sum / scores.length;
				System.out.printf("학생이름:%s, 최고점수: %d, 키: %.1f, 평균점수: %.2f, 성별:%s\n", maxStd.studentName, maxStd.score, maxStd.height, maxStd.gender, avg);


			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
		scanner.close();
	}

	public static void init() {
		  Student s1 = new Student();
	      s1.studentName="홍길동";
		  s1.score=80;
		  s1.height=170.0;
//		  s1.gender="남";
		  s1.gender=Gender.MALE; // 올수 있는 데이 타입이 Gender enum에 의해 결정 됨

	      Student s2 = new Student();
		  s2.studentName="김민선";
		  s2.score=85;
		  s2.height=165.7;
//		  s2.gender="여";	  
		  s2.gender=Gender.FEMALE;
		  
	      Student s3 = new Student();
		  s3.studentName="박철민";
		  s3.score=90;
		  s3.height=180.3;
		  s3.gender=Gender.MALE;
		  
		  // 초기데이터
		  scores=new Student[] { s1, s2, s3 };
		}	
	
	
	
	
	// 바꾸기 이전
//	public static void test1() {
//		boolean run = true;
//		int studentNum = 0;
//		int[] scores = null;
//		Scanner scanner = new Scanner(System.in);
//
//		while (run) {
//			System.out.println("----------------------------------------------");
//			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 |5.종료");
//			System.out.println("----------------------------------------------");
//			System.out.println("선택>>>");
//			int selectNo = Integer.parseInt(scanner.nextLine());
//            // 배열의 선언없이 메뉴를 선택할 경우에는 NullPointer예외
//			if (selectNo == 2 || selectNo == 3 || selectNo == 4) {
//				if (scores == null) {
//					System.out.println("학생수를 지정하세요.");
//					continue;
//				}
//			}
//			// 배열의 선언없이 메뉴를 선택할 경우에는 NullPointer예외
//			if (selectNo == 1) { // 학생수 지정
//				System.out.println("학생수>> ");
//				studentNum = Integer.parseInt(scanner.nextLine());
//				scores = new int[studentNum]; // 배열의 크기지정
//
//			} else if (selectNo == 2) { // 점수입력
//				if (scores == null) {
//					System.out.printf("학생수를 지정하세요");
//					continue;
//				}
//				for (int i = 0; i < scores.length; i++) {
//					System.out.printf("scores[%d]", i);
//					scores[i] = Integer.parseInt(scanner.nextLine());
//				}
//
//			} else if (selectNo == 3) {
//				for (int i = 0; i < scores.length; i++) {
//					System.out.printf("scores[%d]> %d \n", i, scores[i]);
//				}
//
//			} else if (selectNo == 4) {
//				int max = 0, sum = 0;
//				double avg = 0;
//				Student maxStd;  // 최고점수를 받은 학생의 정보를 저장
//				for (int i = 0; i < scores.length; i++) {
//					sum += scores[i].scores; // 점수누적
//					if (max < scores[i].scores) {
//						max=scores[i].scores;
//						maxStd.score=scores[i].scores;
//						maxStd.studentName = scores[i].studentName;
//					}
//				}
//				avg = 1.0 * sum / scores.length; // 실수타입 연산
//				System.out.printf("최고점수: %d\n평평균점수: %.2f", max, avg);
//
//			} else if (selectNo == 5) {
//				run = false;
//			}
//		}
//		System.out.println("프로그램 종료");
//	}
	

}
