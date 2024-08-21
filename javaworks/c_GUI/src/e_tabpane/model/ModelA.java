package e_tabpane.model;

public class ModelA {
	DBDriver_ex dbd;
	public ModelA() throws Exception{
		//드라이버 로딩
		dbd = DBDriver_ex.getInstance();
	}
	
	
}
