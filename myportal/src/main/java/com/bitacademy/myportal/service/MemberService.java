package com.bitacademy.myportal.service;

import com.bitacademy.myportal.vo.MemberVo;

public interface MemberService {
	public boolean join(MemberVo vo);
	public MemberVo getUser(String email, String password);
	public MemberVo getUser(String email);
}
