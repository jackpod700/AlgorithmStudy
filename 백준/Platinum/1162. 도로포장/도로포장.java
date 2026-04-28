import java.util.*;
import java.io.*;
public class Main{
	static int N,M,K;
	static long[][] visited;
	static List<Edge>[] edges;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		edges=new List[N+1];
		for(int i=0;i<=N;i++)edges[i]=new ArrayList<>();
		visited=new long[K+1][N+1];
		for(int i=0;i<=K;i++)Arrays.fill(visited[i], Long.MAX_VALUE);
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			edges[u].add(new Edge(v,w));
			edges[v].add(new Edge(u,w));
		}
		
		PriorityQueue<Route> queue = new PriorityQueue<>();
		queue.offer(new Route(0,1,0));
		while(!queue.isEmpty()) {
			Route cur = queue.poll();
			if(cur.curNode==N) {
				System.out.println(cur.distSum);
				return;
			}
			if(cur.distSum>=visited[cur.paved][cur.curNode])continue;
			visited[cur.paved][cur.curNode]=cur.distSum;
			List<Edge> curEdges = edges[cur.curNode];
			for(int i=0;i<curEdges.size();i++) {
				if(cur.paved<K&&visited[cur.paved+1][curEdges.get(i).to]>cur.distSum) {
					queue.offer(new Route(cur.distSum,curEdges.get(i).to,cur.paved+1));
				}
				if(visited[cur.paved][curEdges.get(i).to]>cur.distSum+curEdges.get(i).w) {
					queue.offer(new Route(cur.distSum+curEdges.get(i).w,curEdges.get(i).to,cur.paved));
				}
				
			}
			
		}
	}
	
	static class Edge{
		int to,w;
		public Edge(int to, int w) {
			this.to=to;
			this.w=w;
		}
	}
	
	static class Route implements Comparable<Route>{
		long distSum;
		int curNode,paved;
		public Route(long distSum, int curNode, int paved) {
			this.distSum=distSum;
			this.curNode=curNode;
			this.paved=paved;
		}
		@Override
		public int compareTo(Route o) {
			// TODO Auto-generated method stub
			return Long.compare(this.distSum, o.distSum);
		}
	}
}
