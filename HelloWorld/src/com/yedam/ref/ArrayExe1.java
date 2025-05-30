package com.yedam.ref;

// 교수님 gitHub link 250516까지 했는 코드 올림
// 과제는 교재 p223 6번
// github.com/changholee2010
public class ArrayExe1 {
	// field , method 선언문만 구현 가능

	public static void main(String[] args) {
		ary_test();
//		intAry();
//		test3();
//		test5();
//		test6();
//		test6_1();
		
	} // end of main

    public static void ary_test() {
    	// Math.random 활용해서 10 ~ 100 사이의 점수 생성
    	// 학생 10명의 점수를 생성해서 학생점수의 평균을 구하고 최고점수가 몇점인지를 구하기
    	// scoreAry 변수명

    	int[] scoreAry = new int[10];
    	
    	for(int i=0; i<scoreAry.length; i++) {
    	  int rand = (int) ((Math.random() * 90) + 10); 
    	  scoreAry[i]=rand;
    	}
    	
    	// 학생점수 평균
		int sum = 0;
		int cnt = 0;  // 횟수
		for (int i = 0; i < scoreAry.length; i++) {
			sum += scoreAry[i];
			cnt++;
			System.out.printf("i: %d 값: %d\n", i, scoreAry[i]);
		}
		double avg = 1.0 * sum / cnt;
		System.out.printf("평균 : %.1f\n", avg);
		
		// 최고점수의 학생
		int temp=0;
		for(int j= 0; j < scoreAry.length -1; j++) {
		  for (int i=0; i < scoreAry.length -1; i++) {	
			  // 큰값기준으로 위치변경
			  if(scoreAry[i] < scoreAry[i+1]) {
				  temp = scoreAry[i];
				  scoreAry[i] = scoreAry[i+1];
				  scoreAry[i+1] = temp;
			}
		  }
		}
        for (int i = 0; i < scoreAry.length; i++) {
        System.out.printf("최고점수 값: %d\n", scoreAry[i]);
        }
	    
	    
  }

	public static void intAry() {
		// int배열 => intAry : 10, 17, 22, 31, 55, 24
		int[] intAry = { 10, 17, 22, 31, 55, 24 };


    
        
		
		
		
		// 합
//		int sum = 0;
//		for (int i = 0; i < intAry.length; i++) {
//			sum += intAry[i];
//			System.out.printf("sum: %d, i: %d 값: %d\n", sum, i, intAry[i]);
//		}

		
		
		
		
		// 합2
		// 특정 인덱스 합을 구해 보기
		// 0번, 2번 4번 일때만 합 구하기
//		int sum = 0;
//		for (int i = 0; i < intAry.length; i+=2) {
//			sum += intAry[i];
//			System.out.printf("sum: %d, i: %d 값: %d\n", sum, i, intAry[i]);
//		}
//	}
		
		
		
		
		
		// 합3
		// 짝수인덱스만 합 구하기
//		int sum = 0;
//		for (int i = 0; i < intAry.length; i++) {
//		    if(intAry[i] % 2 == 0) {
//			sum += intAry[i];
//			System.out.printf("sum: %d, i: %d 값: %d\n", sum, i, intAry[i]);
//		    }
//		}

		
		
		// 평균
		// 짝수 인덱스 번호 평균 내기
//		int sum = 0;
//		int cnt = 0;  // 횟수
//		for (int i = 0; i < intAry.length; i++) {
//		    if(intAry[i] % 2 == 0) {
//			sum += intAry[i];
//			cnt++;
//			System.out.printf("sum: %d, i: %d 값: %d\n", sum, i, intAry[i]);
//		    }
//		}
//		double avg = 1.0 * sum / cnt;
//		System.out.printf("평균 : %.1f\n", avg);

		
		
		// 배열안 최고값 구하기
//		int max = 0;
//		for (int i=0; i<intAry.length; i++) {
//			if(intAry[i] > max) {
//				max=intAry[i];
//			}
//		}
//		System.out.printf("배열안 최고값 : %d", max);

		
		
		// 배열의 위치 정렬
		// 오름차순
//		int temp=0;
//		for(int j= 0; j < intAry.length -1; j++) {
//		  for (int i=0; i < intAry.length -1; i++) {	
//			  // 큰값기준으로 위치변경
//			  if(intAry[i] < intAry[i+1]) {
//				  temp = intAry[i];
//				  intAry[i] = intAry[i+1];
//				  intAry[i+1] = temp;
//			}
//		  }
//		}
//        for (int i = 0; i < intAry.length; i++) {
//        System.out.printf("i: %d 값: %d\n", i, intAry[i]);
//        }

		
		
        // 배열의 위치 정렬 2
        // 내림차순
		int temp=0;
		for(int j= 0; j < intAry.length -1; j++) {
		  for (int i=0; i < intAry.length -1; i++) {	
			  // 큰값기준으로 위치변경
			  if(intAry[i] > intAry[i+1]) {
				  temp = intAry[i];
				  intAry[i] = intAry[i+1];
				  intAry[i+1] = temp;
			}
		  }
		}
        for (int i = 0; i < intAry.length; i++) {
        System.out.printf("i: %d 값: %d\n", i, intAry[i]);
        }
	}

	
	
	
	// 교재 P183 문제풀어보기
	public static void test5() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i >= j) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	public static void test6() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if ((i + j) >= 5) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(); // 줄바꿈
		}
	}

	public static void test6_1() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if ((j + i) <= 5) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void test3() {
		while (true) {
			int dice1 = (int) (Math.random() * 5) + 1;
			int dice2 = (int) (Math.random() * 5) + 1;
			System.out.printf(" (%d, %d)", dice1, dice2);
			if (dice1 + dice2 == 5) {
				break;
			}
		}
	}

} // end of class
