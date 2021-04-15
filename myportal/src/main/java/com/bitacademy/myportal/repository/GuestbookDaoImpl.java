package com.bitacademy.myportal.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.vo.GuestbookVo;

@Repository		//	이름 명시 안하면 클래스 이름을 기반으로 자동 명명
//	-> guestbookDaoImpl 이름을 bean 등록
//@Repository("guestbookDao")
public class GuestbookDaoImpl implements GuestbookDao {
	//	데이터 소스 연결
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<GuestbookVo> selectAll() {
		//	TODO: 예외 전환 처리
		List<GuestbookVo> list = sqlSession.selectList("guestbook.selectAll");
		System.out.println("방명록:" + list);
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		int insertedCount = sqlSession.insert("guestbook.insert", vo);
		return insertedCount;
	}

	@Override
	public int delete(GuestbookVo vo) {
		int deletedCount = sqlSession.delete("guestbook.delete", vo);
		return deletedCount;
	}

}