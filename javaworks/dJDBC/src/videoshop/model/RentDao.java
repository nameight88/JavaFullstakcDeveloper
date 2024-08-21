package videoshop.model;

import java.util.ArrayList;

public interface RentDao {
	public void RentVideo (String tel, int vNum) throws Exception; //대여에 관한 추상적 모델 생성
	public void ReTurnVideo (int vNum) throws Exception; //반납에 대한 추상적 모델 생성
	//미납목록
	public ArrayList selectNoReturn() throws Exception;
	public void selectTel() throws Exception;
}
