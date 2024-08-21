package com.javaclass.dao;

import java.util.List;

import com.javaclass.vo.NewsVO;

public interface NewsDao {
	
	public List<NewsVO> getNewsList(int offset,int size);
	int getTotalNewsCount();
	public void deleteNews(int news_num);

}
