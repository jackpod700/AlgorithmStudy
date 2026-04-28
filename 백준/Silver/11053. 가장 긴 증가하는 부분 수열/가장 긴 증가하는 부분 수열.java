import java.util.*;
import java.io.*;

public class Main {
	static int N,max=1;
	static int[] A;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		A=new int[N];
		dp= new int[N];
		dp[N-1]=1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=N-2;i>=0;i--) {
			dp[i]=1;
			for(int j=i+1;j<N;j++) {
				if(A[i]>=A[j]) continue;
				if(dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
				}
			}
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
