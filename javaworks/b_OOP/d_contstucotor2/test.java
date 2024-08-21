package d_contstucotor2;

public class test {
	 class MyClass{
		String name;
		MyClass() {
			this("이름없음");
			System.out.println("생성자 실행");
			
		}
		public MyClass( String name ) {
			this.name = name;
		}  
		public void main(String[] args) {
			MyClass  my = new MyClass();
		}
	}
}
