package _015simulate;

/**
 * #6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * 
 * P A H N
 * A P L S I I G
 * Y I R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 
 * 
 */
public class Convert {

    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println(convert(s1, numRows1));// "PAHNAPLSIIGYIR"

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println(convert(s2, numRows2));// "PINALSIGYAHRPI"

        String s3 = "AB";
        int numRows3 = 1;
        System.out.println(convert(s3, numRows3));//

    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        StringBuilder[] reStrings = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            reStrings[i] = new StringBuilder();

        }
        boolean isPlus = true;
        int i = 0;
        int currentRow = 0;
        while (i < s.length()) {
            reStrings[currentRow].append(s.charAt(i));
            i++;
            if (currentRow == numRows - 1) {
                isPlus = false;
            } else if (currentRow == 0) {
                isPlus = true;
            }
            if (isPlus) {
                currentRow++;
            } else {
                currentRow--;
            }
        }
        StringBuilder resSB = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            resSB.append(reStrings[j]);
        }
        return resSB.toString();
    }
}
