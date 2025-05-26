package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.api.Member;

/*
 * 인덱스를 사용해서 객체를 관리
 * 순서를 가지고 중복된 값 가능
 */

public class ListExe {
	public static void main(String[] args) {
		List<Student> numbers = new ArrayList<>();
		// 10 ~ 100점 점수를 임의의 값으로 생성. 점수 10개 생성
		for (int i = 1; i <= 10; i++) {
			int score = (int) (Math.random() * 91) + 10;
			numbers.add(new Student(1000 + i, score));
		}

		// 10개의 점수의 합, 평균 출력.
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i).getScore(); // Student(no, score)
		}

		avg = 1.0 * sum / numbers.size();
		System.out.printf("정수의 합: %d, 평균 %.1f\n", sum, avg);

//      
//	  int score = 0;
//	  score = (int) (Math.random() * 90) + 10;
//
//	  int sum = 0;
//	  List<Integer> numbers = new ArrayList<Integer>();
//	  
//      for (int i = 0; i < 10; i++) {
//    	  numbers.add(i, score);
//      }
//      System.out.println(numbers);
	}

	public static void exe2() {

		List<Member> members = new ArrayList<>();
		Member member = new Member("홍길동", 10);

		members.add(new Member("김홍동", 20));
		members.add(member);
		members.add(new Member("김홍동", 30));

		// 삭제
//      members.remove(member);

		String search = "김홍동";
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).memberName.equals(search)) {
				members.remove(i);
			}
		}

		// 목록 출력
		for (int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).toString());
		}
	}

	public static void exe1() {

		// 인터페이스 -구현클래스
		List<String> list = new ArrayList<String>(); // (generic) 처음부터 데이터타입 지정

		// 추가
		list.add("10");
		list.add(new String("Hello"));

		// 특정위치에 추가 (배열위치, 추가값)
		list.add(1, "20");

		// 삭제
		list.remove(0); // 특정위치 데이터 제거 가능

		//
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// 변경
		list.set(1, "World");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

//			for(Object item : list) {
//				System.out.println(item);
//			}

	}

}