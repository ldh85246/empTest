package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DeptDao;
import com.example.demo.vo.DeptVo;
import com.google.gson.Gson;

@RestController
public class DeptController {
	@Autowired
	private DeptDao dao;

	public void setDao(DeptDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/listDept.do")
	public String listDept() {
		String str = "";
		List<DeptVo>list = dao.listDept();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
	
	
	@RequestMapping("/insertDept.do")
	public String insertDept(DeptVo d) {
		int re = -1;
		String str = "";
		re = dao.insertDept(d);
		Gson gson = new Gson();
		str = gson.toJson(re);
		return str;
	}
}
