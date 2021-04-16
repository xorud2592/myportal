package com.bitacademy.myportal.repository;

import com.bitacademy.myportal.vo.MemberVo;

public interface MemberDao {
	public int insert(MemberVo vo);
	public MemberVo selectUser(String email, String password);
	public MemberVo selectUser(String email);
}
