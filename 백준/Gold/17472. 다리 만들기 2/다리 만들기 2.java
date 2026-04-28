import java.util.*;
import java.io.*;
public class Main {
	static int N,M,V,result;
	static int[][] map;
	static int[] P,dr= {-1,0,0,1},dc= {0,-1,1,0};
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		floodfill();
		getEdges();
		makeMST();
		System.out.println(result);
	}
	
	static void floodfill() {
		int VN=2;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1)bfs(i,j,VN++);
			}
		}
		V=VN-2;
	}
	
	static void bfs(int r, int c, int VN) {
		// TODO Auto-generated method stub
		Queue<P> queue = new ArrayDeque<>();
		map[r][c]=VN;
		queue.offer(new P(r,c));
		while(!queue.isEmpty()) {
			P curP = queue.poll();
			for(int i=0;i<4;i++) {
				int nr=curP.r+dr[i];
				int nc=curP.c+dc[i];
				if(check(nr,nc)&&map[nr][nc]==1) {
					map[nr][nc]=VN;
					queue.offer(new P(nr,nc));
				}
			}
		}
	}
	
	static boolean check(int nr,int nc) {
		return (nr>=0&&nr<N&&nc>=0&&nc<M);
	}

	private static void getEdges() {
		// TODO Auto-generated method stub
		int s=0,d=0,w=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					if(s!=0) w++;
					continue;
				}
				if(s==0) {
					s=map[i][j]-1;
					w=0;
					continue;
				}
				if(s==map[i][j]-1) {
					w=0;
					continue;
				}
				if(w>1) queue.offer(new Edge(s,map[i][j]-1,w));
				s=map[i][j]-1;w=0;
			}
			s=0;
			w=0;
		}
		for(int j=0;j<M;j++) {
			for(int i=0;i<N;i++) {
				if(map[i][j]==0) {
					if(s!=0) w++;
					continue;
				}
				if(s==0) {
					s=map[i][j]-1;
					continue;
				}
				if(s==map[i][j]-1) {
					w=0;
					continue;
				}
				if(w>1) queue.offer(new Edge(s,map[i][j]-1,w));
				s=map[i][j]-1;w=0;
			}
			s=0;
			w=0;
		}

	}
	
	private static void makeMST() {
		// TODO Auto-generated method stub
		P=new int[V+1];
		for(int i=1;i<=V;i++) P[i]=i;
		int cnt=0;
		while(cnt!=V-1) {
			Edge e = queue.poll();
			if(e==null) {
				result=-1;
				break;
			}
			if(union(e.s,e.d)) {
				cnt++;
				result+=e.w;
			}
		}
		cnt=0;
		for(int i=1;i<=V;i++) {
			if(P[i]==i&&++cnt==2) {
				result=-1;
				break;
			}
		}
	}
	
	static int find(int x) {
		if(P[x]==x)return P[x];
		return P[x]=find(P[x]);
	}
	
	static boolean union(int x,int y) {
		x=find(x);
		y=find(y);
		if(x==y) return false;
		P[x]=y;
		return true;
	}
	
	static class P{
		int r,c;
		public P(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int s,d,w;
		public Edge(int s,int d,int w) {
			this.s=s;
			this.d=d;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}
}
