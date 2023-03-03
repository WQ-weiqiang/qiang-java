package qiang.base.leetcode;

public class L482 {


    public static void main(String[] args) {
        String str = "---";
        int k = 2;

        int count = 0;


        StringBuilder newStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != '-') {
                newStr.append(str.charAt(i));
                count++;
                if (count % k == 0) {
                    newStr.append("-");

                }

            }
        }


        if (newStr.length() > 0 && newStr.charAt(newStr.length() - 1) == '-') {
            newStr.deleteCharAt(newStr.length() - 1);
        }

        System.out.println(newStr.reverse().toString().toUpperCase());
    }
}
