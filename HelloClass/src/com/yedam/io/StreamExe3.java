package com.yedam.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import com.yedam.collection.Student;

/*
 * 학생(추가, 수정, 삭제, 목록) -> c:/temp/studentList.txt에 저장
 * add(추가: 이름, 점수입력)
 * modify(수정: 이름을기준으로 점수를 수정)
 * remove(삭제: 이름)
 * list(목록)
 * 종료 시 저장
 */

public class StreamExe3 {
	static Scanner scn = new Scanner(System.in); // 정적필드
	static List<Student> studentList = new ArrayList<>(); // 컬렉션

	public static void main(String[] args) {

		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			// 파일의 끝부분에서 더 이상 읽을 값이 없음
		}

		boolean run = true;
		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:  // 추가
				add();
				break;
			case 2:  // 수정
				modify();
				break;
			case 3:  // 삭제
//				remove();
				break;
			case 4:  // 목록
//				list();
				break;
			case 5:  // 종료
				run = false;
				save();
			}
		} // end of while
		System.out.println("end of prog.");
	} // end of main

	// 추가 add();
	static void add() {
		System.out.print("학생번호: ");
		String sno = scn.nextLine(); // (1)문자열
		System.out.print("점수: ");
		String score = scn.nextLine(); // (1)문자열 (1) => 모두 int 정수형으로 교체해야 함
		Student student = new Student(Integer.parseInt(sno), Integer.parseInt(score)); // Student Class 생성자 참고하면  // Student(int e, int e) 형태 
		if (studentList.add(student)) {
			System.out.println("저장완료");
		}
	}

	
	
	// 수정 modify();
	static void modify() {
		System.out.print("학생번호: ");
		int sno = scn.nextInt(); // Int타입으로 바로 받아올수 있음
		System.out.print("점수: ");
		int score = scn.nextInt();  // score를 입력후 enter키 값이 같이 처리 됨.
		scn.nextLine();  // 그러므로 nextLine()을 넣어주어 enter값을 따로 처리 해 주어 메뉴의 int menu값으로 넘어감?
		System.out.print("학생번호: ");
		// 컬렉션에서 검색
		for(int i=0; i<studentList.size(); i++) {
		  if(studentList.get(i).getStudentNo() == sno) {  // studentList에서 배열 i번째에  sno와 일치하는 학생번호가 있냐는 조건?
			 studentList.get(i).setScore(score);
			 System.out.println("수정 완료");
		  }
		}
	} // end of modify

	
	
	// 저장 save();
	static void save() {
		// 문자기반의 출력스트림
		try {
			Writer writer = new FileWriter("c:/temp/studentList.txt");
			// 1001 70 (학생번호 점수)
			for (Student student : studentList) {
				String txt = student.getStudentNo() + " " + student.getScore() + "\n";
				writer.write(txt); // 한 라인씩 write함
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end of save

	
	
	// 초기화 init();
	// try catch 대신 사용 throws
	// 예외시 책임을 떠 넘김?
	static void init() throws IOException, NoSuchElementException {
	  Scanner scan = new Scanner(new File("c:/temp/studentList.txt"));
	  while(true) {		  
		  String txt = scan.nextLine();
		  String[] strAry = txt.split(" ");  // 1001 70 공란을 기준으로 구분 (첫번째 배열) | (두번쨰 배열)
		  // StudentList컬렉션에 추가 strAry[0]
		  studentList.add(new Student(Integer.parseInt(strAry[0]), Integer.parseInt(strAry[1]) ) );
	  }
	  
	}
}
