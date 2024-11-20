package _015simulate;

/**
 * #415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * 
 * 
 */
public class AddStrings {

    public static void main(String[] args) {
        String num1 = "6913259244", num2 = "71103343";
        System.out.println(addStrings(num1, num2)); // 533
    }

    public static String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if (len1 > len2) {
            String temp;
            temp = num1;
            num1 = num2;
            num2 = temp;

            int tempVal;
            tempVal = len1;
            len1 = len2;
            len2 = tempVal;

        }
        for (int i = 0; i < len2 - len1; i++) {
            num1 = "0" + num1;
        }
        String res = "";
        boolean flag = false;
        for (int i = 1; i <= len2; i++) {
            int sum = num1.charAt(len2 - i) + num2.charAt(len2 - i) - '0';
            if (flag) {
                sum++;
                flag = false;
            }
            if (sum > '9') {
                flag = true;
                sum = sum - 10;
            }
            res = (char) sum + res;
        }
        if (flag) {
            res = "1" + res;
        }
        return res;
    }
}
