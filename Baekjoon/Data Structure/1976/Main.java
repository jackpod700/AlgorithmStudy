/*
 BFS를 이용하여 연결되어있는 노드의 집합을 구한다
 여행계획에 서로다른 집합의 노드가 있다면 여행계획을 수행할 수 없다
*/
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n,m;
    static int[][] edges;
    static int[] travelPlan;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        n = read(); // 노드의 개수
        m = read(); // 여행 계획에 포함된 노드의 개수
        edges = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edges[i][j] = read(); // 간선 정보 입력
            }
        }
        travelPlan = new int[m];
        for (int i = 0; i < m; i++) {
            travelPlan[i] = read() - 1; // 여행 계획 입력 (0-indexed)
        }

        // 노드 초기화
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        bfs();
        check();
    }

    static void bfs(){
        int group = 0, nodeCount = 0;
        Queue<Integer> bfsQueue = new LinkedList<>();
        int startNode = nodes[0].name;
        while(nodeCount<n){
            if (nodes[startNode].group != -1) {
                // 이미 그룹이 지정된 노드라면 다음 노드로 이동
                startNode++;
                continue;
            }
            bfsQueue.add(startNode);
            nodes[startNode].group = group;
            nodeCount++;
            while(!bfsQueue.isEmpty()) {
                int currentNode = bfsQueue.poll();
                for (int i = 0; i < n; i++) {
                    if (edges[currentNode][i] == 1 && nodes[i].group == -1) {
                        // 연결된 노드가 아직 그룹이 지정되지 않았다면 BFS 큐에 추가
                        bfsQueue.add(i);
                        nodes[i].group = group;
                        nodeCount++;
                    }
                }
            }
            group++;
        }
    }

    static void check(){
        // 여행 계획에 포함된 노드들의 그룹을 확인
        int travelGroup = nodes[travelPlan[0]].group;
        for (int i = 1; i < m; i++) {
            if (nodes[travelPlan[i]].group != travelGroup) {
                // 여행 계획에 포함된 노드가 서로 다른 그룹에 속한다면
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static int read() throws IOException {
        int c,n=System.in.read()&15;
        while((c=System.in.read())>32)
            n = (n<<3) + (n<<1) + (c&15);
        return n;
    }
}

class Node {
    public char name;
    public int group;

    public Node(int name) {
        this.name = (char) name;
        this.group = -1; // 초기 그룹은 -1로 설정
    }
}