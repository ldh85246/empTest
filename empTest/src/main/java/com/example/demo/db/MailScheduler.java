package com.example.demo.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDao;
import com.example.demo.vo.EmpVo;

@RestController
public class MailScheduler {
	@Autowired
	private EmpDao dao;

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	
	@Scheduled(cron = "00 58 16 01 * ?") // 초 분 시 일 월(모든월*) 년
	public void pro() {
		System.out.println("스케쥴드 실행");
		mail();
	}
	@Autowired
	private MailSender javaMailSender;
	
	public void setJavaMailSender(MailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public String mail() {
		String str = "";
		List<EmpVo>list = dao.listEmpOnly();
		for(int i = 0 ;i<list.size() ;i++ ) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setSubject("급여명세서 입니다");
			mailMessage.setFrom("");
			mailMessage.setText(list.get(i).getEname()+"님 전 직원 7% 삭감합니다 수고허ㅏ세요");
			mailMessage.setTo(list.get(i).getEmail());
			try {
				javaMailSender.send(mailMessage);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		return str;
	}
}

