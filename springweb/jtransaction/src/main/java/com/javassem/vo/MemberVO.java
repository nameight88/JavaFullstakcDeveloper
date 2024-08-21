package com.javassem.vo;

import org.apache.ibatis.type.Alias;

//@Alias("mvo")
public class MemberVO {
	private int num;
	private String id;
	private String password;
	private String name;
	private String address;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "MemberVO [num=" + num + ", id=" + id + ", password=" + password + ", name=" + name + ", address="
				+ address + ", getNum()=" + getNum() + ", getId()=" + getId() + ", getPassword()=" + getPassword()
				+ ", getName()=" + getName() + ", getAddress()=" + getAddress() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
