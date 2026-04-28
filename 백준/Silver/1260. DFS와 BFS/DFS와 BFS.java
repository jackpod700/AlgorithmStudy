import java.util.*;
import java.io.*;

public class Main {
	static List<String> DFSresult = new ArrayList<>();
	static List<String> BFSresult = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int V=Integer.parseInt(st.nextToken());
		Node[] nodes1 = new Node[N];
		Node[] nodes2 = new Node[N];
		for(int i=0;i<N;i++) {
			nodes1[i] = new Node(i+1);
			nodes2[i] = new Node(i+1);
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			nodes1[start].edges.add(nodes1[end]);
			nodes1[end].edges.add(nodes1[start]);
			nodes2[start].edges.add(nodes2[end]);
			nodes2[end].edges.add(nodes2[start]);
		}
		DFS(nodes1, V-1);
		System.out.println(String.join(" ", DFSresult));
		BFS(nodes2, V-1);
		System.out.println(String.join(" ", BFSresult));
	}
	
	static void DFS(Node[] nodes, int start) {
		Node curNode = nodes[start];
		curNode.visited=true;
		DFSresult.add(curNode.index.toString());
		Node nextNode = curNode.edges.poll();
		while(true) {
			if(nextNode==null){
				return;
			}
			if(nextNode.visited==false) {
				DFS(nodes,nextNode.index-1);
			}
			nextNode = curNode.edges.poll();
		}
	}
	
	static void BFS(Node[] nodes, int start) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(nodes[start]);
		nodes[start].visited=true;
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			BFSresult.add(curNode.index.toString());
			Node nextNode = curNode.edges.poll();
			while(nextNode!=null) {
				if(!nextNode.visited) {
					queue.add(nextNode);
					nextNode.visited=true;
				}
				nextNode=curNode.edges.poll();
			}
			
		}
	}
}
class Node implements Comparable<Node>{
	Integer index;
	boolean visited=false;
	Queue<Node> edges = new PriorityQueue<Node>();
	
	public Node(int index) {
		this.index = index;
	}
	
	@Override
	public int compareTo(Node n) {
		if(this.index>n.index) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
