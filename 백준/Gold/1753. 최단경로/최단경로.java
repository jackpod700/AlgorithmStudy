import java.util.*;
import java.io.*;

public class Main {
	static int V,E,start;
	static List<Edge>[] edges;
	static Vertex[] vertexes;
	static int[] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		vertexes = new Vertex[V+1];
		for(int i=1;i<=V;i++) vertexes[i]=new Vertex(i);
		dist = new int[V];
		Arrays.fill(dist,Integer.MAX_VALUE);
		start = Integer.parseInt(br.readLine());
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			vertexes[u].edges.add(new Edge(vertexes[v],w));
		}
		vertexes[start].dist=0;
		
		Queue<Vertex> queue = new PriorityQueue<>();
		queue.offer(vertexes[start]);
		while(!queue.isEmpty()) {
			Vertex curV = queue.poll();
			if(curV.dist>vertexes[curV.index].dist) continue;
			int edgeSize=curV.edges.size();
			for(int i=0;i<edgeSize;i++) {
				Edge e = curV.edges.get(i);
				Vertex nextV = e.dest;
				if(nextV.dist>curV.dist+e.w) {
					nextV.dist=curV.dist+e.w;
					queue.offer(nextV);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=V;i++) {
			Vertex v = vertexes[i];
			if(v.dist==Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(v.dist).append("\n");
		}
		System.out.print(sb);
	}
	
	static class Vertex implements Comparable<Vertex>{
		
		int dist=Integer.MAX_VALUE,index;
		List<Edge> edges = new ArrayList<>();
		public Vertex(int index) {
			this.index=index;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
	
	static class Edge{
		Vertex dest;
		int w;
		public Edge(Vertex dest,int w) {
			this.dest=dest;
			this.w=w;
		}
	}
}
