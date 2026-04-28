import java.util.*;
import java.io.*;
public class Main{
	static int N,M,result;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		dp = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int small=Integer.parseInt(st.nextToken());
			int big=Integer.parseInt(st.nextToken());
			dp[small][big]=1;
		}
		
		for(int i=1;i<=N;i++) {
			for(int a=1;a<=N;a++) {
				for(int b=1;b<=N;b++) {
					if(dp[a][i]==1&&dp[i][b]==1) dp[a][b]=1;
				}
			}
		}
		for(int i=1;i<=N;i++) {
			int cnt=0;
			for(int j=1;j<=N;j++) {
				if(i==j)continue;
				if(dp[i][j]==0&&dp[j][i]==0) break;
				cnt++;
			}
			if(cnt==N-1)result++;
		}
		System.out.println(result);
	}

}
