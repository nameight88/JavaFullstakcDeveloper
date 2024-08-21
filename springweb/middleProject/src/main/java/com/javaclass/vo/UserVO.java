package com.javaclass.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

//@Alias("cvo")
@Data
public class UserVO {

	private String user_id;
	private String user_password;
	private String user_email;
	private String user_name;
	private String user_phone;

}
