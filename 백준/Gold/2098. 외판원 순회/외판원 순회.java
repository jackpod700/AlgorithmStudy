import java.util.*;
import java.io.*;

public class Main {
	static int N,INF=1000000000;
	static int[][] edges,d;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		edges = new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				edges[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		d=new int[N][1<<N];
		for(int i=0;i<N;i++)Arrays.fill(d[i], -1);
		System.out.println(dp(0,1));
		
	}
	
	static int dp(int now, int visited) {
		if(visited==((1<<N)-1)) {
			if(edges[now][0]==0) return INF;
			return edges[now][0];
		}
		if(d[now][visited]!=-1)return d[now][visited];
		
		d[now][visited]=INF;
		for(int i=0;i<N;i++) {
			if((visited&(1<<i))==0&&edges[now][i]!=0) {
				d[now][visited]=Math.min(d[now][visited], dp(i,visited|(1<<i))+edges[now][i]);
			}
		}
		return d[now][visited];
	}
}
