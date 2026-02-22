import java.util.*;
import java.io.*;

public class Main {
	static int V,E,start,edgePtr=0;
	static int[] to,w,next,head;
	static long[] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		head = new int[V+1];
		dist = new long[V+1];
		to = new int[E];
		w = new int[E];
		next = new int[E];
		final int INF=1_000_000;
		Arrays.fill(dist,INF);
		Arrays.fill(head, -1);
		start = Integer.parseInt(br.readLine());
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int ww=Integer.parseInt(st.nextToken());
			to[edgePtr]=v;
			w[edgePtr]=ww;
			next[edgePtr]=head[u];
			head[u]=edgePtr++;
		}
		dist[start]=0;
		
		Queue<Long> queue = new PriorityQueue<>();
		queue.offer((long)start);
		while(!queue.isEmpty()) {
			long curV = queue.poll();
			int u=(int)curV;
			int d=(int)(curV>>>32);
			if(d!=dist[u]) continue;
			for(int e=head[u];e!=-1;e=next[e]) {
				int nextv=to[e];
				if(dist[nextv]>dist[u]+w[e]) {
					dist[nextv]=dist[u]+w[e];
					queue.offer((dist[nextv]<<32)|nextv);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=V;i++) {
			if(dist[i]==INF) sb.append("INF").append("\n");
			else sb.append(dist[i]).append("\n");
		}
		System.out.print(sb);
	}
}
