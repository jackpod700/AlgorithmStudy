import java.util.*;
import java.io.*;

public class Main {
    static final long DIV = 1000000007;
    static int N, M, K;
    static long[] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 비재귀 세그먼트 트리는 N * 2 크기의 배열로 충분합니다.
        tree = new long[N * 2];
        
        // 1. 리프 노드 입력받기 (인덱스 N부터 2N-1까지)
        for (int i = 0; i < N; i++) {
            tree[N + i] = Long.parseLong(br.readLine());
        }
        
        // 2. 부모 노드 초기화 (인덱스 N-1부터 1까지 역순으로)
        for (int i = N - 1; i > 0; i--) {
            // i << 1 은 왼쪽 자식(i * 2), i << 1 | 1 은 오른쪽 자식(i * 2 + 1)
            tree[i] = (tree[i << 1] * tree[i << 1 | 1]) % DIV;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            
            if (type == 1) {
                // b번째 수 변경 (0-based 인덱스로 맞추기 위해 b-1 전달)
                int b = Integer.parseInt(st.nextToken()) - 1;
                long c = Long.parseLong(st.nextToken());
                update(b, c);
            } else {
                // b부터 c까지의 곱 (0-based 인덱스로 맞추기 위해 b-1, c-1 전달)
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                sb.append(mul(b, c)).append("\n");
            }
        }
        System.out.print(sb);
    }
    
    // 비재귀 Update
    static void update(int index, long value) {
        // 실제 트리의 리프 노드 인덱스로 이동
        index += N;
        tree[index] = value;
        
        // 부모 노드로 올라가며 갱신 (index를 2로 나누면서 루트 1번까지)
        for (index >>= 1; index > 0; index >>= 1) {
            tree[index] = (tree[index << 1] * tree[index << 1 | 1]) % DIV;
        }
    }
    
    // 비재귀 구간 곱 Query
    static long mul(int left, int right) {
        long result = 1;
        // 실제 트리의 리프 노드 인덱스로 이동
        left += N;
        right += N;
        
        while (left <= right) {
            // left가 홀수이면 부모의 오른쪽 자식이라는 뜻이므로, 
            // 현재 노드 값을 곱해주고 left 범위를 한 칸 오른쪽으로 좁힘
            if ((left & 1) == 1) {
                result = (result * tree[left++]) % DIV;
            }
            // right가 짝수이면 부모의 왼쪽 자식이라는 뜻이므로, 
            // 현재 노드 값을 곱해주고 right 범위를 한 칸 왼쪽으로 좁힘
            if ((right & 1) == 0) {
                result = (result * tree[right--]) % DIV;
            }
            // 부모 노드로 이동 (2로 나눔)
            left >>= 1;
            right >>= 1;
        }
        return result;
    }
}