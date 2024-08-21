package mybatis.guest.service;

import java.util.*;

import mybatis.guest.model.Comment;
import mybatis.guest.session.CommentRepository;

public class CommentService {
	
	private static CommentService service;
	
	private CommentService() {}
	public static CommentService getInstance(){
		if( service == null) service = new CommentService();
		return service;
	}
	//[3] 래퍼지토리 생성 및 selectComment 생성 -> CommentRepository
	CommentRepository repo=
			new CommentRepository();
	//새로운 래퍼지토리 생성
	
	public  List<Comment> selectComment(){
		
		//List<Comment> list = repo.selectComments();
		//return list;
		return repo.selectComment();
	}
	
	public  List<Comment> selectComment(HashMap map){
		//map = condition
		//List<Comment> list = repo.selectComments();
		//return list;
		return repo.selectComment(map);
	}
	
	
	public void insertComment(Comment comment) {
			repo.insertComment(comment);
	}
	public Comment selectCommentByPK(int commnetNo) {
		//Comment comment = repo.repo.selectCommentByPK(commnetNo);
		//return comment;
		
		return repo.selectCommentByPK(commnetNo);
	}
	
	public void deleteComment(int cNo) { //함수 생성
		repo.deleteComment(cNo); //래퍼지토리 안에 있는 함수 호출
	}
	
	public void updateComment(Comment comment) {
		repo.updateComment(comment);
	}
}