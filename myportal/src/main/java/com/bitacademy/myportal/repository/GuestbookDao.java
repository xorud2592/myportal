package com.bitacademy.myportal.repository;

import java.util.List;

import com.bitacademy.myportal.vo.GuestbookVo;

public interface GuestbookDao {
	public List<GuestbookVo> selectAll();
	public int insert(GuestbookVo vo);
	public int delete(GuestbookVo vo);
}