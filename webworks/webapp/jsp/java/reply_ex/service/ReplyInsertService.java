package reply_ex.service;

import board_ex.model.BoardDao;
import board_ex.model.BoardException;
import board_ex.model.BoardVO;
import reply_ex.model.ReplyException;
import reply_ex.model.ReplyVO;


public class ReplyInsertService {
	
	private static ReplyInsertService instance;
	public static ReplyInsertService getInstanc() throws ReplyException{
		if( instance == null )
		{
			instance = new ReplyInsertService();
		}
		return instance;
	}
	
//public int insert( ReplyVO rec ) throws BoardException{
		
	//ReplyVO dao = ReplyVO.getInstance();
	
		//return dao.insert(rec);
		
	//}
	
	
	
}
