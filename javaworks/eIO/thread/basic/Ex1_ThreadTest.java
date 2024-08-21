package thread.basic;

public class Ex1_ThreadTest {

    public static void main(String[] args) {
        MakeCar1 work1 = new MakeCar1("차틀만들기");
        work1.start(); // run() 호출

        MakeCar1 work2 = new MakeCar1("엔진부착");
        work2.start(); // run() 호출

        System.out.println("작업종료");
    }
}


