import java.io.*;
import java.util.*;

public class Main{
	static int N,M;
	static List<Integer>[] adj;
	static int[] indegree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		adj=new List[N+1];
		indegree=new int[N+1];
		for(int i=0;i<=N;i++)adj[i]=new ArrayList<>();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int src=Integer.parseInt(st.nextToken());
			int dest=Integer.parseInt(st.nextToken());
			adj[src].add(dest);
			indegree[dest]++;
		}
		
		Queue<Integer> queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			sb.append(cur).append(" ");
			if(adj[cur].isEmpty())continue;
			for(int n:adj[cur]) if(--indegree[n]==0)queue.add(n);
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
