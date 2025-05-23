package com.yedam.api;

public class WrapperExe {
	public static void main(String[] args) {
		int num = 10;
		

		Integer num2 = 20;               //new Integer(20);  // 참조 데이터 타입
		num = num2.intValue();
		
		String str = "10";
		num = Integer.parseInt(str);
		
		double num3 = Double.parseDouble(str);
		num3 = Float.parseFloat(str);
		
		Integer num4 = new Integer(10); // 기본타입 -> 참조타입 (박싱)
		Integer num5 = 10;  // 참조타입 -> 기본타입 (언박싱)
		System.out.println(num4 == num5);  // 값은 같으나 메모리주소로 계산하여 다른 위치여서 false
		System.out.println(num4.intValue() == num5.intValue());  // 박싱결과 값이 같으므로 true
		
	}
}
