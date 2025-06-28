package com.kh.practice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.practice.common.SqlSessionTemplate;
import com.kh.practice.model.dao.MemberDao;
import com.kh.practice.model.dao.MemberDaoImpl;
import com.kh.practice.model.vo.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao dao = new MemberDaoImpl();

	@Override
	public List<Member> selectAllMember() {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Member> list = dao.selectAllMember(session);
//		System.out.println(list);
		session.close();
		
		return list;
	}

	@Override
	public Member selectMemberById(String userId) {
		SqlSession session = SqlSessionTemplate.getSession();
		Member member = dao.selectMemberById(session, userId);
		session.close();
		
		return member;
	}

	@Override
	public int inserMember(Member m) {
		SqlSession session = SqlSessionTemplate.getSession();
		int result = dao.inserMember(session, m);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		
		return result;
	}

	@Override
	public List<Member> selectMemberByName(String name) {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Member> list = dao.selectMemberByName(session, name);
//		System.out.println(list);
		session.close();
		
		return list;
	}

}
