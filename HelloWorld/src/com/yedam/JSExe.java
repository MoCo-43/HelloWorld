package com.yedam;

public class JSExe {
	public static void main(String[] args) {
      test();
<<<<<<< HEAD

=======
      // 임의의 수를 생성 1 ~ 100사이의 임의의 값을 생성
>>>>>>> branch 'master' of https://github.com/MoCo-43/HelloWorld.git
      int sum = 0;
      for (int i =0; i<=5; i++) {
<<<<<<< HEAD
    	  int result = (int) (Math.random() * 10) + 1; // 1 <= x < 11   // 임의의 수 1 ~ 10사이의를 생성
=======
    	  int result = (int) (Math.random() * 100) + 1; // 1 <= x < 11
>>>>>>> branch 'master' of https://github.com/MoCo-43/HelloWorld.git
    	  sum+=result;
    	
      }
      System.out.println("결과 : " + sum);
	} // end of main

	public static void test() {
		int sum = 0;
		// 1 ~ 10 까지의 누적
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println("결과 : " + sum);
	} // end of test
} // end of class
