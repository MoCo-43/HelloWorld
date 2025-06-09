package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 인터페이스 - BoardMapper.xml 파일들을 매칭
 * package이름이 동일해야함
 */
public interface BoardMapper {
  public List<BoardVO> selectList();  // 목록
  public BoardVO selectBoard(int bno); // 단건조회
  public int updateReadCnt(int bno);  // 조회 count 증가
  public int insertBoard(BoardVO board);
  public int updateBoard(BoardVO board);
  public int deleteBoard(BoardVO board); 
}
