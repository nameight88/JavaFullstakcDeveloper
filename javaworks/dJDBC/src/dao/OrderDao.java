package dao;

public interface OrderDao {

	public int selectPrice(String category, String menuname) throws Exception;
	
}
