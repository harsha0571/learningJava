
import java.util.Random;

class squareThread implements Runnable {
    int x;

    squareThread(int x) {
        this.x = x;
    }

    public void run() {
        System.out.println("Square thread : " + x * x);
    }
}

class cubeThread implements Runnable {
    int x;

    cubeThread(int x) {
        this.x = x;
    }

    public void run() {
        System.out.println("Cube thread : " + x * x * x);
    }
}

class randomThread implements Runnable {
    Random r;
    Thread t2, t3;

    public void run() {
        int num;
        r = new Random();

        try {
            boolean flag = true;
            int count = 0;
            while (flag) {
                num = r.nextInt(100);
                System.out.println("Main Thread: " + num);

                t2 = new Thread(new squareThread(num));
                t2.start();
                t3 = new Thread(new cubeThread(num));
                t3.start();
                Thread.sleep(1000);
                System.out.println("_____________________________________________");
                count++;
                if (count == 100)
                    flag = false;

            }
        } catch (Exception e) {
            System.out.println("Interrupted " + e);
        }
    }
}

public class mulitThread {

    public static void main(String args[]) {
        Thread t1;
        randomThread obj = new randomThread();
        t1 = new Thread(obj);
        t1.start();

    }
}
