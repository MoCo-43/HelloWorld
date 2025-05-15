package com.yedam.condition;

public class IfExe {
	public static void main(String[] args) {
	  test2();
		
	}
		
	public static void test2() {
	/* 1 ~ 1000 사이의 임의의 값을 생성 후, 
       500을 기준으로 500보다 크면 "입력값보다 큽니다", 그 반대이면 "입력값보다 작습니다"라고 출력
       생성한 임의의 값이 정답이면 "정답입니다" 프로그램 종료
       시도한 횟수, "n번째에 정답을 맞추셨습니다." 문구 출력 */
	  while(true) {
		  int randomValue = (int) (Math.random() * 1000);
		  int count=0;
		  if (randomValue >= 500) {
			  System.out.println("입력값보다 큽니다.");
			  System.out.println(randomValue);
			  count++;
		  } else if (randomValue < 500) {
			  System.out.println("입력값보다 작습니다.");
			  System.out.println(randomValue);
			  count++;
		  } else if (randomValue == 567) {
			  System.out.printf("정답입니다. %d번째에 정답을 맞추셨습니다.", count);
			  break;
		  }
	  }
	}

	public static void test() {
		int score = 71;
		
		// if 문으로 변환
//		if (score >= 90) {
//           System.out.println("A학점");
//		} else if(score >= 80) {
//		   System.out.println("B학점");
//		} else if(score >= 70) {
//			System.out.println("C학점");
//		} else {
//			System.out.println("불합격");
//		}
		
		// switch case 문으로 변환
		score = score / 10; // ex) 95점을 9.5
		switch (score) {
		case 10:
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("불합격");
			break;
		} // end of switch
	}
}