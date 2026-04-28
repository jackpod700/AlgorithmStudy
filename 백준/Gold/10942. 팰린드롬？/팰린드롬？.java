import java.util.*;
import java.io.*;
public class Main {
	static int N,M;
	static int[] num;
	static int[][] d;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		num=new int[N];
		d=new int[N][N];
		for(int i=0;i<N;i++)Arrays.fill(d[i], -1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i]=Integer.parseInt(st.nextToken());
			d[i][i]=1;
		}
		for(int start=0;start<N;start++) {
			for(int end=start+1;end<N;end++) {
				d[start][end]=dp(start,end);
			}
		}
		StringBuilder sb = new StringBuilder();
		M=Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			sb.append(d[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]).append("\n");
		}
		System.out.println(sb);
	}
	
	static int dp(int start,int end) {
		if(d[start][end]!=-1) return d[start][end];
		if(end-start==1) {
			if(num[start]==num[end])d[start][end]=1;
			else d[start][end]=0;
			return d[start][end];
		}
		if(num[start]==num[end]&&dp(start+1,end-1)==1)d[start][end]=1;
		else d[start][end]=0;
		return d[start][end];
	}
}
