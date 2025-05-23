package com.yedam.api;

public class SystemExe {
	public static void main(String[] args) {
		//
		
		long now = System.currentTimeMillis();
		System.out.println(now);
		// 1747964880815 => "초" = > 몇일, 몇시간, 몇분, 몇초 계싼해보기
		//  60 * 60 * 24  => 1일
		//  60 * 60 => 1시간
		//  60 => 분
		//  나머지가 초
		// 계산
		
//		long time = 1747964906;  // 초 단위의 현재 시간
//		long now_years = time % (60 * 60 * 24 * 365);  // 년 계산
//		
//		long now_day = time % (60 * 60 * 24 * 365); // 일
//		now_day = now_day/(60 * 60 * 24);
//		
//		long now_hour = time % (60 * 60 * 24); // 시간
//		now_hour = now_hour / (60 * 60);
//		long now_min = time % (60 * 60);  // 분
//		long now_sec = time % 60;  // 초
//		
//		System.out.printf("%d의 시간은 %일, %d시간, %분, %d초 입니다", time, now_day, now_hour, now_min);
//		
	}

	public static void exe() {

		long start = System.nanoTime(); // System.currentTimeMillis();
		int sum = 0;
		for (int i = 0; i < 100000000; i++) {
			sum += i;
		}
		long end = System.nanoTime();
		System.out.printf("합계 %d, 걸린시간 %d\n", sum, (end - start));

	}
}
