package com.example.demo.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
<<<<<<< HEAD
import lombok.NoArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@NoArgsConstructor
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
=======
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
	private String hiredate;
	private int dno;
>>>>>>> branch 'master' of https://github.com/ldh85246/empTest.git
}
