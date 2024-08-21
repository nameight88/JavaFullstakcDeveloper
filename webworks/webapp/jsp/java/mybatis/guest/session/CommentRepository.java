package mybatis.guest.session;

import java.io.*;
import java.util.*;

import mybatis.guest.model.Comment;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

public class CommentRepository 
{
	//	private final String namespace = "CommentMapper";

	private SqlSessionFactory getSqlSessionFactory() {
		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		SqlSessionFactory sessFactory =  new SqlSessionFactoryBuilder().build(inputStream);
		return sessFactory;
	}
	//[4] mybatis 프레임 워크를 이용을 해서 DB 커넥션을 생성을 하고 연동
	/* ****************************
	 * JDBC : Connection (연결)
	 * mybatis : SqlSession
	 *  둘이 하는 역할이 똑같다.
	 */
	public List<Comment> selectComment(){
		SqlSession sess = //커넥션을 호출을 해야한다.
				getSqlSessionFactory().openSession();
		try {
			//List<Comment> list = sess.selectList(""); //여러개를 가져 올 때
			//return list;
			
			return sess.selectList("CommentMapper.selectComment");//xml주소를 찾아줘야한다.
			//return sess.selectList("nameSpace.id")
		}finally {
			sess.close(); //연결객체를 닫는 것이 아니라 반환
			//내부적으로는 mybatis는 ConnectionPool 사용
			//미리 열어 놓음
			
		}
		
	}//end of selectComment
	
	public List<Comment> selectComment(HashMap map){
		//map = condition
		SqlSession sess = //커넥션을 호출을 해야한다.
				getSqlSessionFactory().openSession();
		try {//map을 넘겨줘야한다 *****
			return sess.selectList("CommentMapper.selectComment", map);
		}finally {
			sess.close(); //연결객체를 닫는 것이 아니라 반환
			//내부적으로는 mybatis는 ConnectionPool 사용
			//미리 열어 놓음
			
		}
		
	}//end of selectComment
	
	
	
	public void insertComment(Comment c) {
		SqlSession sess = 
				getSqlSessionFactory().openSession();
		try {
			//**************
			/*
			 * JDBC : auto commit
			 * Mybatis : manual commit
			 */
			int result = sess.insert("CommentMapper.insertComment",c);
			if(result ==1 ) {
				sess.commit();
			}else {
				sess.rollback();
			}
		}finally {
			sess.close();	
		}
	}//end of insertComment
	
	public Comment selectCommentByPK(int cNo) {
		SqlSession sess = 
				getSqlSessionFactory().openSession();
		try {
			HashMap map = new HashMap();
			map.put("commentNo", cNo);
			
			//넘어가는 변수가 cNo가 아니라 map이 넘어가야한다.
			
			Comment comment = sess.selectOne("CommentMapper.selectComment",map);
			return comment;
			
			//return sess.selectOne("CommentMapper.selectCommentByPK", cNo);
		}finally {
			sess.close();
		}
		
	}//end of selectCommentByPK
	
	public void deleteComment(int cNo) {
		SqlSession sess = 
				getSqlSessionFactory().openSession();
		try {
			
			int result = sess.delete("CommentMapper.deleteComment",cNo);
			if(result > 0) {
				sess.commit();
			}
			
		}finally {
			sess.close();
		}
	}//end of deleteComment
	
	public void updateComment(Comment comment) {
		SqlSession sess = 
				getSqlSessionFactory().openSession();
		
		try {
			int result = sess.update("CommentMapper.updateComment",comment);
			if (result > 0) { //모르면 0으로 해라 자식아;;
				sess.commit();
			}else {
				sess.rollback();
			}
		}finally {
			sess.close();
		}
	}
}
