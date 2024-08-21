package com.javaclass.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.vo.NewsVO;

@Repository
public class NewsDaoImpl implements NewsDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<NewsVO> getNewsList(int offset,int size) {
		Map<String,Integer> params = new HashMap<String,Integer>();
		params.put("offset",offset);
		params.put("size",size);
		return mybatis.selectList("news.getNewsList",params);
	}
	public int getTotalNewsCount() {
        return mybatis.selectOne("news.getTotalNewsCount");
    }

	
	@Override
	public void deleteNews(int news_num) {
		mybatis.delete("news.newsDelete",news_num);
		 
		
	}
}
