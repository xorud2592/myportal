package com.bitacademy.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.GuestbookDao;
import com.bitacademy.myportal.vo.GuestbookVo;

@Service
public class GuestbookServiceImpl implements GuestbookService {

	//	DAO 연결
	//	Autowired : bean id로 객체를 검색 주입(DI)
	@Autowired
	GuestbookDao guestbookDaoImpl; 
	
	@Override
	public List<GuestbookVo> getList() {
		List<GuestbookVo> list = guestbookDaoImpl.selectAll();
		return list;
	}

	@Override
	public boolean writeMessage(GuestbookVo vo) {
		int insertedCount = guestbookDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public boolean deleteMessage(GuestbookVo vo) {
		int deletedCount = guestbookDaoImpl.delete(vo);
		return 1 == deletedCount;
	}

}