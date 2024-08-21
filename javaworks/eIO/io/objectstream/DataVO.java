package io.objectstream;

import java.io.Serializable;

/* 직렬화:스트림으로 통과하는 객체
 *  Serializable을 이용해서 직렬화 작업을 해줘야한다.
 *  이것 덕분에 자바가 객체 전송이 쉽다.
 */

public class DataVO implements Serializable{
	String name;
	int age;
	double height;
	char bloodType;

	public DataVO() {}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public char getBloodType() {
		return bloodType;
	}
	public void setBloodType(char bloodType) {
		this.bloodType = bloodType;
	}
	public DataVO(String name, int age, double height, char bloodType) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.bloodType = bloodType;
	}

	@Override
	public String toString() {
		return "DataVO [name=" + name + ", age=" + age + ", height=" + height + ", bloodType=" + bloodType + "]";
	}

}
