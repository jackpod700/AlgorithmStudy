import java.util.*;
import java.io.*;
public class Main {
	static final int INF=1000000000;
	static int N,M;
	static int[] from,to,weight,head,next,dist,parent_edge;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		from=new int[M];
		to=new int[M];
		weight=new int[M];
		next=new int[M];
		head=new int[N+1];
		parent_edge=new int[N+1];
		Arrays.fill(head, -1);
		Arrays.fill(parent_edge, -1);
		dist=new int[N+1];
		Arrays.fill(dist, INF);
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int src=Integer.parseInt(st.nextToken());
			int dest=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			from[i]=src;
			to[i]=dest;
			weight[i]=w;
			next[i]=head[src];
			head[src]=i;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		
		dist[start]=0;
		heap queue = new heap();
		queue.insert((long)start);
		while(!queue.isEmpty()) {
			long e = queue.poll();
			int u=(int)e;
			int w=(int)(e>>>32);
			if(w>dist[u])continue;
			for(int edge=head[u];edge!=-1;edge=next[edge]) {
				int nextv=to[edge];
				if(dist[nextv]>dist[u]+weight[edge]) {
					dist[nextv]=dist[u]+weight[edge];
					queue.insert(((long)dist[nextv]<<32)|(long)nextv);
					parent_edge[nextv]=edge;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dist[end]).append("\n");
		int cur=end;
		int count=1;
		List<Integer> route=new ArrayList<>();
		route.add(cur);
		while(cur!=start) {
			count++;
			cur=from[parent_edge[cur]];
			route.add(0,cur);
		}
		sb.append(count).append("\n");
		for(int i:route) sb.append(i).append(" ");
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	static class heap{
		long[] nodes = new long[100_000];
		int lastNode=1;
		
		public heap() {};
		
		public void insert(long val) {
			int current=lastNode++;
			while(current>1&&nodes[current>>1]>val) {
				nodes[current]=nodes[current>>1];
				current >>= 1;
			}
			nodes[current]=val;
		}
		
		public long poll() {
			if(lastNode==1)return -1;
			Long min=nodes[1];
			long lastVal =nodes[--lastNode];
			int current=1;
			
			while((current<<1)<lastNode) {
				int left = current<<1;
				int right = left+1;
				int minChild=left;
				if(right<lastNode && nodes[right]<nodes[left]) minChild=right;
				if(lastVal<=nodes[minChild])break;
				nodes[current]=nodes[minChild];
				current=minChild;
			}
			
			nodes[current]=lastVal;
			return min;
		}
		
		public boolean isEmpty() {
			if(lastNode==1)return true;
			return false;
		}
	}
}
