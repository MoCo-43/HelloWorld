package com.yedam.api;

public class MathExe {
	public static void main(String[] args) {
      // 절대값
	  System.out.println(Math.abs(-100));
      
	  
	  // 올림, 버림
	  System.out.println(Math.floor(12.3));  // 소수점 버림
	  System.out.println(Math.ceil(12.3));  // 올림
	  System.out.println(Math.round(12.3));  // 반올림
	  
	  // 크기비교
	  System.out.println(Math.max(Math.ceil(12.3), Math.floor(12.3)));  // 가장 큰 값 출력
	}
}