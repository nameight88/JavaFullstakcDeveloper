package board_mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import emp_mybatis.EmpVO;

public class BoardRepo {
private SqlSessionFactory getSqlSessionFactory() {
		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		SqlSessionFactory sessFactory =  new SqlSessionFactoryBuilder().build(inputStream);
		return sessFactory;
	}//end of SqlSessionFactory

	
	public List<BoardVO> selectBoard(){
	SqlSession sess = getSqlSessionFactory().openSession();
	try {
		//List<EmpVO> list = sess.selectList("EmpMapper.selectEmp");
		//return list;
		return sess.selectList("BoardMapper.selectBoard");
	}finally {
		sess.close();
	}
	
	
	}//end of selectBoard
	
}
