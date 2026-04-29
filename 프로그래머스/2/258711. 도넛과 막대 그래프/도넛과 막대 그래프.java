import java.util.*;

class Solution {
    // static 키워드 제거 (테스트 케이스 간 상태 간섭 방지)
    boolean[] visited;
    Node[] nodes;
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int root = 0;
        int maxNode = 0; // 최대 노드 번호 추적

        // 초기화 (테스트 케이스마다 새로 할당되도록 보장)
        visited = new boolean[1_000_001];
        nodes = new Node[1_000_001];

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            
            maxNode = Math.max(maxNode, Math.max(src, dest));
            
            if (nodes[src] == null) nodes[src] = new Node(src);
            if (nodes[dest] == null) nodes[dest] = new Node(dest);
            
            nodes[src].out++;
            nodes[src].outNodes.add(nodes[dest]);
            nodes[dest].in++;
            nodes[dest].inNodes.add(nodes[src]);
        }
        
        // 1,000,000까지 도는 대신 발견된 최대 노드까지만 순회
        for (int i = 1; i <= maxNode; i++) {
            Node node = nodes[i];
            // null 체크 필수 (NullPointerException 방지)
            if (node != null && node.in == 0 && node.out >= 2) {
                visited[i] = true;
                answer[0] = root = i;
                break;
            }
        }
        
        for (Node node : nodes[root].outNodes) {
            node.in--;
            visited[node.index] = true;
            bfs(node, answer);
        }

        return answer;
    }
    
    public void bfs(Node start, int[] answer) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        int type = 1; // 1: 도넛, 2: 막대, 3: 8자
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            if (cur.out == 0) type = 2;
            else if (cur.in == 2 && cur.out == 2) type = 3;
            
            for (Node next : cur.outNodes) {
                if (!visited[next.index]) {
                    visited[next.index] = true;
                    queue.offer(next);
                }
            }
            
            for (Node next : cur.inNodes) {
                if (!visited[next.index]) {
                    visited[next.index] = true;
                    queue.offer(next);
                }
            }
        }
        
        answer[type]++;
    }
    
    class Node { // static 중첩 클래스도 무관하나, 인스턴스에 속하도록 static 제거
        int index, in, out;
        List<Node> inNodes, outNodes;
        
        public Node(int index) {
            this.index = index;
            this.in = 0;
            this.out = 0;
            this.outNodes = new ArrayList<>();
            this.inNodes = new ArrayList<>();
        }
    }
}