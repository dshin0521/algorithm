package Design;

import java.util.concurrent.Semaphore;

/**
 * Suppose we have a class:
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 *
 * The same instance of Foo will be passed to three different threads.
 * Thread A will call first(), thread B will call second(), and thread C will call third().
 * Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 *
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 *
 * Example 2:
 *
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 *
 * Note:
 *
 * We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
 */
public class PrintInOrder {

//    private Semaphore s2;
//    private Semaphore s3;
//
//    public PrintInOrder() {
//        s2 = new Semaphore(0);
//        s3 = new Semaphore(0);
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        s2.release();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        s2.acquire();
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        s3.release();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        s3.acquire();
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }

//    private boolean oneDone;
//    private boolean twoDone;
//
//    public PrintInOrder() {
//        oneDone = false;
//        twoDone = false;
//    }
//
//    public synchronized void first(Runnable printFirst) throws InterruptedException {
//        printFirst.run();
//        oneDone = true;
//        notifyAll();
//    }
//
//    public synchronized void second(Runnable printSecond) throws InterruptedException {
//        while (!oneDone) {
//            wait();
//        }
//        printSecond.run();
//        twoDone = true;
//        notifyAll();
//    }
//
//    public synchronized void third(Runnable printThird) throws InterruptedException {
//        while (!twoDone) {
//            wait();
//        }
//        printThird.run();
//    }

    private boolean oneDone;
    private boolean twoDone;

    public PrintInOrder() {
        oneDone = false;
        twoDone = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            printFirst.run();
            oneDone = true;
            this.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (!oneDone) {
                this.wait();
            }
            printSecond.run();
            twoDone = true;
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (!twoDone) {
                this.wait();
            }
            printThird.run();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable first = () ->  {
            System.out.println("first");
        };

        Runnable second = () -> {
            System.out.println("second");
        };

        Runnable third = () -> {
            System.out.println("third");
        };

        PrintInOrder printInOrder = new PrintInOrder();

        Thread t1 = new Thread(() -> {
            try {
                printInOrder.second(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                printInOrder.first(first);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                printInOrder.third(third);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t3.start();
        t2.start();
        t1.start();
    }
}