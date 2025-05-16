package com.yedam.ref;

public class NullExe {
	public static void main(String[] args) {
      String str1 = "홍길동";
      String str2 = null;
      
//      System.out.println(str2.toString());
      
      // 배열
      int[] ary = {10, 20, 30}; // 변수선언과 초기화 // 정수만 넣을 수 있는 배열 
    //int ary[] = {10, 20, 30}; // 위와 동일 함
//      System.out.printf("ary배열의 크기 %d", ary.length);
      
      int[] intAry; // 변수선언
      intAry = new int[] {40, 50, 60}; // 값 할당
      
      // 첫번쨰 위치의 40 => 400 변경
      intAry[0] = 400;
//    intAry[3] = 400; // 인덱스 3 => 4번째 위치 // ArrayIndexOutOfBoundsException 에러 발생
      intAry[2] = 10; 
      
      // 배열은 선언하면 크기가 고정
      // 크기 변경을 하려면 새로 선언해야함
      // for 반복문
      for (int i = 0; i < 3; i++) {
    	  System.out.printf("[%d]번째의 값: %d\n",i, intAry[i]); 
      }
      
      intAry = new int[5];
      intAry[0] = 40;
      intAry[1] = 50;
      intAry[2] = 60;
      intAry[3] = 10;
      for (int i = 0; i < intAry.length; i++) {
    	  System.out.printf("intAry[%d]번째의 값: %d\n", i, intAry[i]);  
      }
      
      // 배열선언: double 타입  
      double[] dblAry={ 10.2, 23.2, 34.5 };
      for (int i = 0; i < dblAry.length; i++) {
    	  System.out.printf("dblAry[%d]번째의 값: %.1f\n", i, dblAry[i]);  
      }
      
      // 문자열 배열선언: String
      String[] strAry = new String[10]; // 10개의 값을 담는 배열 생성 // 빈 값은 NULL 
      for (int i = 0; i < strAry.length; i++) {
    	  System.out.printf("strAry[%d]번째의 값: %s\n", i, strAry[i]);
      }
  }
}

