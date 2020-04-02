package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpListVo {
	private int eno;
	private String ename;
	private String job;
	private int sal;
	private int comm;
	private String mgr;
	private String hiredate;
	private String dname;
	private String email;
	private String jumin;
}
