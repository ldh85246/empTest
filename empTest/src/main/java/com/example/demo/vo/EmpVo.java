package com.example.demo.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpVo {
	private int eno;
	private String ename;
	private String job;
	private int sal;
	private int comm;
	private int mgr;
	private Date hiredate;
	private int dno;
	private String email;
	private String jumin;
}
