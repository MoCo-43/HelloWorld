package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	
    SqlSession sqlSession = DataSource.getInstance().openSession();
    MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
    
	@Override
	public MemberVO login(String id, String pw) {
	  return mapper.selectMember(id,  pw);
	}

	@Override
	public List<MemberVO> memberList(String order) {
		return mapper.selectList(order);
	}

	// 회원등록
	@Override
	public boolean addMember(MemberVO member) {
		int r = mapper.insertMember(member);
		if(r==1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	// 회원조회(회원아이디 체크)
	@Override
	public boolean getMemberInfo(String id, String pw) {
		MemberVO member = mapper.selectMemberInfo(id, pw);
		if(member != null) {
			return true;
		}
		return false;
	}
	
}