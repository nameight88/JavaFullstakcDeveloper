package F_exception;

import java.io.*;

public class Ex02_TryCatch {
	FileInputStream fis = null;
	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("abc.txt");
			System.out.println("파일 연결");
			fis.read();

			fis.close();

		}catch(FileNotFoundException ex) {
			System.out.println("파일이 없는 예외 발생");
		}catch(IOException ex) {
			System.out.println("파일 읽을 때 예외 발생");
		}catch(Exception ex) {
			System.out.println("그 외 예외발생");	
		}finally {
			fis.close();
		}catch(Exception ex){
			
		}
		

	}	
}
