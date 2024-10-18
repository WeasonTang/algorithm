package _00demoandtest;

import java.util.PriorityQueue;

public class TestOriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        
        minHeap.add(6);
        minHeap.add(2);
        minHeap.add(9);
        minHeap.add(7);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }

}
