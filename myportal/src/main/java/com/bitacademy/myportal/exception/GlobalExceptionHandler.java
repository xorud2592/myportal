package com.bitacademy.myportal.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

//	어드바이징 컨트롤러: 전역에서 발생하는 예외를 
//	감지해서 처리하는 처리기
@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	//	하나의 예외 클래스에 하나의 핸들러를 붙이는 것을 추천
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)	//	ControllerException이 발생하면 500 에러를 전송
	@ExceptionHandler(ControllerException.class)
	public ModelAndView handleControllerException(ControllerException e) {
		//	1. 로깅
//		System.err.println("----------");
//		System.err.println("ControllerAdvice에 의한 Error Handling");
		logger.error("----------");
		logger.error("ControllerAdvice에 의한 Error Handling");
		e.printStackTrace();	//	예외 세부 정보 로깅
		
		//	2. 시스템 오류 관련 안내 화면
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());
		mav.setViewName("error/exception");
		
		return mav;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(MemberDaoException.class)
	public ModelAndView handelMemberDaoException(MemberDaoException e) {
//		System.err.println("MemderDaoException:" + e.getMessage());
		logger.error("MemderDaoException:" + e.getMessage());
		e.printStackTrace();
		
//		System.err.println("MemberVo:" + e.getMemberVo());
		logger.error("MemberVo:" + e.getMemberVo());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());
		mav.setViewName("error/exception" );
		
		return mav;
	}
}