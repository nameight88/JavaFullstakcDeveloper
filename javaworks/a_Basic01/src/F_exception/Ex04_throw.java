package F_exception;

public class Ex04_throw {

	public static void main(String[] args) {
		try {
			readArray();
		}catch(Exception ex) {
			System.out.println("예외발생: "+ex.getMessage());
		}
	}

	static void readArray() throws Exception { //예외를 넘길때는 throws
		//		try{
		String [] msg = {"행복합시다.","공부합시다.","짝꿍친하게"};
		for (int i = 0 ; i<=msg.length; i+=1) {
			System.out.println(msg[i]);
		}catch(Exception ex) {
			throw new MyExceoption(); // 일부러 예외를 발생 (직접 일부러 발생 시킬떄는 throw)
		}
	}
		//		}catch(Exception ex) {
		//			System.out.println("예외발생: "+ex.getMessage());
		//		}
}


