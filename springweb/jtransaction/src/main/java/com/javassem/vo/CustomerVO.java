package com.javassem.vo;

import org.apache.ibatis.type.Alias;

//@Alias("cvo")
public class CustomerVO {
	 private int num;
	 private String ssn;
	 private String name;
	 private String address;
	 
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
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
		return "CustomerVO [num=" + num + ", ssn=" + ssn + ", name=" + name + ", address=" + address + ", getNum()="
				+ getNum() + ", getSsn()=" + getSsn() + ", getName()=" + getName() + ", getAddress()=" + getAddress()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	 
	
}
