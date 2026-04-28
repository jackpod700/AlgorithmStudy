import java.util.*;
import java.io.*;

public class Main {
	static int V,E,result;
	static int[] P,R;
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		V=readInt();
		E=readInt();
		P=new int[V+1];
		R=new int[V+1];
		for(int i=1;i<=V;i++) {
			P[i]=i;
			R[i]=1;
		}
		for(int i=0;i<E;i++) {
			int s=readInt();
			int d=readInt();
			int w=readInt();
			queue.offer(new Edge(s,d,w));
		}
		for(int i=0;i<V-1;i++) {
			Edge e = queue.poll();
			if(!union(e.s,e.d)) {
				i--;
				continue;
			}
			result+=e.w;
		}
		System.out.println(result);
	}
	static int find(int x) {
		if(P[x]==x) return P[x];
		P[x]=find(P[x]);
		return P[x];
	}
	
	static boolean union(int v1, int v2) {
		int x = find(v1);
		int y = find(v2);
		if(x==y) return false;
		if(R[x]<R[y]) {
			R[y]+=R[x];
			P[x]=y;
		}
		else {
			R[x]+=R[y];
			P[y]=x;
		}
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int s,d,w;
		public Edge(int s, int d,int w) {
			this.s=s;
			this.d=d;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int readInt() throws IOException {
		int c, n = 0, s = 1;
		while((c = System.in.read()) <= 0x20);
		if(c == '-') {
			s = -1;
			c = System.in.read();
		}
		n = c & 0x0F;
		while((c = System.in.read()) >= 0x30) n = (n << 3) + (n << 1) + (c & 0x0F);
		return n * s;
	}
}
