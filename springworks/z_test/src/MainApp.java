import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import news.NewsService;
import news.vo.NewsVO;

public class MainApp {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container =new GenericXmlApplicationContext("applicationContext.xml");
		// 2. Spring 컨테이너로부터 BoardServiceImpl 객체를 Lookup한다.
		NewsService newsService = (NewsService) container.getBean("newsService");
		
		// 4. 글 목록 검색 기능 테스트		
		NewsVO nvo = new NewsVO();
		List<NewsVO> newsList = newsService.getNewsList(nvo);
		for(NewsVO news : newsList) {
			System.out.println("----->" + news.toString());
		}
		// 5. Spring 컨테이너 종료
		container.close();
	}

}
