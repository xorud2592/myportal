package com.bitacademy.myportal.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.myportal.exception.MemberDaoException;
import com.bitacademy.myportal.service.MemberService;
import com.bitacademy.myportal.vo.MemberVo;

@Controller
@RequestMapping("/members")
public class MemberController {
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = { "", "/", "/join" }, method = RequestMethod.GET)
	public String join() {
		return "users/joinform";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinAction(@ModelAttribute MemberVo memberVo) {
//		System.out.println("Form 전송된 데이터:" + memberVo);
		logger.debug("Form 전송된 데이터:" + memberVo);

		boolean success = memberService.join(memberVo);

		if (success) {
//			System.out.println("가입 성공!");
			logger.debug("가입 성공!");
			return "redirect:/members/joinsuccess";
		} else {
//			System.err.println("가입 실패!");
			logger.error("가입 실패!");
			return "redirect:/members/";
		}
	}

	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "users/joinsuccess";
	}

	@ResponseBody
	@RequestMapping("/show")
	public Object showUserByEmail(@RequestParam String email) {
		MemberVo vo = memberService.getUser(email);
		return vo;
	}

	@ResponseBody
	@RequestMapping("/emailcheck")
	public Object existEmail(@RequestParam(value = "email", required = false, defaultValue = "") String email) {
		MemberVo vo = memberService.getUser(email);
		boolean exists = vo != null ? true : false;

		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", exists);
		return map;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "users/loginform";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAction(@RequestParam String email, @RequestParam String password, HttpSession session) {
		MemberVo authUser = memberService.getUser(email, password);

		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		}
		return "redirect:/members/login";
	}

	@RequestMapping(value = "/logout")
	public String logoutAction(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
}
