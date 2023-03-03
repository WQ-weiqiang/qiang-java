package qiang.base.blockthread;

public class ForBlock {

    public static void main(String[] args) {
        extracted();

        //防止线程持续消耗资源，引入线程睡眠
        extracted1();
    }

    private static void extracted() {
        Thread t = new Thread(() -> {
            //子线程进行字符串连接操作
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            System.out.println("t Over");
        });
        //开始计时
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t.start();
        long end = 0;
        while (t.isAlive() == true) {//t.getState() != State.TERMINATED这两种判断方式都可以
            end = System.currentTimeMillis();
        }
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));
    }

    private static void extracted1() {
        Thread t = new Thread(() -> {
            //子线程进行字符串连接操作
            String s = "";
            for (int i = 0; i < 10000; i++) {
                s += "Java";
            }
            System.out.println("t Over");
        });
        //开始计时
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t.start();
        long end = 0;
        while (t.isAlive() == true) {
            end = System.currentTimeMillis();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));
    }
}
