package com.yedam.common;

import lombok.*;
/*
 * DTO(Data Transfer Object)
 * 
 */
@Data
public class PageDTO {
  // 게시글 건수 -> 페이지 계산
	private int start, end, currentPage;
	private boolean prev, next;
	
	// 현재페이지 및 전체카운트?
	public PageDTO(int page, int totalCnt) {
	  	this.currentPage = page;  // ex> 현재 페이지가 3페이지라고 가정했을때
	  	this.end = (int) Math.ceil(1.0 * page / 10) * 10;  // 마지막페이지 계산
	  	this.start = this.end - 9;  // 시작페이지 계산
	  	
	  	// 마지막페이지 계산이 제대로 안되어, 실제 마지막페이지 계산하는 코드
	  	int realEnd = (int) Math.ceil(1.0 * totalCnt / 5);  // 건수를 기준으로 실제 마지막페이지
	  	this.end = this.end > realEnd ? realEnd : this.end;
	  	
	  	// 이전, 이후 페이지의 존재 체크
	  	this.prev = this.start > 1;
	  	this.next = this.end < realEnd; 
	}
	
}
