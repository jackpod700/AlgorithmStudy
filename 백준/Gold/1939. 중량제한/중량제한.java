import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Node>[] graph;
    static int minWeight = Integer.MAX_VALUE;
    static int maxWeight = 0;
    static int startIsland, endIsland;

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

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

            minWeight = Math.min(minWeight, w);
            maxWeight = Math.max(maxWeight, w);
        }

        st = new StringTokenizer(br.readLine());
        startIsland = Integer.parseInt(st.nextToken());
        endIsland = Integer.parseInt(st.nextToken());

        int result = 0;
        int left = 1;
        int right = maxWeight;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (bfs(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static boolean bfs(int limit) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        queue.offer(startIsland);
        visited[startIsland] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == endIsland) {
                return true;
            }

            for (Node next : graph[current]) {
                if (!visited[next.to] && next.weight >= limit) {
                    visited[next.to] = true;
                    queue.offer(next.to);
                }
            }
        }

        return false;
    }
}