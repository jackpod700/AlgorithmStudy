import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Node>[] graph;
    static int[] dist;
    static int[] parent;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }
        
        dist = new int[N + 1];
        parent = new int[N + 1];
        
        // 1. 초기 최단 경로 탐색 및 parent 배열 기록
        dijkstra(-1, -1);
        
        // 2. parent 배열을 이용해 최단 경로 상의 간선 역추적
        List<int[]> shortestPathEdges = new ArrayList<>();
        int curr = N;
        while (curr != 1) {
            int p = parent[curr];
            shortestPathEdges.add(new int[]{p, curr});
            curr = p;
        }
        
        int maxDist = 0;
        
        // 3. 최단 경로에 포함된 간선만 하나씩 차단하며 Dijkstra 재수행
        for (int[] edge : shortestPathEdges) {
            maxDist = Math.max(maxDist, dijkstra(edge[0], edge[1]));
        }
        
        System.out.println(maxDist);
    }

    static int dijkstra(int banU, int banV) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.clear();
        
        dist[1] = 0;
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.to;
            int d = curr.weight;
            
            if (dist[u] < d) continue;
            
            // 제외할 간선이 있는 재탐색의 경우, 목적지 도달 시 즉시 종료 (Early Exit)
            if (banU != -1 && u == N) return d;
            
            for (Node next : graph[u]) {
                int v = next.to;
                int w = next.weight;
                
                // 지정된 간선은 양방향 모두 통과하지 않음
                if ((u == banU && v == banV) || (u == banV && v == banU)) continue;
                
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    // 첫 탐색(banU == -1)일 때만 parent 갱신
                    if (banU == -1) parent[v] = u;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }
        
        return dist[N];
    }
    
    static class Node implements Comparable<Node> {
        int to, weight;
        
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}