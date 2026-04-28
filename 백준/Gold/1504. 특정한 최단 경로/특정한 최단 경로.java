import java.util.*;
import java.io.*;
public class Main {
	static final int INF=300000000;
	static int N,E;
	static int[] head,to,weight,next;
	static int[] distv1,distv2;
	public static void main(String[] args) throws IOException{
		N=readInt();
		E=readInt();
		head=new int[N+1];
		Arrays.fill(head, -1);
		next=new int[2*E];
		to=new int[2*E];
		weight=new int[2*E];
		distv1=new int[N+1];
		distv2=new int[N+1];
		for(int i=0;i<E;i++) {
			int s=readInt();
			int d=readInt();
			int w=readInt();
			to[2*i]=d;
			to[2*i+1]=s;
			weight[2*i]=weight[2*i+1]=w;
			next[2*i]=head[s];
			next[2*i+1]=head[d];
			head[s]=2*i;
			head[d]=2*i+1;
		}
		int v1 = readInt();
		int v2 = readInt();
		dijkstra(v1,distv1);
		dijkstra(v2,distv2);
		int result=Math.min(distv1[1]+distv1[v2]+distv2[N],distv2[1]+distv2[v1]+distv1[N]);
		if(result>=INF) System.out.println(-1);
		else System.out.println(result);
		
	}
	
	static void dijkstra(int start,int[] dist) {
		Arrays.fill(dist, INF);
		dist[start]=0;
		Queue<Long> queue = new PriorityQueue<>();
		queue.offer((long)start);
		while(!queue.isEmpty()) {
			long curE=queue.poll();
			int u=(int)curE;
			int w=(int)(curE>>>32);
			if(dist[u]<w)continue;
			for(int e=head[u];e!=-1;e=next[e]) {
				int nextV=to[e];
				if(dist[nextV]>dist[u]+weight[e]) {
					dist[nextV]=dist[u]+weight[e];
					queue.offer(((long)dist[nextV]<<32)|(long)nextV);
				}
			}
		}
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
	
	static final InputStream IN = System.in;
    static int readInt() throws IOException {
        int val = IN.read() & 15;
        int ch;
        while ((ch = IN.read()) > 32)
            val = (val << 3) + (val << 1) + (ch & 15);
        return val;
    }
}
