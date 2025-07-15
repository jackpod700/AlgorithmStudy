import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int N,K;
    static int[] W,V;
    static int[] dp; //바로 이전상태만 참조하므로 1차원 배열로 구현 가능

    public static void main(String[] args) throws IOException {
        read();
        for(int i=0; i<N; i++){
            for (int k=K;k>=0;k--){
                if(W[i]<=k){
                    dp[k] = Math.max(dp[k], dp[k-W[i]] + V[i]);
                }
            }
        }
        System.out.println(dp[K]);
    }

    static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        W = new int[N];
        V = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int [K+1];
    }
}