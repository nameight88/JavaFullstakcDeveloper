package F_exception;
//목적: 프로그램은 항상 돌아가야하는데 도중에 비정상적을 종료하지 않게끔 하는게 예외처리이다.
public class Ex01_TryCatch {
	public static void main(String[] args) {
		String [] str = {"행복하자","맛점","맑은정신"};

		try { // 문제가 나는 부분을 트라이 쪽 블럭으로 끌어들인다.
			for(int i =0; i<=str.length; i+=1) {
				System.out.println(str[i]);
			}
			System.out.println("예외가 발생할 여지가 있는 구문");
			return;//비정상적인 경우에 캐치 부분이 가져가서 리턴이 발생하지 않았다.
		}catch(Exception ex) {//캐치부분에 새로운 선언과 블럭을 만들어 준다.
			System.out.println("예외발생 :" + ex.getMessage());//오류가 발생했을떼 캐치 부분이 제어권을 가져온다.
		}finally {//return으로 제어권을 반환을 해도 제어권을 무시하고 무조건적으로 실행을 한다.
			System.out.println("무조건적인 실행 구문");

		}
		System.out.println("정상적인 종료");
	} //정상적인 경우 트라이까지 하고 캐치 부분을 건너뛴다.
	//비정상적인 경우에 캐치가 그 부분을 잡아낸다.
}
