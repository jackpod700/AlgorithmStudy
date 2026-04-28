import java.util.*;
import java.io.*;

public class Main {
	static int N,count=0,sharkSize=2,sharkEat=0;
	static int[][] map;
	static P shark;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					map[i][j]=0;
					shark=new P(i,j,0);
				}
			}
		}
		P next;
		while((next=findNext())!=null) {
			count+=next.time;
			shark.r=next.r;
			shark.c=next.c;
			if(sharkSize==(++sharkEat)) {
				sharkSize++;
				sharkEat=0;
			}
		}
		System.out.println(count);
	}
	
	static P findNext() {
		int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
		boolean[][] visited=new boolean[N][N];
		Queue<P> queue=new PriorityQueue<>();
		queue.add(shark);
		visited[shark.r][shark.c]=true;
		while(!queue.isEmpty()) {
			P curP=queue.poll();
			if(map[curP.r][curP.c]!=0&&map[curP.r][curP.c]<sharkSize) {
				map[curP.r][curP.c]=0;
				return curP;
			}
			for(int i=0;i<4;i++) {
				int nr=curP.r+dr[i];
				int nc=curP.c+dc[i];
				if(nr>=0&&nr<N&&nc>=0&&nc<N) {
					if(map[nr][nc]<=sharkSize&&!visited[nr][nc]) {
						queue.add(new P(nr,nc,curP.time+1));
						visited[nr][nc]=true;
						continue;
					}
				}
			}
		}
		return null;
	}
	
	static class P implements Comparable<P>{
		int r,c,time;
		public P(int r,int c) {
			this.r=r;
			this.c=c;
		}
		public P(int r,int c,int time) {
			this(r,c);
			this.time=time;
		}
		@Override
		public int compareTo(P o) {
			// TODO Auto-generated method stub
			if(this.time==o.time) {
				if(this.r==o.r) return Integer.compare(this.c, o.c);
				return Integer.compare(this.r, o.r);
			}
			return Integer.compare(this.time, o.time);
		}
		
	}
}
