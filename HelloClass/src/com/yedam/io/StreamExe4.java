package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * 객체 입출력 스트림
 * 기본타입 - 참조타입
 * 
 * int num = 10;
 * Member member = new Member();
 * 
 * 직렬화(Serialization) -> 객체를 기본타입으로 변경
 *   - Serializable 인터페이스 구현한 클래스에서만 가능
 *   - 구성하는것이아닌 표시?
 *   
 * 역직렬화(Deserialization) -> 기본타입을 객체로 변환
 *   - 출력스트림에서 구현 가능
 */
class Product implements Serializable {  // 직렬화를 구현하기위해 Product뒤에 인터페이스 구현
	String prodCode;

	public Product(String prodCode) {
		this.prodCode = prodCode;
	}
}

public class StreamExe4 {
	public static void main(String[] args) {
	  // 역직렬화
	  try {  // 기본 -> 객체
		InputStream is = new FileInputStream("c:/temp/object.db");
		ObjectInputStream ois = new ObjectInputStream(is);

		List<Product> list = (List<Product>) ois.readObject();  // ClassNotFoundException 에러가 남 => 그러므로 list collection의 Product를 가진 타입으로 casting
		for(Product product : list) {
			System.out.println("상품코드 : " + product.prodCode);
		}
	} catch (Exception e) {  // exception에서 나오는 모든것들을 처리 함
		e.printStackTrace();
	}
	  
        System.out.println("end of prog.");
	}
	
	  public void serial() {
			// 직렬화
			List<Product> list = new ArrayList<>();  // 직렬화를 구현하기 위한 리스트
			list.add(new Product("P001"));
			list.add(new Product("P002"));
	        try {
				// 기본스트림
	        	OutputStream os = new FileOutputStream("c:/temp/object.db");
	        	// 객체 입출력 보조스트림
				ObjectOutputStream oos = new ObjectOutputStream(os);
				
				oos.writeObject(list);  // 객체를 출력스트림(object.db)에 전달  // 객체 -> 기본타입으로 변환
				oos.close();
				os.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}

