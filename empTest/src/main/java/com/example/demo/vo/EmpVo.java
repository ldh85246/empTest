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
	private String hiredate;
	private int dno;
}
