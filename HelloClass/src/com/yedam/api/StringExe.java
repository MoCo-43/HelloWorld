package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
      String str1 = new String("Hello");
//      str1 = new String(new byte[] {72, 101, 108, 108, 111}, 0, 2);
      
      System.out.println(str1.charAt(1));  // 문자 캐릭터 타입 지정했을때 몇번째가 나온다는걸 알려줌
      System.out.println(str1.indexOf("o"));  // 해당하는 문자 있으면 몇번 위치인지 알려줌
      CharAt();
      Equals();
      StringGetBytesExe();
	}
	
	public static void CharAt() {
      String ssn = "010624-4230123";
      char sex = ssn.charAt(7);  // 8번째 문자열
      switch (sex) {
      case '1':
      case '3':  // '1' , '3' 이면 
    	  System.out.println("남자 입니다.");
    	  break;
      case '2':
      case '4': // '2' , '4' 이면 
    	  System.out.println("여자 입니다.");
    	  break;
      }
	}
	
	public static void Equals() {
		String strVar1 = new String("신민철");
		String strVar2 = "신민철";
		
		if(strVar1 == strVar2) {
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("같은 문자열을 가짐");
		} else {
			System.out.println("다른 문자열을 가짐");
		}
	}
	
	public static void StringGetBytesExe() {
		String str = "안녕하세요";
		
		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length: " + bytes1.length);
		String str1 = new String(bytes1);
		System.out.printf("bytes1->String: ", str1);
	}
}
