import java.util.*;
import java.io.*;
public class Main {
	static final int INF=100000000;
	static int N,M,edgeptr,start,end;
	static int[] next,head,to,w;
	static long[] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		dist=new long[N+1];
		head=new int[N+1];
		to=new int[M];
		w=new int[M];
		next=new int[M];
		Arrays.fill(dist, INF);
		Arrays.fill(head, -1);
		StringTokenizer st;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int ww=Integer.parseInt(st.nextToken());
			to[i]=v;w[i]=ww;
			next[i]=head[u];
			head[u]=i;
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dist[start]=0;
		Queue<Long> queue = new PriorityQueue<>();
		queue.offer((long)start);
		while(!queue.isEmpty()) {
			long cur=queue.poll();
			int u=(int)cur;
			int d=(int)(cur>>>32);
			if(d!=dist[u])continue;
			for(int e=head[u];e!=-1;e=next[e]) {
				int nextv=to[e];
				if(dist[nextv]>dist[u]+w[e]) {
					dist[nextv]=dist[u]+w[e];
					queue.offer((dist[nextv]<<32)|nextv);
				}
			}
		}
		System.out.println(dist[end]);
	}
}
