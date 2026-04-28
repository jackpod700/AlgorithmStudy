import java.util.*;

public class Main {
	static int n, m, count=0;
	static ArrayList<Integer>[] edges;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		edges = new ArrayList[n];
		for(int i=0;i<n;i++) edges[i] = new ArrayList<>();
		visited = new boolean[n];
		for(int i=0;i<m;i++) {
			int start = sc.nextInt()-1;
			int end = sc.nextInt()-1;
			edges[start].add(end);
			edges[end].add(start);
		}
		for(ArrayList l:edges) l.sort(null);
		DFS(0);
		System.out.println(count-1);
	}
	
	static void DFS(int current) {
		count++;
		visited[current]=true;
		for(Integer i:edges[current]) {
			if(!visited[i]) DFS(i);
		}
		
	}
}