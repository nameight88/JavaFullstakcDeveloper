package e_info;

//데이터를 주고 받음
// VO ( Value object)
// DTO( Data Transfer Object)
public class InfoVo {
	String name;
	String id;
	String tel;
	String home;
	String gender;
	int age;
	// [1] 생성자로 지정
	public InfoVo() {} // 기본 생성자 함수 생성
	
	public InfoVo(String name, String id, String tel, String home, String gender, int age) {
		super();
		this.name = name;
		this.id = id;
		this.tel = tel;
		this.home = home;
		this.gender = gender;
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "InfoVo [name=" + name + ", id=" + id + ", tel=" + tel + ", home=" + home + ", gender=" + gender
				+ ", age=" + age + "] \n";
	}

	// [2] setter 지정
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


}
