package com.yedam.inheritance;

/*
 * 부모 : CellPhone
 *    - 전원켜기, 전원끄기, 볼륨Up, 볼륨Down, 통화
 *    - Model, Color
 * 자식 : SmartPhone
 *    - TV 보기
 *    - 
 * 
 */

public class CellPhone /* extends Object */{ // Object 없다라도 있는 척
	String model;
	String color;

	// 생성자
	public CellPhone() {};
	public CellPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	// 메소드
	public void powerOn() {  // 부모 클래스가 public 이면 자식도 최소한 public 접근제어
		System.out.println("전원을 켜기");
	}

	public void powerOff() {
		System.out.println("전원을 끄기");
	}

	public void 통화하기() {
		System.out.println("통화하기");
	}

	// toString() 오버라이딩
	@Override
	public String toString() {
		return "CellPhone [model=" + model + ", color=" + color + "]";
	}
}
