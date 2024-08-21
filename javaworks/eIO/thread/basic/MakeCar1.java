package thread.basic;

public class MakeCar1 extends Thread {
    String work;

    MakeCar1(String work) {
        this.work = work;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(work + " 작업중");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace(); // 예외 처리
            }
        }
    }
}
