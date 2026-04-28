import java.util.*;
import java.io.*;
public class Main {
	static int w,h,count=0;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w=Integer.parseInt(st.nextToken());h=Integer.parseInt(st.nextToken());
			if(w==0&&h==0) return;
			map = new int[h][w];
			visited = new boolean[h][w];
			count=0;
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j]==1&&!visited[i][j]) {
						bfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	static void bfs(int r,int c) {
		int[] dr= {-1,-1,-1,0,0,1,1,1},dc= {-1,0,1,-1,1,-1,0,1};
		Queue<P> queue = new ArrayDeque<>();
		queue.add(new P(r,c));
		visited[r][c]=true;
		while(!queue.isEmpty()) {
			P curP = queue.poll();
			for(int i=0;i<8;i++) {
				int nr = curP.r+dr[i];
				int nc = curP.c+dc[i];
				if(nr>=0&&nr<h&&nc>=0&&nc<w&&!visited[nr][nc]&&map[nr][nc]==1) {
					queue.add(new P(nr,nc));
					visited[nr][nc]=true;
				}
			}
		}
	}
	
	static class P{
		int r,c;
		public P(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
