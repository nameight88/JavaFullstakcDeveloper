package com.javassem.service;

import com.javassem.vo.CustomerVO;
import com.javassem.vo.MemberVO;

public interface ServiceTx {
	public void addAll(CustomerVO cvo,MemberVO mvo) throws Exception;
}
