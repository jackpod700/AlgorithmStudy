import java.util.*;
import java.io.*;
public class Main{
	static int N,M,result;
	static int[] P;
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		N=readInt();
		M=readInt();
		P=new int[N+1];
		for(int i=1;i<=N;i++) P[i]=i;
		
		for(int i=0;i<M;i++) {
			queue.offer(new Edge(readInt(),readInt(),readInt()));
		}
		int cnt=0;
		while(cnt!=N-1) {
			Edge e = queue.poll();
			if(union(e.a,e.b)) {
				cnt++;
				result+=e.w;
				if(cnt==N-1)result-=e.w;
			}
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
		P[x]=y;
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
	
    private static int readInt() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) > 47)
            n = (n * 10) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }

}
