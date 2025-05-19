package com.yedam.ref;
/*
 * 기존부터 계속 배웠던건 => 배열 + 기본타입: 정수, 실수
 * 지금부터 배워볼껀 => 배열 + 참조타입(클래스): 학생이름, 점수 와 같은 형태를 저장할수 있는 무언가를 만들어 볼 꺼임
 */
public class ArrayExe3 {
	// class 에서 변수 선언 ( init() 참고)
	static Student[] stdAry;

	public static void main(String[] args) {
	  init();
	  int sum = 0;
	  double max = 0;
	  Student maxStd = new Student();  // 인스턴스 생성을 하여 최고학생 최고점수 평균 한번에 표현
		// 배열의 값을 출력
		for(int i = 0; i<stdAry.length; i++) {
		  System.out.printf("이름:%s 점수:%d \n", stdAry[i].studentName, stdAry[i].score);
		  sum+=stdAry[i].score;
		  // 최고점수, 최고점 사람
		  if (max < stdAry[i].height) { // 가장 큰키, 키큰 흑생
				max=stdAry[i].height;
				maxStd.studentName = stdAry[i].studentName;
				maxStd.score = stdAry[i].score;
				maxStd.height = stdAry[i].height;
				maxStd.gender = stdAry[i].gender;
		  }
		}
		// 평균 구하기
		double avg = 1.0 * sum / stdAry.length;
		String strFmt = "키큰학생: %s, 점수: %d, 키:%.1f, 평균 %.2f";  // strFmt를 사용하여 다음 printf "" 열 안에 대신 대입
		System.out.printf(strFmt, maxStd.studentName, maxStd.score, maxStd.height, avg);
	}
	
	// stdAry 안에 데이터 담기
	public static void init() {
	  Student s1 = new Student();
      s1.studentName="홍길동";
	  s1.score=80;
	  s1.height=170.0;
	  s1.gender="남";

      Student s2 = new Student();
	  s2.studentName="김민선";
	  s2.score=85;
	  s2.height=165.7;
	  s2.gender="여";	  
	  
      Student s3 = new Student();
	  s3.studentName="박철민";
	  s3.score=90;
	  s3.height=180.3;
	  s3.gender="남";
	  
	  // student를 담는 stdAry배열을 지정
//	  stdAry = new Student[] { s1, s2, s3 };  // 배열에 값을 할당
	}
	
	
	// 인스턴스 생성 후 직접 추가 및 편집 
	public static void test() {		
		// 홍길동, 80 생성
		Student s1 = new Student();  // 인스턴스 생성
		s1.studentName="홍길동";
		s1.score=80;
		
		// 김민규, 85 => s2에 담기
		Student s2 = new Student();
		s2.studentName="김민규";
		s2.score=85;
		
		// 홍길동의 점수를 90으로 변경
		s1.score = 90;
		
		// 학생정보를 배열에 저장
		Student[] students= { s1, s2 };
		students[0].studentName="홍길도";
		
		System.out.printf("이름: %s, 점수: %d\n",s1.studentName, s1.score);
	}
}
