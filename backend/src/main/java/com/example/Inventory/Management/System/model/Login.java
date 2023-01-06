package com.example.Inventory.Management.System.model;

import org.springframework.stereotype.Component;

@Component
public class Login {

	private int customerid;
	private String customerPass;

	public Login(int customerid, String customerPass) {
		super();
		this.customerid = customerid;
		this.customerPass = customerPass;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getcustomerid() {
		return customerid;
	}
	public void setEmpid(int customerid) {
		this.customerid = customerid;
	}
	public String getEmpPass() {
		return customerPass;
	}
	public void setEmpPass(String customerPass) {
		this.customerPass = customerPass;
	}
}
