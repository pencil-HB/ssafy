package com.mybatis;

public class Customer {
	private String num;
	private String name;
	private String address;

	public Customer(String string, String string2, String string3) {
		num = string;
		name = string2;
		address = string3;
	}
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [num=" + num + ", name=" + name + ", address=" + address + "]";
	}

}
