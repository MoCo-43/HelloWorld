package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.EventVO;

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DataSource.getInstance().openSession();
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList(SearchDTO search) {
		// return mapper.selectListWithPaging(search);
		return mapper.selectList();
	}

	@Override
	public BoardVO getBoard(int bno) {
		BoardVO board = mapper.selectBoard(bno); // 글번호 -> 조회
		if (board != null) {
			mapper.updateReadCnt(bno); // 글번호 -> 조회수증가
			sqlSession.commit(); // 커밋처리
		}
		return board;
	}

	@Override
	public boolean registerBoard(BoardVO board) {
		int r = mapper.insertBoard(board); // 잘처리 되면 1로 반환 (boolean값으로 반환해야하므로)
		if (r == 1) { // 자동커밋을 할지 말지 여부를 결정. 처리된 건수를 반환
			sqlSession.commit(); // 커밋처리
			return true;

		}
		return false;
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		int r = mapper.updateBoard(board);
		if (r == 1) { // 자동커밋을 할지 말지 여부를 결정. 처리된 건수를 반환
			sqlSession.commit(); // 커밋처리
			return true;

		}
		return false;
	}

	@Override
	public boolean removeBoard(int bno) {
		int r = mapper.deleteBoard(bno);
		if (r == 1) {
			sqlSession.commit(); // 커밋처리
			return true;
		}
		return false;
	}

	// 전체건수
	@Override
	public int getTotalCount(SearchDTO search) {
		return mapper.selectCount(search);
	}

	@Override
	public List<Map> chartCount() {
		return mapper.selectUserByCount();
	}

	// 이벤트부분
	@Override
	public List<Map<String, String>> eventList() {
		return mapper.selectEvent();
	}

	@Override
	public boolean addEvent(Map<String, String> map) {
		int r = mapper.insertEvent(map);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean removeEvent(Map<String, String> map) {
		int r = mapper.deleteEvent(map);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	

    

	
	
}
