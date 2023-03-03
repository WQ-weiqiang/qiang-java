package qiang.base.blockthread;

public class JoinBlock {


    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            //子线程进行字符串连接操作
            String s = "";
            for (int i = 0; i < 10000; i++) {
                s += "Java";
            }
            System.out.println("t Over");
        });

        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t.start();
        try {
            t.join();//注意这里
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - Start:" + (end - start));

    }
}
