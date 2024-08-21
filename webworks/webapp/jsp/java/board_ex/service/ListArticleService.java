package board_ex.service;

import java.util.List;

import board_ex.model.*;

public class ListArticleService {
   
   private int totalRecCount;      // 전체 레코드 수   
   private int pageTotalCount;      // 전체 페이지 수
   private int countPerPage = 3;   // 한페이지당 레코드 수
   
   private static ListArticleService instance;
   public static ListArticleService getInstance()  throws BoardException{
      if( instance == null )
      {
         instance = new ListArticleService();
      }
      return instance;
   }
   
   public List <BoardVO> getArticleList() throws BoardException
   {
       List <BoardVO> mList = BoardDao.getInstance().selectList();         
       return mList;
   }
   
   // 오버로딩
   public List <BoardVO> getArticleList(String pNum) throws BoardException
   {
      int pageNum = 1;
      
      if(pNum != null) {
         pageNum = Integer.parseInt(pNum);
      }
      
      int starNum = (pageNum-1)* countPerPage;

       List <BoardVO> mList = BoardDao.getInstance().selectList(starNum, countPerPage);         
       return mList;
   }
   
   
   public int getTotalCount() throws BoardException{
      totalRecCount = BoardDao.getInstance().getTotalCount();
      //dao에 있는 getTotalCount를 호출을 해서 totalRecCount 변수에 초기화
      pageTotalCount=totalRecCount/countPerPage;
      if((totalRecCount%countPerPage) >  0) {
         pageTotalCount++;
      }
      
      // 화면에서의 페이지 수를 리턴
      return pageTotalCount;
   }
   
   
      
}