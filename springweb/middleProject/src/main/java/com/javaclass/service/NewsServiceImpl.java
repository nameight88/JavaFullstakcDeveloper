package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.NewsDao;
import com.javaclass.vo.NewsVO;

@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	private NewsDao newsDAO;

	@Override
	public List<NewsVO> getNewsList(int page,int size) {
		int offset = (page - 1 )*size;
		return newsDAO.getNewsList(offset,size);
	}
	public int getTotalNewsCount() {
		return newsDAO.getTotalNewsCount();
	};
	@Override
	public void deleteNews(int news_num) {
		newsDAO.deleteNews(news_num);

	}

}
