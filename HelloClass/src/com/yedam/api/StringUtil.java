package com.yedam.api;

public class StringUtil {
	
	static String getGender (String ssn) {
		int pos = -1;// 성별 문자의 위치
		pos = ssn.length() -7;  // 14-7=7
		
		// 남/여 판별
		// charAt();
		//
		
		
		// return 
		
		
		/*
		 * 
		 * <<< 내가 한거 >>>>>
		 * 
		private String gender;
		
		public StringUtil() {}
		
		public StringUtil(String gender) {
			this.gender = gender;
		}

		public String getGender() {
			char g = gender.charAt(7);
			switch(g) {
			case '1':
			case '3':
				System.out.println("남자 입니다.");
				break;
			case '2':
			case '4':
				System.out.println("여자 입니다");
				break;
			}
			String gen = String.valueOf(g);
			return gen; 
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
		
		*/
		
		
		
		
	}
		
	
	static String getExtName(String files) {
		// . 값으로 자름
		// substring 및 인자값에 indexOf
		// return ext;
    }
	
	
	
	
	
	
	
	
	
	

	
	
	
}
