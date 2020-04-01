package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDao;
import com.example.demo.vo.EmpVo;
import com.google.gson.Gson;

@RestController
public class EmpController {

	@Autowired
	private EmpDao dao;

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(value = "/listEmp.do", produces = "application/json; charset=UTF-8")
	public String listEmp() {
		String str = "";
		List<EmpVo>list = dao.listEmp();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
	
	@RequestMapping(value = "/detailEmp.do", produces = "application/json; charset=UTF-8")
	public String detailEmp(int eno) {
		String str = "";
		EmpVo e = dao.detailEmp(eno);
		Gson gson = new Gson();
		str = gson.toJson(e);
		return str;
	}
	
	@RequestMapping(value = "/insertEmp.do" , produces = "application/json; charset=UTF-8")
	public String insertEmp(EmpVo e) {
		int re = -1;
		re = dao.insertEmp(e);
		return ""+re;
	}
	
	@RequestMapping(value = "/updateEmp.do")
	public String updateEmp(EmpVo e) {
		int re = -1;
		String str = "";
		System.out.println(e.getEno() + "/" + e.getEname() + "/" + 
				e.getJob() + e.getSal() + "/" + e.getComm() + "/" + e.getMgr() + "/" + 
				e.getHiredate() + "/" + e.getEmail() + "/" + e.getJumin() );
		re = dao.updateEmp(e);
		if (re > 0) {
			str = "회원정보 수정 성공";
		}
		return str;
	}
	
	@RequestMapping(value = "/deleteEmp.do")
	public String deleteEmp(int eno, HttpServletResponse response) {
		
		int re = -1;
		String str = "";
		re = dao.deleteEmp(eno);
		if (re > 0) {
			str = "회원삭제 성공";
			try {
				response.sendRedirect("/listEmp.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return str;
	}
}
