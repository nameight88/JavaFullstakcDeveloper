package e_tabpane.model;

public class ModelB {
	DBDriver_ex dbd;
	public ModelB() throws Exception{
		//드라이버 로딩
		dbd = DBDriver_ex.getInstance();
	}
	
	
}
