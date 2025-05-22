package com.yedam.interfaces;
/*
 * 클래스(Television)는 RemoteControl 인터페이스를
 * 상속이라 하지 않고, 구현 클래스라고 함
 * 
 * 상속과 비슷할 수 있으나 다름 (extends 대신 implements)
 * 
 */
public class Television implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("텔레비젼을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("텔레비젼을 끕니다.");
	}
	
	

}
