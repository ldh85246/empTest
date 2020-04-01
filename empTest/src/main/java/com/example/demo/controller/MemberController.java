package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVo;

@RestController
public class MemberController {
	@Autowired
	private MemberDao dao;
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, MemberVo m) {
		String str = "no";
		MemberVo vo = dao.isMember(m);
		if(vo != null) {
			System.out.println("로그인 성공");
			str = m.getId();
		}else {
			System.out.println("로그인 실패");
		}
		System.out.println("결과 : " + str);
		return str;
	}
}