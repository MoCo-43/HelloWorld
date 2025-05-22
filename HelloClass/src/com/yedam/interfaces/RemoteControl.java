package com.yedam.interfaces;
/*
 * 인터페이스: 필드(상수)  한번 설정하면 바꾸지 못함
 */
public interface RemoteControl {
  public int MAX_VOLUME = 10;
  
  // 추상메소드
  public abstract void turnOn();  // abstract 안붙여도 적용됨
  public void turnOff();  // 마찬가지로 추상메소드 적용 됨
}
