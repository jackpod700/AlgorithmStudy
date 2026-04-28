import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static Node[] nodes;
	static int[] P;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		nodes = new Node[N];
		P=new int[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			nodes[i]=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			P[i]=i;
		}
		Queue<Edge> queue = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			Node curNode = nodes[i];
			for(int j=i+1;j<N;j++) {
				double distance = curNode.getDistance(nodes[j]);
				queue.offer(new Edge(i,j,distance));
			}
		}
		int cnt=0;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int node1=Integer.parseInt(st.nextToken())-1;
			int node2=Integer.parseInt(st.nextToken())-1;
			if(union(node1,node2))cnt++;
		}

		double total=0;
		while(cnt!=N-1) {
			Edge e = queue.poll();
			if(!union(e.u,e.v)) continue;
			cnt++;
			total+=e.w;
		}
		System.out.printf("%.2f",total);
		
	}
	
	static int find(int x) {
		if(P[x]==x)return x;
		return P[x]=find(P[x]);
	}
	
	static boolean union(int x,int y) {
		x=find(x);
		y=find(y);
		if(x==y)return false;
		P[x]=y;
		return true;
	}
	
	static class Node{
		int x,y;
		public Node(int x,int y) {
			this.x=x;
			this.y=y;
		}
		
		public double getDistance(Node n) {
			return Math.sqrt(Math.pow((this.x-n.x),2)+Math.pow((this.y-n.y),2));
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int u,v;
		double w;
		public Edge(int u,int v,double w) {
			this.u=u;
			this.v=v;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.w, o.w);
		}
		
		
	}
}
