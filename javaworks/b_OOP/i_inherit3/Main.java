package i_inherit3;

public class Main {

	public static void main(String[] args) {

		Item[] a = method(); //리턴 받을 값을 메모리를 확보하기 위해서 변수를 만들어 줘야한다.
		System.out.println("-------------------------------------");
		for(int i = 0; i<a.length; i+=1) {
			a[i].output();
			// 다 각자 자식 클래스에 있는 output 들이 출력이 되고 있다. 다형성
			//오버라이딩이 되어 있기 때문에 다른 값들도 다 나오고 있다.
			System.out.println("===================================");
		}
	}

	static Item [] method(){
		Book b = new Book("00","제목없음","작가미상","미출판사");
		Dvd d = new Dvd();
		Cd c = new Cd();
		Item [] a = new Item[3];
		a[0] = b;
		a[1] = c;
		a[2] = d;
		
		return a;

	}
}
