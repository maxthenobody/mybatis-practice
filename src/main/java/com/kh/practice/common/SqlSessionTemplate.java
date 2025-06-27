package com.kh.practice.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
    // static 블럭을 사용하여 클래스 로딩시 sqlSessionFactory객체를 생성.
	// 생성방법은 이전 교안 혹은 MyBatis메뉴얼 참고.
    
    // SqlSession을 반환하는 메서드 작성
	/*
	 * 어플리케이션 시작시 SqlSessionFactory를 1회만 생성하여 재사용하도록 코드를 작성.
	 * 
	 */
	private static SqlSessionFactory sqlSessionFactory;
	
	// 스태틱 초기화 블럭: 현재 클래스가 로딩되는 시점에서 단 1번 실행.
	static {
		String resource = "/mybatis-config.xml";
		System.out.println("팩토리생성");
		try (InputStream input = Resources.getResourceAsStream(resource)) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// sqlSession 반환 메서드
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession(false); // 수동커밋설정
	}
}
