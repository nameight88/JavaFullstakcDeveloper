package com.javaclass.service;

import java.util.HashMap;
import java.util.List;

import com.javaclass.vo.PropertyOptionVO;
import com.javaclass.vo.PropertySecurityVO;
import com.javaclass.vo.PropertyVO;

public interface PropertyService {


	// 매물 수정
	public void updateProperty(PropertyVO vo, PropertyOptionVO optionVO, PropertySecurityVO securityVO);

	// 매물 삭제
	public void deleteProperty(int propertyId);

	// 매물 목록 조회
	public List<PropertyVO> getPropertyList(PropertyVO vo);


	// 매물 상세 조회
	public PropertyVO getProperty(int propertyId);

	public PropertyOptionVO getPropertyOption(int propertyId);

	public PropertySecurityVO getPropertySecurity(int propertyId);


	// 매물 등록 트랜젝션 도전
	public void propertyInsert(PropertyVO vo, PropertyOptionVO optionVO, PropertySecurityVO securityVO);

	// 맵 리스트
	public List<PropertyVO> getPropertyMapList(PropertyVO vo);


	public List<PropertyVO> getNewProperty();


	//페이징구현
	public List<PropertyVO> searchMap(HashMap map, int page, int pageSize);

	public int getPropertiesCount(HashMap map);


	// 페이징구현
	public List<PropertyVO> getPropertyList(PropertyVO vo, int page, int size);

	public int getTotalAgentProperty(String agent_id);

}
