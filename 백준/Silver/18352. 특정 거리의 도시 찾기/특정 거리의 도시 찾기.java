import java.io.*;
import java.util.*;

public class Main {
	static int N,M,K,X;
	static List<Integer>[] adj;
	static boolean[] visited;
	static List<Integer> result=new ArrayList<>();
 	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		adj=new ArrayList[N+1];
		visited=new boolean[N+1];
		for(int i=1;i<N+1;i++) adj[i]=new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int src=Integer.parseInt(st.nextToken());
			int dest=Integer.parseInt(st.nextToken());
			adj[src].add(dest);
		}
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(X,0));
		visited[X]=true;
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			if(curNode.dist==K) {
				result.add(curNode.index);
				continue;
			}
			int adjSize=adj[curNode.index].size();
			for(int i=0;i<adjSize;i++) {
				int next=adj[curNode.index].get(i);
				if(visited[next]) continue;
				queue.offer(new Node(next,curNode.dist+1));
				visited[next]=true;
			}
		}
		if(result.size()==0) {
			System.out.println(-1);
			return;
		}
		Collections.sort(result);
		for(int i:result) {
			System.out.println(i);
		}
	}
 	static class Node{
 		int index,dist;
 		public Node(int index,int dist) {
 			this.index=index;
 			this.dist=dist;
 		}
 	}
}
