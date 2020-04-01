package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDao;
import com.example.demo.vo.EmpVo;

@RestController
public class MailController {
	@Autowired
	private EmpDao dao;

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	
	@Scheduled(cron = "00 00 12 01 * ?") // 초 분 시 일 월(모든월*) 년
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
			List<EmpVo>list = dao.listEmp();
			for(int i = 0 ;i<list.size() ;i++ ) {
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setSubject("급여명세서 입니다");
				mailMessage.setFrom("보낼사람 이메일주소");
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

