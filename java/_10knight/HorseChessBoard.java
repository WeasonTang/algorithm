package _10knight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.awt.Point;

public class HorseChessBoard {
    // row
    private static int X;
    // column
    private static int Y;

    // 标记棋盘 点  是否被访问过
    private static boolean visited[];
    // 标记棋盘是否所有位置被访问过
    private static boolean finished;
    
    public static void main(String[] args) {
        // 测试周游算法
        X = 8;
        Y = 8;
        // 马儿 初始位置 行 列
        int row = 0; 
        int column = 0;
        // 创建棋盘
        int[][] chessboard = new int[X][Y];
        visited= new boolean[X * Y];
        long start = System.currentTimeMillis();

        traversalChessBoard(chessboard, row, column, 1);

        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start) + "毫秒");

        // 输出棋盘最后情况
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }


    //     6	7		
    //  5 	    	0	
    //  4	 🐎     1				
    //     3	2		
    /**
     * 功能：根据当前位置(Point对象)，计算马儿还能走哪些位置(Point),并放入到一个集合中(ArrayList),最多8个位置
     * 
     * @param curPoint
     * @return
     */
    public static List<Point> next(Point curPoint) {
        List<Point> ps = new ArrayList<Point>();
        Point p1 = new Point();
        // 马可以走 5
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        // 6
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        // 7
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        // 0
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        // 1
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        // 2
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        // 3
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        // 4
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    // 根据当前这一步的所有下一步的选择位置，进行非递减排序
    public static void sort(List<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }          
        });
    }

    /**
     * 
     * @param chessboard 棋盘
     * @param row 行 从0开始
     * @param column 列 从0开始
     * @param step 第几步
     */
    public static void traversalChessBoard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        visited[row * X + column] = true;

        // 获取下一个位置
        List<Point> ps = next(new Point(column, row));

        // 根据当前这一步的所有下一步的选择位置，进行非递减排序
        // ps = ps.stream()
        //     .sorted((o1, o2) -> next(o1).size() - next(o2).size())
        //     .collect(Collectors.toList());
        // ps.sort((o1, o2) -> next(o1).size() - next(o2).size());
        sort(ps);

        while (!ps.isEmpty()) {
            // 去除下一个可以走的位置
            Point nexPoint = ps.remove(0); 
            // 判断是否访问过
            if (!visited[nexPoint.y * X + nexPoint.x]) {
                // 不能用 ++step 回溯的时候step会不对
                traversalChessBoard(chessboard, nexPoint.y, nexPoint.x, step + 1);
            }
        }

        // 1.棋盘目前位置，没有走完 递归中
        // 2，棋盘处于回溯过程 
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }
}
