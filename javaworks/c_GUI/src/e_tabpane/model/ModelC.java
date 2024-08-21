package e_tabpane.model;

public class ModelC {
	DBDriver_ex dbd;
	public ModelC() throws Exception{
		//드라이버 로딩
		dbd = DBDriver_ex.getInstance();
	}


}
