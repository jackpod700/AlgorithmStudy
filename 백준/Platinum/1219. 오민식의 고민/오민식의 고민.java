import java.util.*;
import java.io.*;

public class Main{
	static int N,A,B,M;
	static final long MINF=-100000000000000000L;
	static Edge[] edges;
	static long[] dist;
//	static boolean[] visited;
	static List<Integer> loopNodes=new ArrayList<>();
	static boolean comeback,canGoOut;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		edges = new Edge[M];
		dist = new long[N];
		Arrays.fill(dist, MINF);
//		visited=new boolean[N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			edges[i]=new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),-1*Integer.parseInt(st.nextToken()));
			if(edges[i].s==A)canGoOut=true;
		}
		st=new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) {
			int earn=Integer.parseInt(st.nextToken());
			for(int j=0;j<M;j++) {
				Edge e=edges[j];
				if(e.d==i) e.w += earn;
			}
			if(i==A)dist[A]=earn;
		}
		
		//dfs를 통해 시작지점에서 도착지점까지 도달하는것이 가능한지 알아본다
		if(!dfs(A,B,new boolean[N])) {
			if(A==B) System.out.println(dist[A]);	//A와 B가 같은경우 A값만 출력
			else System.out.println("gg");
			return;
		}
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<M;j++) {
				Edge e = edges[j];
				if(dist[e.s]==MINF)continue;
				if(dist[e.d]<dist[e.s]+e.w) {
					dist[e.d]=dist[e.s]+e.w;
				}
			}
		}
		for(int j=0;j<M;j++) {
			Edge e = edges[j];
			if(dist[e.d]<dist[e.s]+e.w) {
				loopNodes.add(e.d);
			}
		}
		for(int i=0;i<loopNodes.size();i++) {
			if(dfs(A,loopNodes.get(i),new boolean[N])&&dfs(loopNodes.get(i),B,new boolean[N])) {
				System.out.println("Gee");
				return;
			}
		}
		System.out.println(dist[B]);
	}
	
	static boolean dfs(int start,int goal, boolean[] visited) {
		for(int i=0;i<M;i++) {
			Edge e = edges[i];
			if(e.s==start&&!visited[e.d]) {
				if(e.d==goal)return true;
				visited[e.d]=true;
				if(dfs(e.d,goal,visited))return true;
			}
		}
		return false;
	}
	
	static class Edge{
		int s,d,w;
		public Edge(int s,int d,int w) {
			this.s=s;
			this.d=d;
			this.w=w;
		}
	}
}
