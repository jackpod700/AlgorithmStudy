import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] data = new int[n][2];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken()); // 행 (r)
            data[i][1] = Integer.parseInt(st.nextToken()); // 열 (c)
        }
        
        // dp[i][j]: i번째 행렬부터 j번째 행렬까지 곱했을 때의 최소 연산 횟수
        int[][] dp = new int[n][n];

        // term: 구간의 길이 (1이면 두 행렬 곱셈, 2면 세 행렬 곱셈...)
        for(int term = 1; term < n; term++) {
            for(int i = 0; i < n - term; i++) { // i: 시작 행렬 인덱스
                int j = i + term;               // j: 끝 행렬 인덱스
                
                dp[i][j] = Integer.MAX_VALUE;
                
                // k: 분할 지점 (i ~ k) * (k+1 ~ j)
                for(int k = i; k < j; k++) {
                    // 비용 = 왼쪽구간비용 + 오른쪽구간비용 + 합칠때비용
                    // 합칠때비용 = (i의 행) * (k의 열) * (j의 열)
                    // 주의: data[k][1] (k의 열) == data[k+1][0] (k+1의 행)
                    int cost = dp[i][k] + dp[k+1][j] + (data[i][0] * data[k][1] * data[j][1]);
                    
                    if(cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        
        System.out.println(dp[0][n-1]);
    }
}