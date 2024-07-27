package _02divideandconquer;

public class Hanoitower {
    private static int count = 0;

    public static void main(String[] args) {
        // 验证
        hanoitower(5, 'A', 'B', 'C');
    }

    // 汉诺塔移动方法
    // 使用分治算法
    /**
     * 
     * @param num 盘子个数
     * @param a   最开始盘子位置
     * @param b   移动需要借助的位置
     * @param c   移动后最终盘子位置
     */
    public static void hanoitower(int num, char a, char b, char c) {
        // 如果只有一个盘
        if (num == 1) {
            System.out.println("第" + ++count + "步从 " + a + "->" + c);
            return;
        }

        // 当n >= 2,
        // 思想：总是看成两个盘 1.最下面一个盘 2.上面所有盘
        // A塔和B塔是等价的
        // 步骤：
        // 1. 先把 最上面的所有盘 A->B, 移动过程会使用到C
        hanoitower(num - 1, a, c, b);
        // 2. 把最下面的盘子 A->C
        System.out.println("第" + (count += 1) + "步从 " + a + "->" + c);
        // 3. 把B塔的所有盘 B->C , 移动过程使用到A
        hanoitower(num - 1, b, a, c);

    }
}
