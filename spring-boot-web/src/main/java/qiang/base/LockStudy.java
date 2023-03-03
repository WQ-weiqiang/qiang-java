package qiang.base;

import java.util.concurrent.CountDownLatch;

/**
 * 各种锁的实现
 */
public class LockStudy {
    static CountDownLatch c1;

    public static void main(String[] args) {
        multiThread();

        multiThreadSync();

        multiThreadSyncThis();

    }

    private static void multiThreadSync() {
        c1 = new CountDownLatch(2);
        A a = new A();
        long start = System.currentTimeMillis();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                a.increaseSync();
            }

            System.out.println(Thread.currentThread().getName());
            c1.countDown();
        }, "increaseSync1").start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                a.increaseSync();
            }
            System.out.println(Thread.currentThread().getName());
            c1.countDown();
        }, "increaseSync2").start();


        try {
            c1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.num);
        System.out.println("multiThreadSync time: " + (System.currentTimeMillis() - start));
    }

    private static void multiThreadSyncThis() {
        c1 = new CountDownLatch(2);
        A a = new A();
        long start = System.currentTimeMillis();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                a.increaseSyncThis();
            }
            System.out.println(Thread.currentThread().getName());
            c1.countDown();
        }, "increaseSyncThis1").start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                a.increaseSyncThis();
            }
            System.out.println(Thread.currentThread().getName());
            c1.countDown();
        }, "increaseSyncThis2").start();

        try {
            c1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.num);
        System.out.println("multiThreadSyncThis time: " + (System.currentTimeMillis() - start));
    }

    private static void multiThread() {
        c1 = new CountDownLatch(2);
        A a = new A();
        long start = System.currentTimeMillis();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                a.increase();
            }
            System.out.println(Thread.currentThread().getName());
            c1.countDown();
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                a.increase();
            }
            System.out.println(Thread.currentThread().getName());
            c1.countDown();
        }).start();


        try {
            c1.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.num);
        System.out.println("multiThread time: " + (System.currentTimeMillis() - start));

    }


}

class A {
    int num = 0;

    void increase() {
        ++num;
    }

    synchronized void increaseSync() {
        ++num;
    }

    void increaseSyncThis() {
        synchronized (this) {
            ++num;
        }
    }
}
