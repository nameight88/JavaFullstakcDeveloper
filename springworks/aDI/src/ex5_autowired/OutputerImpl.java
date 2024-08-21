package ex5_autowired;

import java.io.FileWriter;
import java.io.IOException;

public class OutputerImpl implements Outputer {

	private String path;
	
	public void setPath(String path) {
		this.path=path;
	}
	
	public void writeMessage(String msg) throws IOException{
		
		
		FileWriter f = new FileWriter(path);
		f.write(msg);
		f.close();
		//파일을 열어서 그 path 변수에 담긴 경로로 msg변수 값을 넣고 파일을 닫는다.
	}
}
