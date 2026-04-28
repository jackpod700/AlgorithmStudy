import java.util.*;
import java.io.*;

public class Main {
	static int n,m,count=0,prevCheese=0,dc;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());m=Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int value=Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if(value==1)prevCheese++;
			}
		}
		while((dc=bfs())!=0) {
			
			if(dc!=prevCheese) {
				prevCheese-=dc;
			}
			count++;
		}
		System.out.println(count+"\n"+prevCheese);
	}
	
	static int bfs() {
		int changed=0;
		int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
		visited = new boolean[n][m];
		
		ArrayDeque<P> queue=new ArrayDeque<>();
		queue.offer(new P(0,0));
		while(!queue.isEmpty()) {
			P curP = queue.poll();
			if(map[curP.r][curP.c]==1) {
				map[curP.r][curP.c]=0;
				changed++;
				continue;
			}
			for(int i=0;i<4;i++) {
				int nr=curP.r+dr[i];
				int nc=curP.c+dc[i];
				if(nr>=0&&nr<n&&nc>=0&&nc<m&&!visited[nr][nc]) {
					queue.offer(new P(nr,nc));
					visited[nr][nc]=true;
				}
			}
		}
		return changed;
	}
	
	static class P{
		int r,c;
		public P(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}
}
