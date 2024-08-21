package com.javaclass.vo;

import lombok.Data;

@Data
public class PropertySecurityVO {

	private int property_id;
	private boolean storage_box;
	private boolean cctv;
	private boolean door_lock;
	private boolean intercom;
	private boolean entrance_security;
	private boolean bodyguard;

}
