package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.EmpListVo;
import com.example.demo.vo.EmpVo;

public class EmpManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static List<EmpVo> listEmpOnly(){
		SqlSession session = factory.openSession();
		List<EmpVo> list = session.selectList("emp.listEmpOnly");
		session.close();
		return list;
	}
	public static List<EmpVo> listMgr(){
		SqlSession session = factory.openSession();
		List<EmpVo> list = session.selectList("emp.listMgr");
		session.close();
		return list;
	}
	public static List<EmpListVo> listEmpDept(){
		SqlSession session = factory.openSession();
		List<EmpListVo> list = session.selectList("emp.listEmpDept");
		session.close();
		return list;
	}
	public static EmpVo detailEmp(int eno) {
		SqlSession session = factory.openSession();
		EmpVo e = session.selectOne("emp.detail", eno);
		session.close();
		return e;
	}
	
	public static int insertEmp(EmpVo e) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.insert("emp.insert", e);
		session.commit();
		session.close();
		return re;
	}
	public static int updateEmp(EmpVo e) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.update("emp.update", e);
		session.commit();
		session.close();
		return re;
	}
	
	public static int deleteEmp(int eno) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.delete("emp.delete", eno);
		session.commit();
		session.close();
		return re;
	}
}
