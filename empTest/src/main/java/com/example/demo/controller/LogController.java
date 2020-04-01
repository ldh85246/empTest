package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DeptDao;
import com.example.demo.dao.LogDao;
import com.example.demo.vo.DeptVo;
import com.example.demo.vo.LogVo;
import com.google.gson.Gson;

@RestController
public class LogController {
	@Autowired
	private LogDao dao;

	public void setDao(LogDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/listLog.do")
	public String listLog(HttpServletRequest request) {
		String str = "";
		List<LogVo>list = dao.list();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}

}
