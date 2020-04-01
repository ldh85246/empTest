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
	public MemberVo login(HttpServletRequest request ,MemberVo m) {
		System.out.println(m);
		MemberVo vo = dao.isMember(m);
		System.out.println(vo);
		return vo;
	}
}
