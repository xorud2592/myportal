package com.bitacademy.myportal.exception;

import com.bitacademy.myportal.vo.MemberVo;

public class MemberDaoException extends RuntimeException{
	private MemberVo memberVo = null;
	
	public MemberDaoException() {
		
	}
	
	public MemberDaoException(String message) {
		super(message);
	}
	
	public MemberDaoException(String message, MemberVo memberVo) {
		super(message);
		this.memberVo = memberVo;
	}

	public MemberVo getMemberVo() {
		return memberVo;
	}

	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}
	
	
}
