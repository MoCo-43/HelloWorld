package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/*
 * 회원처리
 * 
 * 로그인 및 사용자조회
 */
import com.yedam.vo.MemberVO;

public interface MemberMapper {
  public MemberVO selectMember(@Param("id")String id, @Param("pw")String pw);  // MemberMapper.xml의 #{id} #{pw}
  // 회원목록
  public List<MemberVO> selectList(String order);
}
