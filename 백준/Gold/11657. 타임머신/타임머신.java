import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static final int INF=1000000000;
	static long[] dist;
	static int[][] edges;
	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		dist=new long[N+1];
		Arrays.fill(dist, INF);
		dist[1]=0;
		edges= new int[M][3];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0]=Integer.parseInt(st.nextToken());
			edges[i][1]=Integer.parseInt(st.nextToken());
			edges[i][2]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int src=edges[j][0];
				int dest=edges[j][1];
				int w=edges[j][2];
				if(dist[src]==INF)continue;
				if(i==N-1&&dist[dest]>dist[src]+w) {
					System.out.println(-1);
					return;
				}
				dist[dest]=Math.min(dist[dest], dist[src]+w);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=2;i<=N;i++) {
			if(dist[i]>=INF) sb.append(-1);
			else sb.append(dist[i]);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
