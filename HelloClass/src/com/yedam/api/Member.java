package com.yedam.api;

public class Member {
  public String memberName;
  public int age;
  
  public Member() {}
  
  public Member(String memberName, int age) {
	  this.memberName = memberName;
	  this.age = age;
  }
  
  // hashCode() 중복된 값 추가 안하게 하는거?
  @Override
	public int hashCode() {
	  return age;
	}
  
  
  // 이름, 점수 => 같으면 논리적동등한건지 구조 체크
  // 메모리 주소가 달라 무조건 false 이나 override를 통해 재정의
  
  @Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {  // 매개값의 유형이 Member임
			Member member = (Member) obj;
			return this.memberName == member.memberName
			     && this.age == member.age;
		}
	  return false;
	}
  
  // toString() 재정의
  @Override
	public String toString() {
      return "이름: " + memberName + ", 나이: "+ age;
	}
}
