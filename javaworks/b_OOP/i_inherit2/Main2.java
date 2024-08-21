package i_inherit2;

public class Main2 {
	public static void main(String[]args) {
//		Book b1 = new Book();
//		b1.output();

		//부모 클래스가 먼저 메모리에 생성이 되고 그 후에 자식 클래스가 나오기 때문에
		//출력이 될때 부모 기본생성자부터 나오게 된다.
		
		/*
		 * 부모 인자 생성자 // 처음에 메모리에 부모 클래스 생성
		 * 자식 인자생성자 // this함수가 자식클래스에서 호출을 했기 때문에 출력
		 * 자식 기본생성자 //
		 * 번호: 0000
		 * 제목: 제목없음
		 * 작가: null
		 * 출판사: 미출판사
		 */
		
		
		Book b2 = new Book("1111","자바","김쌤","여기");
		b2.output();
	}
}
