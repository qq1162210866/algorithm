package threadtrain;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ThreadDemo1.java
 * Description: 顺序打印ABC
 *
 * @author Peng Shiquan
 * @date 2021/7/15
 */
public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) printer.printA();
        }, "1").start();
        Thread.sleep(2000);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) printer.printB();
        }, "2").start();
        Thread.sleep(2000);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) printer.printC();
        }, "3").start();
    }

}

class Printer {
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    int signalNum = 1;

    public void printA() {
        if (lock.tryLock()) {
            lock.lock();
            try {
                while (signalNum != 1) {
                    condition1.await();
                }
                System.err.println("目前是线程：" + Thread.currentThread().getName() + "AAAA");
                signalNum = 2;
                condition2.signalAll();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public void printB() {
        if (lock.tryLock()) {
            lock.lock();
            try {
                while (signalNum != 2) {
                    condition2.await();
                }
                System.err.println("目前是线程：" + Thread.currentThread().getName() + "BBBB");
                signalNum = 3;
                condition3.signalAll();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public void printC() {
        if (lock.tryLock()) {
            lock.lock();
            try {
                while (signalNum != 3) {
                    condition3.await();
                }
                System.err.println("目前是线程：" + Thread.currentThread().getName() + "CCCC");
                signalNum = 1;
                condition1.signalAll();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }
}
