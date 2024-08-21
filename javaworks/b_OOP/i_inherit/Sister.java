package i_inherit;
/*
 * 
 * 
 * 클래스 상속관계
 * [개발시 관점]
 * 	-부모의 맴버 사용
 * 	-부모의 맴버가 없으면 그냥 추가해서 사용
 * 
 * 부모의 맴버가 있는데 재정의(변경)
 *  ->메소드명을 동일하게 구현
 *  	인자와 리턴형이 동일하다.(오버로딩과 다르다)
 *  	=>overriding
 *  
 *  
 *  [클래스 설계관점]
 *  	-클래스의 공통적인 부분을 부모클래스로 생성
 *  	-클래스의 고유부분을 자식클래스로 생성
 *  	-
 *  
 *  [참고]오버로딩
 *  	
 */
public class Sister extends Mom{
	Sister(){
		System.out.println("자식클래스 생성");
	}
	public void gene(){
		System.out.println("자식은 자식");
	}
	public void sytudy() {
		System.out.println("직업은 학생");
	}
}
