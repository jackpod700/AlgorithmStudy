import java.util.*;
import java.io.*;

public class Main {
	static int n,m,count=0;
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
			}
		}
		while(bfs()) count++;
		System.out.println(count);
	}
	
	static boolean bfs() {
		boolean changed=false;
		int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
		visited = new boolean[n][m];
		
		ArrayDeque<P> queue=new ArrayDeque<>();
		queue.offer(new P(0,0));
		map[0][0]=-1;
		visited[0][0]=true;
		while(!queue.isEmpty()) {
			P curP = queue.poll();
			if(map[curP.r][curP.c]==1) {
				int count=0;
				for(int i=0;i<4;i++) {
					int r=curP.r+dr[i];
					int c=curP.c+dc[i];
					if(map[r][c]==-1)count++;
				}
				if(count>1) {
					map[curP.r][curP.c]=0;
					changed=true;
				}
				continue;
			}
			map[curP.r][curP.c]=-1;
			for(int i=0;i<4;i++) {
				int nr=curP.r+dr[i];
				int nc=curP.c+dc[i];
				if(nr>=0&&nr<n&&nc>=0&&nc<m&&!visited[nr][nc]) {
					if(map[nr][nc]==1)queue.offer(new P(nr,nc));
					else queue.offerFirst(new P(nr,nc));
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
