package qiang.base;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * arraylist 去重
 */
public class ArrayListDitinct {

    private static final ArrayList<String> arrayList = new ArrayList(1000000);


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        //生成随机数组
        for (int i = 0; i < 10000; i++) {
            arrayList.add(RandomStringUtils.random(8, "abcd"));
        }
        System.out.println("random time: " + (System.currentTimeMillis() - startTime));


        //去重
        //stream 去重
        List<String> collect = arrayList.stream().distinct().collect(Collectors.toList());
        System.out.println("stream time: " + (System.currentTimeMillis() - startTime));

        // 循环去重
        ArrayList<String> arrayList1 = new ArrayList(1000000);
        for (String str : arrayList) {
            if (!arrayList1.contains(str)) {
                arrayList1.add(str);
            }
        }
        System.out.println("for    time: " + (System.currentTimeMillis() - startTime));


    }
}
