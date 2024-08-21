package thread.basic;


class Count{
	int i;
	void increment() {
		synchronized(this) {
			i++;
		}
	}

}
class ThreadCount extends Thread{
	Count cnt;
	ThreadCount(Count cnt){
		this.cnt = cnt;
	}
	public void run() {
		for(int i=0;i<100000000;i+=1) {
			cnt.increment();
		}
	}

}
public class Ex7_SychTest {


	public static void main(String[] args) {
		Count count = new Count();
		ThreadCount tc1 = new ThreadCount(count);
		tc1.start();

		ThreadCount tc2 = new ThreadCount(count);
		tc2.start();
		try {
			tc1.join();
			tc2.join();
		}catch(Exception e) {

		}System.out.println("i의 결과:" +count.i);
		//제어권이 총 3개 출력하는 것과 숫자가 증가하는 함수가 각각 작동중
	}
}
