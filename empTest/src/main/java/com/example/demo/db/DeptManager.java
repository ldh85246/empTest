package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptVo;
import com.example.demo.vo.EmpVo;

public class DeptManager {
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
	public static List<DeptVo> listDept(){
		SqlSession session = factory.openSession();
		List<DeptVo> list = session.selectList("dept.list");
		session.close();
		return list;
	}
	public static int insertDept(DeptVo d) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.insert("dept.insert", d);
		session.commit();
		session.close();
		return re;
	}
}
