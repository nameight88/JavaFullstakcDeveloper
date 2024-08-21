package com.javaclass.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.vo.PropertyOptionVO;
import com.javaclass.vo.PropertySecurityVO;
import com.javaclass.vo.PropertyVO;

@Repository("propertyDao")
public class PropertyDaoImpl implements PropertyDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insertProperty(PropertyVO vo, PropertyOptionVO optionVO, PropertySecurityVO securityVO) {
		mybatis.insert("PropertyDao.insertOption", optionVO);
		mybatis.insert("PropertyDao.insertSecurity", securityVO);
		mybatis.insert("PropertyDao.insertProperty", vo);

	}

	@Override
	public void updateProperty(PropertyVO vo, PropertyOptionVO optionVO, PropertySecurityVO securityVO) {
		mybatis.update("PropertyDao.updateProperty", vo);
		mybatis.update("PropertyDao.updateOption", optionVO);
		mybatis.update("PropertyDao.updateSecurity", securityVO);

	}

	// 매물 삭제
	@Override
	public void deleteProperty(int propertyId) {
		mybatis.delete("PropertyDao.deleteProperty",propertyId);
		mybatis.delete("PropertyDao.deleteSecurity",propertyId);
		mybatis.delete("PropertyDao.deleteOption",propertyId);
	}

	@Override
	public List<PropertyVO> getPropertyList(PropertyVO vo) {
		List<PropertyVO> result = mybatis.selectList("PropertyDao.getPropertyList", vo);
		return result;
	}

	



	@Override
	public PropertyVO getProperty(int propertyId) {
		PropertyVO vo = mybatis.selectOne("PropertyDao.getProperty", propertyId);
		return vo;
	}
	
	@Override
	public PropertyOptionVO getPropertyOption(int propertyId) {
		PropertyOptionVO optionVO = mybatis.selectOne("PropertyDao.getPropertyOption", propertyId);
		return optionVO;
	}

	@Override
	public PropertySecurityVO getPropertySecurity(int propertyId) {
		PropertySecurityVO securityVO  = mybatis.selectOne("PropertyDao.getPropertySecurity", propertyId);
		return securityVO;
	}

	@Override
	public List<PropertyVO> getPropertyMapList(PropertyVO vo) {
		List<PropertyVO> result = mybatis.selectList("PropertyDao.getPropertyMapList", vo);

		return result;
	}

	@Override
	public List<PropertyVO> getNewProperty() {
		
		return mybatis.selectList("PropertyDao.getNewProperty");
	}

	@Override
	public List<PropertyVO> searchMap(HashMap map, int offset, int pageSize) {
		map.put("offset",offset);
		map.put("pageSize",pageSize);
		return mybatis.selectList("PropertyDao.searchMap",map);
	}

	@Override
	public int getPropertiesCount(HashMap map) {
		return mybatis.selectOne("PropertyDao.getPropertiesCount",map);
	}

	@Override
	public List<PropertyVO> getPropertyList(PropertyVO vo, int offset, int size) {
		HashMap map = new HashMap();
		map.put("agent_id", vo.getAgent_id());
		map.put("offset", offset);
		map.put("size", size);
		
		return mybatis.selectList("PropertyDao.getPropertyPagingList",map);
	}

	@Override
	public int getTotalAgentProperty(String agent_id) {
		return mybatis.selectOne("PropertyDao.getTotalAgentProperty",agent_id);
	}


}
