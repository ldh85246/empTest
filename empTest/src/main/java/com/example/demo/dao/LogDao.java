package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DeptManager;
import com.example.demo.db.LogManager;
import com.example.demo.vo.DeptVo;
import com.example.demo.vo.LogVo;

@Repository
public class LogDao {
	public List<LogVo> list(){
		return LogManager.listLog();
	}
	public int insert(LogVo l){
		return LogManager.insertLog(l);
	}
}