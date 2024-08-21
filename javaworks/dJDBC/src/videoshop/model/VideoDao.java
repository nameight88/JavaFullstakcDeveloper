package videoshop.model;
import java.util.*;
import videoshop.model.vo.Video;

public interface VideoDao {
	public void insertVideo(Video vo, int count) throws Exception;
	public  ArrayList selectVideos (int idx,String keyword) throws Exception;
	public Video searchByPk(int videoNum)throws Exception;
	public void deleteVideo(int videoNum)throws Exception;
	public void bVideoModify(Video v)throws Exception;
}
