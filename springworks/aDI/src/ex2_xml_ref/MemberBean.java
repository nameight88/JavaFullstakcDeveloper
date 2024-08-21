package ex2_xml_ref;

public class MemberBean {
	
	private String name;
	private int age;
	private String message;
	
	
	public void output() {
		System.out.println(name+"["+age+"]"+message);
	}
	//생성자 함수 생성(constructor)
	
		public MemberBean() {//기본 생성자 함수 생성
			
		}
		public MemberBean(String name, int age, String message) {
			super();
			this.name = name;
			this.age = age;
			this.message = message;
		}

		//setter
		public void setName(String name) {
			this.name = name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public void setMessage(String message) {
			this.message = message;
		}


}
