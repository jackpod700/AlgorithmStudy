import java.util.*;
import java.io.*;
public class Main{
	static int N,M;
	static Node[] nodes;
	static ArrayDeque<Node> removable=new ArrayDeque<>();
	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		nodes=new Node[N+1];
		for(int i=1;i<=N;i++)nodes[i]=new Node(i);
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int src=Integer.parseInt(st.nextToken());
			int dest=Integer.parseInt(st.nextToken());
			nodes[dest].preNum++;
			nodes[src].bigger.add(nodes[dest]);
		}
		for(int i=1;i<=N;i++) {
			if(nodes[i].preNum==0) {
				removable.add(nodes[i]);
			}
		}
		while(!removable.isEmpty()) {
			Node n=removable.poll();
			for(Node next:n.bigger) {
				if(--next.preNum==0)removable.add(next);
			}
			result.append(n.index+" ");
		}
		result.setLength(result.length()-1);
		System.out.println(result);
		
	}

	static class Node{
		int preNum,index;
		List<Node> bigger;
		public Node(int index) {
			this.index=index;
			preNum=0;
			bigger=new ArrayList<>();
		}
	}
}
