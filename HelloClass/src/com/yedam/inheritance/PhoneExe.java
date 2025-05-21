package com.yedam.inheritance;

public class PhoneExe {
	public static void main(String[] args) {

		// 부모클래스
		CellPhone phone1 = new CellPhone();
		phone1.model = "IT203";
		phone1.color = "red";
		phone1.powerOn();
		phone1.powerOff();
		System.out.println(phone1.toString());

		// 자식클래스
//		SmartPhone phone2 = new SmartPhone();
		CellPhone phone2 = new SmartPhone(); // (1) CellPhone 이 부모이므로 사용은 가능하다
		phone2.model = "S21";
		phone2.color = "white";
		phone2.powerOn();
		phone2.powerOff();

		// (1) 사용할수 있는 기능들은 부모 클래스의기능만 사용할 수 있다.
//		phone2.channel = 3;
//		phone2.watch();

		SmartPhone phone3 = (SmartPhone) phone2; // (2) Casting
		// (2) Casting을 통해 사용 가능
		phone3.watch();
		phone3.channel = 3;

		// (3) instanceof 매소드를 변환가능한지 체크
		// phone1은 SmartPhone instance가 아니어 false 이므로 작동하지 않음
		if (phone1 instanceof SmartPhone) {
			phone3 = (SmartPhone) phone1;
			phone3.channel = 3;
			phone3.watch();
		}

		// (4) instanceof 매소드를 사용하면 true가 나옴
		if (phone2 instanceof SmartPhone) {
			phone3 = (SmartPhone) phone2;
			phone3.channel = 2;
			phone3.watch();
		}
	}
}
