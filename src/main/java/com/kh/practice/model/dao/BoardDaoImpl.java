package com.kh.practice.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.practice.model.vo.Board;
import com.kh.practice.model.vo.Reply;

public class BoardDaoImpl implements BoardDao {

	@Override
	public List<Board> selectAllBoard(SqlSession session) {
		return session.selectList("board.selectAllBoard");
	}

	@Override
	public Board selectBoardByNo(SqlSession session, int boardNo) {
		Board b = session.selectOne("board.selectBoardByNo", boardNo);
		List<Reply> rList = session.selectList("board.selectReplyByNo", boardNo);
		b.setReplyList(rList);
		
		return b;
	}

	@Override
	public List<Board> searchBoard(SqlSession session, Map<String, Object> map) {
		return session.selectList("board.searchBoard", map);
	}

}
