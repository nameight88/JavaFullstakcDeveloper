package com.javassem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor//lombok 호출후 생성자 함수 생성 해주는것도 호출
public class SampleVO {
	
	private String name;
	private Integer age;
	private String message;
	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Integer getAge() {
//		return age;
//	}
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//	public String getMessage() {
//		return message;
//	}
//	public void setMessage(String message) {
//		this.message = message;
//	}
//	@Override
//	public String toString() {
//		return "SampleVO [name=" + name + ", age=" + age + ", message=" + message + ", getName()=" + getName()
//				+ ", getAge()=" + getAge() + ", getMessage()=" + getMessage() + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}
	
}
