import java.util.*;
import java.io.*;
public class Main {
	static final int INF=Integer.MAX_VALUE;
	static int N,P,K,min=Integer.MAX_VALUE;
	static int[][] dist;
	static List<Edge>[] edges;
	static Route result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		dist=new int[N+1][K+1];
		for(int i=0;i<=N;i++)Arrays.fill(dist[i], INF);
		edges=new List[N+1];
		for(int i=1;i<=N;i++)edges[i] = new ArrayList<>();
		for(int i=0;i<P;i++) {
			st = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			edges[u].add(new Edge(v,w));
			edges[v].add(new Edge(u,w));
		}
		
		Queue<Route> queue = new PriorityQueue<>();
		queue.offer(new Route(1,0,0));
		while(!queue.isEmpty()) {
			Route r=queue.poll();
			if(r.curNode==N) {
				result=r;
				break;
			}
			if(dist[r.curNode][r.free]<=r.maxWeight)continue;
			dist[r.curNode][r.free]=r.maxWeight;
			List<Edge> curEdges = edges[r.curNode]; 
			for(int i=0;i<curEdges.size();i++) {
				Edge e = curEdges.get(i);
				if(r.free<K&&dist[e.to][r.free+1]>r.maxWeight) {
					queue.offer(new Route(e.to,r.maxWeight,r.free+1));
				}
				if(dist[e.to][r.free]>r.maxWeight) {
					queue.offer(new Route(e.to,Math.max(e.w, r.maxWeight),r.free));
				}
			}
		}
		if(result==null) {
			System.out.println(-1);
			return;
		}
		System.out.println(result.maxWeight);
	}
	
	static class Edge implements Comparable<Edge>{
		int to,w;
		public Edge(int to, int w) {
			this.to=to;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}
	
	static class Route implements Comparable<Route>{
		int curNode,maxWeight,free;
		public Route(int curNode, int maxWeight,int free) {
			this.curNode=curNode;
			this.maxWeight=maxWeight;
			this.free=free;
		}
		@Override
		public int compareTo(Route o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.maxWeight,o.maxWeight);
		}
	}
	
}
