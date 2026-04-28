import java.util.*;
import java.io.*;
public class Main {
	static int N,M,total;
	static int[] P;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			total=0;
			if(N==0&&M==0)break;
			P=new int[M];
			for(int i=0;i<M;i++) P[i]=i;
			Queue<Edge> queue = new PriorityQueue<>();
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				int u=Integer.parseInt(st.nextToken());
				int v=Integer.parseInt(st.nextToken());
				int w=Integer.parseInt(st.nextToken());
				total+=w;
				queue.offer(new Edge(u,v,w));
			}
			int unioncnt=0,reduce=0;
			while(unioncnt!=M-1) {
				Edge curE = queue.poll();
				if(union(curE.u,curE.v)) {
					unioncnt++;reduce+=curE.w;
				}
			}
			System.out.println(total-reduce);
		}

	}
	
	static boolean union(int x,int y) {
		x=find(x);
		y=find(y);
		if(x==y)return false;
		P[x]=y;
		return true;
	}
	
	static int find(int x) {
		if(P[x]==x)return x;
		return P[x]=find(P[x]);
	}
	
	static class Edge implements Comparable<Edge>{
		int u,v,w;
		public Edge(int u,int v,int w) {
			this.u=u;
			this.v=v;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
}
