package network1.basic;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleClient {
	
	public final static int PORT = 5000;
	public final static String HOST = "127.0.0.1";
	
	public static void main( String args[] ) {
		
		Socket client = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		
		// 콘솔 입력을 받기 위해
		Scanner stdin = new Scanner( System.in );
		

		try{ 
					
		// 1. 서버에 연결하기 위해 소켓 생성
			client = new Socket(HOST,PORT);
			
		// 2. 소켓의 입출력 스트림 얻기
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());
		
		// 3. 키보드 입력 받아 서버에 전송
	
			System.out.println("인삿말입력");
			String inData = stdin.nextLine();
			out.writeUTF(inData);
				
		// 4. 서버로부터 응답을 받음
			
			String outData = in.readUTF();
			System.out.println("서버에게 받은 메세지: "+outData);
		
		// 5. 입출력 스트림의 닫음
			
			in.close();
			out.close();
			client.close();
			
		} catch ( Exception ex ) {
			System.out.println("Error writing.." + ex );	
		}
	}	
}