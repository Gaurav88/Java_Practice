/**
 * Created by Gaurav-PC on 21-05-2017.
 */
public class ThreeThreadsAlternate {

    volatile int val = 1;

    public static void main(String[] args) {
        ThreeThreadsAlternate obj = new ThreeThreadsAlternate();
        OneThread obj1 = new OneThread(obj);
        TwoThread obj2 = new TwoThread(obj);
        ThreeThread obj3 = new ThreeThread(obj);
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        Thread t3 = new Thread(obj3);
        t1.start();
        t2.start();
        t3.start();
    }


}

class OneThread implements Runnable {
    ThreeThreadsAlternate obj;

    public OneThread(ThreeThreadsAlternate obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i = i + 3) {
            System.out.println("First: " + i);
            obj.val++;
            while (obj.val < i + 3) {
                if(obj.val == 10){
                    break;
                }
            }


        }
    }
}

class TwoThread implements Runnable {
    ThreeThreadsAlternate obj;

    public TwoThread(ThreeThreadsAlternate obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int i = 2; i < 10; i = i + 3) {
            System.out.println("Second: " + i);
            obj.val++;
            while (obj.val < i + 3) {
                if(obj.val == 10){
                    break;
                }
            }


        }
    }
}

class ThreeThread implements Runnable {
    ThreeThreadsAlternate obj;

    public ThreeThread(ThreeThreadsAlternate obj) {
        this.obj = obj;

    }

    @Override
    public void run() {
        for (int i = 3; i < 10; i = i + 3) {
            System.out.println("Third: " + i);
            obj.val++;
            while (obj.val < i + 3) {
                if(obj.val == 10){
                    break;
                }
            }


        }
    }
}