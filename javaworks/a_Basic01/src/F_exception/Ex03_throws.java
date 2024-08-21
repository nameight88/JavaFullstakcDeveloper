package F_exception;
import java.io.*;
public class Ex03_throws {

	public static void main(String[] args) {
		try {
		readFile();
		}catch(Exception ex) {
			System.out.println("예외 발생: " + ex.getMessage());
		}
	}
	
	static void readFile()throws Exception {
		FileInputStream fis = null;
		try {
				fis =new FileInputStream("abc");
		}finally {
			fis.close();
		}
	}

}
