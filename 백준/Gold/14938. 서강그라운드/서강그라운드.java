import java.util.*;
import java.io.*;
public class Main {
	static final int INF=100000000;
	static int n,m,r;
	static int[] items,dist;
	static Queue<Edge> queue = new PriorityQueue<>();
	static List<Edge>[] edges;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		items=new int[n+1];
		dist=new int[n+1];
		edges=new ArrayList[n+1];
		for(int i=1;i<=n;i++)edges[i]=new ArrayList<>();
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) items[i]=Integer.parseInt(st.nextToken());
		for(int i=0;i<r;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			edges[u].add(new Edge(v,w));
			edges[v].add(new Edge(u,w));
		}
		int result=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			result=Math.max(result, dijkstra(i));
		}
		System.out.println(result);
	}
	
	static int dijkstra(int start) {
		int item=items[start];
		Arrays.fill(dist, INF);
		dist[start]=0;
		queue.clear();
		if(edges[start].isEmpty())return item;
		for(Edge e:edges[start]) queue.offer(e);
		
		while(!queue.isEmpty()) {
			Edge curE = queue.poll();
			if(curE.w>=dist[curE.v]) continue;
			if(curE.w>m) return item;
			dist[curE.v]=curE.w;
			item+=items[curE.v];
			if(edges[curE.v].isEmpty())continue;
			for(Edge next:edges[curE.v]) {
				queue.offer(new Edge(next.v,next.w+dist[curE.v]));
			}
		}
		
		return item;
	}
	
	static class Edge implements Comparable<Edge>{
		int v,w;
		public Edge(int v,int w) {
			this.v=v;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}
}
