import java.util.*;
import java.io.*;
public class Main{
	static int N,M,result;
	static int[] P,R;
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		P=new int[N+1];
		R=new int[N+1];
		for(int i=1;i<=N;i++) {
			P[i]=i;
			R[i]=1;
		}
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			if(a==b)continue;
			queue.offer(new Edge(a,b,w));
		}
		for(int i=0;i<N-1;i++) {
			Edge e = queue.poll();
			if(!union(e.a,e.b)) {
				i--;
				continue;
			}
			result+=e.w;
		}
		System.out.println(result);
	}
	
	static int find(int x) {
		if(P[x]==x)return P[x];
		P[x]=find(P[x]);
		return P[x];
	}
	
	static boolean union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x==y) return false;
		if(R[x]>=R[y]) {
			P[y]=x;
			if(R[x]==R[y])R[x]++;
		}
		else P[x]=y;
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int a,b,w;
		public Edge(int a,int b,int w) {
			this.a=a;
			this.b=b;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}
}
