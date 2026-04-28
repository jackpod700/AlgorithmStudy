import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
    static PriorityQueue<Integer> rightQueue = new PriorityQueue<>(); // 최소 힙
    public static void main(String[] args) throws IOException {
        int n=read();
        
        int firstnum = read();
        leftQueue.offer(firstnum);
        System.out.println(firstnum); // 첫 번째 중간값 출력
        
        for(int i=1; i<n; i++) {
            int num = read();
            insert(num);
            System.out.println(leftQueue.peek());
        }
    }

    static int read() throws IOException {
        int b;
        do b = System.in.read(); while (b <= 32);
        int n = 0; boolean isNeg = false;
        if (b == 45) {
            isNeg = true;
            b = System.in.read();
        }
        do {
            n = (n << 3) + (n << 1) + (b & 15);
            b = System.in.read();
        } while (b > 47 && b < 58);
        return isNeg ? -n : n;
    }

    static void insert(int num) {
        if (num <= leftQueue.peek()) {
            if (leftQueue.size() != rightQueue.size()) {
                rightQueue.offer(leftQueue.poll());
            }
            leftQueue.offer(num);
        } else {
            rightQueue.offer(num);
            if (leftQueue.size() != rightQueue.size()) {
                leftQueue.offer(rightQueue.poll());
            }
        }
    }
}
