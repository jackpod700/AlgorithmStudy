/*
* 1. 우선순위 큐를 이용해 오름차순으로 정렬한다
* 2. 가장 작은 두 개의 숫자를 꺼내 합친다
* 3. 합친 숫자를 다시 우선순위 큐에 넣는다
* 4. 이 과정을 n-1번 반복한다
* */

import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n=read(), ans=0, merged;
        PriorityQueue<Integer> pq = new PriorityQueue<>(n);

        for(int i=0;i<n;i++){
            pq.offer(read());
        }

        while(pq.size() > 1) {
            merged = pq.poll() + pq.poll();
            ans += merged;
            pq.offer(merged);
        }

        System.out.println(ans);
    }

    static int read() throws IOException {
        int c,n=System.in.read()&15;
        while((c=System.in.read())>32)
            n = (n<<3) + (n<<1) + (c&15);
        return n;
    }
}
