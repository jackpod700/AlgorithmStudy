import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] pop;
    static List<Integer>[] adj;
    static int totalPop = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        pop = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pop[i] = Integer.parseInt(st.nextToken());
            totalPop += pop[i];
        }

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        // 1. 부분집합 생성 (비트마스킹)
        // 구역 0을 포함하는 부분집합만 검사하면 중복 계산(A구역 <-> B구역 대칭)을 피할 수 있다.
        // 따라서 i는 1부터 (1<<N)까지 돌되, 0번 비트가 켜져있는 경우만 본다.
        for (int i = 1; i < (1 << N); i++) {
            // A선거구: 비트가 1인 구역들, B선거구: 비트가 0인 구역들
            
            // 최적화: 항상 0번 구역이 포함된 경우만 A선거구로 가정하여 계산량을 절반으로 줄임
            if ((i & 1) == 0) continue; 

            // 두 선거구 모두 최소 1개 이상의 구역을 가져야 함
            // (i & 1) == 0 체크로 인해 A는 공집합일 수 없음.
            // i가 (1<<N)-1 이면 B가 공집합이 되므로 제외해야 함.
            if (i == (1 << N) - 1) continue;

            if (check(i)) {
                calculateDiff(i);
            }
        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    // 연결성 확인 함수
    static boolean check(int mask) {
        // A 선거구 (mask에 포함된 구역들) 연결성 확인
        // mask에 포함된 구역 중 아무거나 하나 찾아서 시작점으로 설정
        int startA = -1;
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) != 0) {
                startA = i;
                break;
            }
        }
        if (!isConnected(mask, startA, true)) return false;

        // B 선거구 (mask에 포함되지 않은 구역들) 연결성 확인
        int startB = -1;
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) == 0) {
                startB = i;
                break;
            }
        }
        if (!isConnected(mask, startB, false)) return false;

        return true;
    }

    // BFS로 연결성 체크
    // type이 true면 mask에 속한 노드들만, false면 속하지 않은 노드들만 탐색
    static boolean isConnected(int mask, int start, boolean type) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        
        q.add(start);
        visited[start] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj[cur]) {
                // 이미 방문했으면 패스
                if (visited[next]) continue;

                // type에 따라 갈 수 있는 곳인지 확인
                // type=true(A구역): mask 비트가 1이어야 함
                // type=false(B구역): mask 비트가 0이어야 함
                if (type) { 
                    if ((mask & (1 << next)) == 0) continue; // 내 구역 아님
                } else { 
                    if ((mask & (1 << next)) != 0) continue; // 내 구역 아님
                }

                visited[next] = true;
                q.add(next);
                count++;
            }
        }

        // 탐색한 노드 개수가 해당 선거구의 실제 총 노드 개수와 같은지 확인
        int actualSize = 0;
        for(int i=0; i<N; i++) {
            if (type) {
                if ((mask & (1<<i)) != 0) actualSize++;
            } else {
                if ((mask & (1<<i)) == 0) actualSize++;
            }
        }
        
        return count == actualSize;
    }

    static void calculateDiff(int mask) {
        int sumA = 0;
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) != 0) {
                sumA += pop[i];
            }
        }
        int sumB = totalPop - sumA;
        min = Math.min(min, Math.abs(sumA - sumB));
    }
}