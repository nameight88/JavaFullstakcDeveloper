package news.impl;

import java.util.List;

import news.NewsService;
import news.vo.NewsVO;

public class NewsServiceImpl implements NewsService {
	
	private NewsDAOMybatis newsDAO;
	@Override
	public void deleteBoard(NewsVO vo) {
		
		
	}

	@Override
	public NewsVO getNews(NewsVO vo) {
		
		return newsDAO.getNews(vo);
	}

	@Override
	public List<NewsVO> getNewsList(NewsVO vo) {
		// TODO Auto-generated method stub
		return newsDAO.getNewsList(vo);
	}

}
