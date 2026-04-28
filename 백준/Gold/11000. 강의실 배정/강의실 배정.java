import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] lectures = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            lectures[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 1. 시작 시간 기준으로 오름차순 정렬 (시작 시간이 같다면 종료 시간 기준)
        Arrays.sort(lectures, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        // 2. 종료 시간을 저장하는 우선순위 큐 (가장 빨리 끝나는 시간이 맨 위로)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 첫 번째 강의의 종료 시간을 넣고 시작
        pq.add(lectures[0][1]);

        for (int i = 1; i < n; i++) {
            // 3. 가장 빨리 끝나는 강의실의 종료 시간 <= 현재 강의의 시작 시간
            // 강의실을 이어서 사용할 수 있는 경우
            if (pq.peek() <= lectures[i][0]) {
                pq.poll(); // 기존 강의실의 종료 시간을 갱신하기 위해 제거
            }
            // 새로운 종료 시간 추가 (이어서 쓰는 경우든, 새로 만드는 경우든 추가함)
            pq.add(lectures[i][1]);
        }

        // 큐의 크기가 곧 필요한 강의실의 개수
        System.out.println(pq.size());
    }
}