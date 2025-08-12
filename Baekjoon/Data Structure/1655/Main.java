/*
첫번째 방법
linked list를 사용하여 값을 올바른 위치에 삽입 = O(n)
중간값의 index를 계산하여 linked list에서 찾기 = O(n)
총 O(n^2)

두번째 방법
우선순위 큐를 두개 둠
왼쪽에는 중간값보다 작은 값들, 오른쪽에는 중간값보다 큰 값들
왼쪽은 최대 힙, 오른쪽은 최소 힙
중간값은 왼쪽의 우선순위 큐의 가장 큰 값이어야함
    따라서 왼쪽큐는 오른쪽큐보다 노드가 하나 더 많거나 같아야함
삽입이 올바르게 완료되었다고 가정했을 때 왼쪽큐의 가장 큰 값을 출력하면 됨

삽입할때 경우의 수
1. 삽입할 수가 왼쪽 큐의 최대값보다 작거나 같음
    a. 왼쪽큐의 사이즈가 오른쪽큐와 같음
        왼쪽큐에 새로운 수를 삽입
    b. 왼쪽큐의 사이즈가 오른쪽큐보다 하나 더 많음
        왼쪽큐에서 최대값을 제거하고 그 값을 오른쪽 큐에 삽입
        왼쪽큐에 새로운 수를 삽입

2. 삽입할 수가 왼쪽 큐의 최대값보다 큼
    a. 왼쪽큐의 사이즈가 오른쪽큐와 같음
        오른쪽큐에 새로운 수를 삽입
        오른쪽큐에서 최소값을 제거하고 그 값을 왼쪽 큐에 삽입
    b. 왼쪽큐의 사이즈가 오른쪽큐보다 하나 더 많음
        오른쪽큐에 새로운 수를 삽입

삽입 시간복잡도 = O(log n)
값을 읽어오는것은 루트노드만 읽어오면 됨 = O(1)
*/

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
