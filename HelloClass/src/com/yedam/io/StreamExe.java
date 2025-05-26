package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * + 보조 스트림 내용추가
 */

public class StreamExe {
	public static void main(String[] args) {
		
		// 보조스트림
		// original2.PNG (1.5M) -> copy3.PNG
		try {
			InputStream is = new FileInputStream("c:/temp/original2.jpg");
			OutputStream os = new FileOutputStream("c:/temp/copy3.jpg");
			// 보조스트림에 연결
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			// 읽기, 쓰기
			while (true) {
				int data = bis.read(); // 읽기
				if (data == -1) { // 읽을 파일이 없을때
					break;
				}
				bos.write(data);
			}
			bos.close();  // 사용한 스트림 전부 닫아주기
			bis.close(); 
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end of prog");
	} // end of main

	// 복사
	public static void copy() {
		// 입력 -> 출력
		try {
			// 입력스트림(original.png)
			// 1MB => 1,000,000 바이트
			InputStream is = new FileInputStream("c:/temp/nvidia_ceo.jpg");
			// 출력스트림(copy.png)
			OutputStream os = new FileOutputStream("c:/temp/copy_2.jpg");
			// 한번에 읽기쓰기 byte[] 만큼 한번에 처리
			byte[] buf = new byte[10];
			long start = System.currentTimeMillis(); // 시작시점
			while (true) { // 1바이트 읽고 쓰기를 계속 더이상 읽을 파일이 없을때 까지.
				int data = is.read(buf); // 읽기
				if (data == -1) { // 더이상 읽을 파일이 없을때 라는 조건
					break;
				}
				os.write(buf); // 쓰기
			}
			os.close();
			is.close();
			long end = System.currentTimeMillis(); // 종료시점
			System.out.println("걸린시간: " + (end - start));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void read() {
		// 입력(파일) = 바이트 기반
		try {
			InputStream is = new FileInputStream("c:/temp/os1.yedam.db");
			// read() 1바이트씩 읽기 -1 반환
			while (true) {
				int data = is.read();
				if (data == -1) {
					break;
				}
				System.out.println(data);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write() {
		try {
			OutputStream os = new FileOutputStream("c:/temp//os1.yedam.db");
			// 출력(파일) = 바이트 기반
			byte b1 = 10;
			byte b2 = 20;
			byte b3 = 30;
			os.write(b1);
			os.write(b2);
			os.write(b3);
			os.close();
		} catch (IOException e) { // 파일이 없을때 나는 에러 try catch 문 적기
			e.printStackTrace();
		}
	}
}
