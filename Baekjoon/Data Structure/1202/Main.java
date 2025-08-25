/*
1. 가방을 크기순으로 정렬 O(K log K)
2. 가장 작은 가방부터 확인하여 들어갈 수 있는 보석 중 가장 가치가 높은 보석을 넣는다
  2.1 가방의 크기보다 작은 보석들을 우선순위 큐에 넣는다 O(N log N)
  2.2 우선순위 큐에서 가장 가치가 높은 보석을 꺼내어 가방에 넣는다 O(log N)
3. 모든 가방에 대해 2번 과정을 반복한다
총 시간복잡도 O(K log K + KN log N)
*/

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, K;
        N=read();
        K=read();
        Jewel[] jewels = new Jewel[N];
        int[] C = new int[K];
        for (int i = 0; i < N; i++) {
            int weight = read();
            int value = read();
            jewels[i] = new Jewel(weight, value);
        }
        for (int i = 0; i < K; i++) {
            C[i] = read();
        }
        Arrays.sort(jewels);
        Arrays.sort(C);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long answer = 0;
        int idx = 0;
        for (int i = 0; i < K; i++) {
            while (idx < N && jewels[idx].weight <= C[i]) {
                pq.add(jewels[idx].value);
                idx++;
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }

    static int read() throws IOException {
        int c,n=System.in.read()&15;
        while((c=System.in.read())>32)
            n = (n<<3) + (n<<1) + (c&15);
        return n;
    }
}

class Jewel implements Comparable<Jewel> {
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jewel o) {
        return this.weight - o.weight;
    }
}
