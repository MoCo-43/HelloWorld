package com.yedam.interfaces;

//import com.yedam.inheritance.CellPhone;

public class InterfaceExe {
public static void main(String[] args) {
	final int num = 10;  // 상수 const
//	num = 30;
	// 인터페이스의 변수에 구현클래스의 인스턴스를 할당
//	CellPhone phone = new SmartPhone();
	
	//            아래구성
	// 인터페이스          구현 클래스
	RemoteControl rc = new Television();
	rc.turnOn();
	rc.turnOff();
	
	// 매개값, 필드 ... 다형성
	rc = new Radio();
	rc.turnOn();
	rc.turnOff();
  }
}