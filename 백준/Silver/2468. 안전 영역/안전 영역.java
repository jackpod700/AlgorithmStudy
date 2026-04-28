import java.util.*;
import java.io.*;

public class Main {
	static int N,minHeight=1000,maxHeight=0,maxSafe=1;
	static int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
	static int[][] map;
	static int[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited=new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
				minHeight = Math.min(minHeight, map[i][j]);
			}
		}
		
		for(int i=minHeight;i<maxHeight;i++) {
			int count=0;
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(map[j][k]>i&&visited[j][k]!=i) {//높이가 수면과 같거나 낮은경우
						bfs(j,k,i);
						count++;
					}
				}
			}
			maxSafe=Math.max(maxSafe, count);
		}
		System.out.println(maxSafe);
		
	}
	
	static void bfs(int r,int c,int waterLevel) {
		Queue<P> queue=new ArrayDeque<>();
		queue.add(new P(r,c));
		visited[r][c]=waterLevel;
		while(!queue.isEmpty()) {
			P curP=queue.poll();
			for(int i=0;i<4;i++) {
				int nr=curP.r+dr[i];
				int nc=curP.c+dc[i];
				if(nr>=0&&nr<N&&nc>=0&&nc<N&&visited[nr][nc]!=waterLevel&&map[nr][nc]>waterLevel) {
					queue.add(new P(nr,nc));
					visited[nr][nc]=waterLevel;
				}
			}
		}
	}
	
	static class P{
		int r,c;
		public P(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}
}
