import java.util.*;
import java.io.*;
public class Main{
	static final int INF=1000000000;
	static int N,M,T,S,G,H;
	static int[] from,to,weight,head,next;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case=Integer.parseInt(br.readLine());
		for(int t=0;t<test_case;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			T=Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			S=Integer.parseInt(st.nextToken());
			G=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			from=new int[2*M];to=new int[2*M];weight=new int[2*M];next=new int[2*M];head=new int[N+1];
			Arrays.fill(head, -1);
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int src=Integer.parseInt(st.nextToken());
				int dest=Integer.parseInt(st.nextToken());
				int w=Integer.parseInt(st.nextToken());
				to[2*i+1]=from[2*i]=src;
				from[2*i+1]=to[2*i]=dest;
				weight[2*i+1]=weight[2*i]=w;
				next[2*i]=head[src];
				next[2*i+1]=head[dest];
				head[src]=2*i;
				head[dest]=2*i+1;
			}
			if(T==1) {
				System.out.println(Integer.parseInt(br.readLine()));
				continue;
			}
			
			int[] Sdist=new int[N+1];
			int[] Gdist=new int[N+1];
			int[] Hdist=new int[N+1];
			dijkstra(S,Sdist);
			dijkstra(G,Gdist);
			dijkstra(H,Hdist);
			
			List<Integer> ableDestination=new ArrayList<>();
			for(int i=0;i<T;i++) {
				int dest=Integer.parseInt(br.readLine());
				if(Sdist[dest]==Sdist[G]+Gdist[dest] && Sdist[dest]==Sdist[H]+Hdist[dest]) {
					ableDestination.add(dest);
				}
			}
			Collections.sort(ableDestination);
			StringBuilder sb = new StringBuilder();
			for(int d:ableDestination) sb.append(d).append(" ");
			sb.setLength(sb.length()-1);
			System.out.println(sb);
		}
	}
	
	static void dijkstra(int start,int[] dist) {
		Arrays.fill(dist, INF);
		Queue<Long> queue = new PriorityQueue<>();
		queue.offer((long)start);
		dist[start]=0;
		while(!queue.isEmpty()) {
			long cur=queue.poll();
			int u=(int)cur;
			int w=(int)(cur>>>32);
			if(w>dist[u])continue;
			for(int e=head[u];e!=-1;e=next[e]) {
				int nextv=to[e];
				if(dist[nextv]>dist[u]+weight[e]) {
					dist[nextv]=dist[u]+weight[e];
					queue.offer(((long)dist[nextv]<<32)|(long)nextv);
				}
			}
		}
	}
}
