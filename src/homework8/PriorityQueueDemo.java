package homework8;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String args[]) {

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        pQueue.add(300);
        pQueue.add(20);
        pQueue.add(15);
        pQueue.add(110);
        pQueue.add(1);

        System.out.println(pQueue);

        System.out.println(pQueue.peek());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.peek());
        System.out.println(pQueue);

    }
}
