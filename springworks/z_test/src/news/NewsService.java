package news;

import java.util.List;

import news.vo.NewsVO;

public interface NewsService {
	void deleteBoard(NewsVO vo);
	NewsVO getNews(NewsVO vo);
	List<NewsVO> getNewsList(NewsVO vo);
}
