package com.yedam.board;
/*
 * User: 아이디, 비밀번호, 이름
 * 
 */
class user{
	
	private String userId;
	private String passWd;
	private String userName;
	
	// 생성자
	public user(String userId, String passWd, String userName) {
		this.userId = userId;
		this.passWd = passWd;
		this.userName = userName;
	}

	// getter
	public String getUserId() {
		return userId;
	}


	public String getPassWd() {
		return passWd;
	}


	public String getUserName() {
		return userName;
	}
	
	
}
public class UserExe {
  static user[] users = { 
		  new user("holy", "1111", "김영광"),
		  new user("cutie", "2222", "홍예쁨"),
		  new user("guest", "3333", "밤손님")
  };
  

  // 아이디, 비밀번호 => 이름 비밀번호를 매개값으로 받고 참 거짓으로 반환
  static boolean login(String uname, String passwd) {
	  // 직접 만들기
	  for(int i=0; i<users.length; i++) {		  
		  if(users[i].getUserId().equals(uname) && users[i].getPassWd().equals(passwd)) {
			  return true;
		  }
	  }
	  return false;
  }
}