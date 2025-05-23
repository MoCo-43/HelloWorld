package com.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class ObjectExe {
	public static void main(String[] args) {
	    // 기존에 배열을 통해 저장 => 불편함
		// 배열[여러건 저장] => 컬렉션(1. List 2.Set 3. Map)
		int[] ary = new int[5];
		
		// 확장된 for
		for(int num : ary) {
			System.out.println(num);
		}
		
		// Set컬렉션
		// 배열을 대신해서 사용 할수 있음
		// 중복된 값을 허용 X
		// 저장순서 X
		Set<Integer> set = new HashSet<Integer>();
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(10);
		
		// 선언하는 클래스 Member
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 10));  //(1) 논리적으로는 같은 값이나, 서로 다른 위치에 있으므로 다른값으로 판단
		members.add(new Member("김민석", 12));
		members.add(new Member("홍길동", 10));  //(1) 논리적으로는 같은 값이나, 서로 다른 위치에 있으므로 다른값으로 판단
		
		for(Member num : members) {
			System.out.println(num.toString());
		}
		
	}
	
	
	
	
	public static void exe1() {
		int num1 = 10, num2 = 10;
		System.out.println(num1 == num2); // true

		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1 == str2); // false 메모리 주소값을 비교
		System.out.println(str1.equals(str2)); // true

		Member mem1 = new Member(); // 인스턴스의 주소를 비교
		mem1.memberName = "홍길동";
		mem1.age = 10;

		Member mem2 = new Member(); // 인스턴스의 주소를 비교
		mem2.memberName = "홍길동";
		mem2.age = 10;

		System.out.println(mem1.equals(mem2)); // false
	}
}