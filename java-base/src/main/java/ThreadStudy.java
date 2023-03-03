import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadStudy {
    public static void main(String[] args) {

        //继承Thread
        MyThread t1 = new MyThread();
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();

        //实现 Runnable
        new Thread(new MyThread2(), "runnable1").start();
        new Thread(new MyThread2(), "runnable2").start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }

        //实现Callable

        FutureTask futureTask = new FutureTask(new MyThread3());
        new Thread(futureTask, "callThread").start();

        try {

            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //实现Callable 泛型
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(new MyThread4());
        new Thread(futureTask1, "callThread2").start();


        int a = 100;
        int b = 0;

        //b = futureTask.get();//要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致堵塞，直到计算完成
        while (!futureTask1.isDone()) {//当futureTask完成后取值
            try {
                b = futureTask1.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Result=" + (a + b));


        //使用线程池
        ExecutorService service = new ThreadPoolExecutor(
                3,
                10,
                5000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()

        );

        //输出class java.util.concurrent.ThreadPoolExecutor
        System.out.println(service.getClass());
        service.execute(new MyThread2());
        service.execute(new MyThread2());
        //2. 执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        //service.submit(Callable callable);//适合使用于Callable
        //3. 关闭连接池
        service.shutdown();

        //匿名内部类


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }, "inner class").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }, "inner lambda class").start();
    }


}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

class MyThread3 implements Callable {
    @Override
    public Object call() throws Exception {
        int num = 0;
        for (int i = 0; i <= 5; i++) {
            num += i;
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
        return num;
    }
}

class MyThread4 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
        return 1024;
    }
}