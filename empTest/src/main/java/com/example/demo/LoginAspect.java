package com.example.demo;

import java.io.FileWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Component;

import com.example.demo.dao.LogDao;
import com.example.demo.vo.LogVo;

@Aspect
@Component
public class LoginAspect {
	
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	private void controlMethod(){}
	
	@Before("controlMethod()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString(); 
		HttpServletRequest request =(HttpServletRequest)joinPoint.getArgs()[0];
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		String time = new Date().toLocaleString();
		String msg = uri+"/"+ip+"/"+time+"\n";
		Date today = new Date();
		int yy = today.getYear()+1900;
		int mm = today.getMonth()+1;
		int dd = today.getDate();
		int hh = today.getHours();
		int min = today.getMinutes();
		String fname = yy+"년"+mm+"월"+dd+"일"+hh+"시"+min+"분";
		String path = "C:/dotoriLogData";
		LogDao dao = new LogDao();
		LogVo vo = new LogVo();
		vo.setNo(0);
		vo.setIp(ip);
		vo.setTime(fname);
		vo.setUrl(uri);
		dao.insert(vo);
		try {
			FileWriter fileWriter = new FileWriter(path+"/"+fname+".txt",true);
			fileWriter.write(msg);
			fileWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(methodName+"메소드 동작전");
	}
}
