package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.LogVo;

public class LogManager {
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
	public static List<LogVo> listLog(){
		SqlSession session = factory.openSession();
		List<LogVo> list = session.selectList("log.list");
		session.close();
		return list;
	}
	public static int insertLog(LogVo l) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("log.insert", l);
		session.close();
		return re;
	}
}
