import java.util.*;
import java.io.*;
public class Main {
	static final int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
	static int N;
	static int[][] map,visited,timevisited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		visited=new int[N][N];
		timevisited=new int[N][N];
		for(int i=0;i<N;i++)Arrays.fill(timevisited[i], Integer.MAX_VALUE);
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		PriorityQueue<P> queue = new PriorityQueue<>();
		queue.offer(new P(0,0,0,0));
		while(!queue.isEmpty()) {
			P cur = queue.poll();
			if(cur.r==N-1&&cur.c==N-1) {
				System.out.println(cur.broke);
				return;
			}
			if((visited[cur.r][cur.c]!=0&&cur.broke>=visited[cur.r][cur.c])||(visited[cur.r][cur.c]==cur.broke&&timevisited[cur.r][cur.c]<=cur.time))continue;
			visited[cur.r][cur.c]=cur.broke;
			timevisited[cur.r][cur.c]=cur.time;
			for(int i=0;i<4;i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				if(!check(nr,nc))continue;
				if(map[nr][nc]==1) queue.offer(new P(nr,nc,cur.broke,cur.time+1));
				else queue.offer(new P(nr,nc,cur.broke+1,cur.time+1));
			}
		}
	}
	
	static class P implements Comparable<P>{
		int r,c,time,broke;
		public P(int r,int c,int broke,int time) {
			this.r=r;
			this.c=c;
			this.broke=broke;
			this.time=time;
		}
		
		private int h() { 
			return Math.abs(this.r-(N-1))+Math.abs(this.c-(N-1));
		}
		
		@Override
		public int compareTo(P o) {
			if(this.broke==o.broke) Integer.compare(this.h(), o.h());
			return Integer.compare(this.broke, o.broke);
		}
	}
	
	static boolean check(int r,int c){
		return r>=0&&r<N&&c>=0&&c<N;
	}
}
