package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.EmpManager;
import com.example.demo.vo.EmpListVo;
import com.example.demo.vo.EmpVo;

@Repository
public class EmpDao {
	public List<EmpVo> listEmpOnly(){
		return EmpManager.listEmpOnly();
	}
	public List<EmpVo> listMgr(){
		return EmpManager.listMgr();
	}
	public List<EmpListVo> listEmpDept(){
		return EmpManager.listEmpDept();
	}
	public EmpVo detailEmp(int eno) {
		return EmpManager.detailEmp(eno);
	}
	public int insertEmp(EmpVo e) {
		return EmpManager.insertEmp(e);
	}
	public int updateEmp(EmpVo e) {
		return EmpManager.updateEmp(e);
	}
	public int deleteEmp(int eno) {
		return EmpManager.deleteEmp(eno);
	}
}
