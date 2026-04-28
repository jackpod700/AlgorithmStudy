import java.util.*;
import java.io.*;

public class Main {
	static final int INF=1000000000;
	static int N,M;
	static int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
	static int[][] map,dist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		dist=new int[N][M];
		for(int i=0;i<N;i++)Arrays.fill(dist[i], INF);
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		Queue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(0,0,0));
		while(!queue.isEmpty()) {
			Edge curE = queue.poll();
			if(curE.r==N-1&&curE.c==M-1) {
				System.out.println(curE.w);
				return;
			}
			if(dist[curE.r][curE.c]<curE.w)continue;
			dist[curE.r][curE.c]=curE.w;
			for(int i=0;i<4;i++) {
				int nr=curE.r+dr[i];
				int nc=curE.c+dc[i];
				if(!check(nr,nc)) continue;
				if(dist[nr][nc]>dist[curE.r][curE.c]+map[nr][nc]) {
					dist[nr][nc]=dist[curE.r][curE.c]+map[nr][nc];
					queue.offer(new Edge(nr,nc,dist[nr][nc]));
				}
			}
		}
	}
	
	static boolean check(int nr,int nc) {
		return nr>=0&&nr<N&&nc>=0&&nc<M;
	}
	
	static class Edge implements Comparable<Edge>{
		int r,c,w;
		public Edge(int r,int c,int w) {
			this.r=r;
			this.c=c;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
		
		
	}
}
