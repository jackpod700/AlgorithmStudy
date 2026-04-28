import java.util.*;
import java.io.*;

public class Main {
	static int N,R,Q;
	static List<Integer>[] edges;
	static int[] subtree;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		edges=new ArrayList[N+1];
		subtree=new int[N+1];
		Arrays.fill(subtree, 1);
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++)edges[i]=new ArrayList<>();
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			edges[s].add(d);edges[d].add(s);
		}
		dfs(R);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<Q;i++) {
			int node=Integer.parseInt(br.readLine());
			sb.append(subtree[node]).append("\n");
		}
		System.out.print(sb);
	}
	static int dfs(int node) {
		visited[node]=true;
		for(int next:edges[node]) {
			if(visited[next])continue;
			subtree[node]+=dfs(next);
		}
		return subtree[node];
	}
}
