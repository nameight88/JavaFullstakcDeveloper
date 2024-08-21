package com.javaclass.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaclass.dao.PropertyDaoImpl;
import com.javaclass.vo.PropertyOptionVO;
import com.javaclass.vo.PropertySecurityVO;
import com.javaclass.vo.PropertyVO;

@Service("propertyService")
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyDaoImpl propertyDao;

	// 매물 등록 트렌잭션 도전
	@Transactional
	@Override
	public void propertyInsert(PropertyVO vo, PropertyOptionVO optionVO, PropertySecurityVO securityVO) {
		propertyDao.insertProperty(vo,optionVO,securityVO);

	}

	@Transactional
	@Override
	public void updateProperty(PropertyVO vo, PropertyOptionVO optionVO, PropertySecurityVO securityVO) {
		propertyDao.updateProperty(vo, optionVO, securityVO);

	}

	@Override
	public void deleteProperty(int propertyId) {
		propertyDao.deleteProperty(propertyId);
	}

	@Override
	public List<PropertyVO> getPropertyList(PropertyVO vo) {
		return propertyDao.getPropertyList(vo);
	}

	
	// 매물 상세 조회
	@Override
	public PropertyVO getProperty(int propertyId) {
		return propertyDao.getProperty(propertyId);
	}


	@Override
	public PropertyOptionVO getPropertyOption(int propertyId) {
		return propertyDao.getPropertyOption(propertyId);
	}


	@Override
	public PropertySecurityVO getPropertySecurity(int propertyId) {
		return propertyDao.getPropertySecurity(propertyId);
	}

	@Override
	public List<PropertyVO> getPropertyMapList(PropertyVO vo) {
		
		return propertyDao.getPropertyMapList(vo);
	}

	@Override
	public List<PropertyVO> getNewProperty() {
		return propertyDao.getNewProperty();
	}

	
	// 맵 페이징
	@Override
	public List<PropertyVO> searchMap(HashMap map, int page, int pageSize) {
		int offset = (page - 1) * pageSize;
		return propertyDao.searchMap(map, offset, pageSize);
	}

	@Override
	public int getPropertiesCount(HashMap map) {
		return propertyDao.getPropertiesCount(map);
	}

	@Override
	public List<PropertyVO> getPropertyList(PropertyVO vo, int page, int size) {
		int offset = (page - 1) * size;
		return propertyDao.getPropertyList(vo, offset, size);
	}

	@Override
	public int getTotalAgentProperty(String agent_id) {
		return propertyDao.getTotalAgentProperty(agent_id);
	}


}
