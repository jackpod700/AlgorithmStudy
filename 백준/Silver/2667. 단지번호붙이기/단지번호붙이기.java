import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
	static int n,totalCount=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		List<Integer> houses = new ArrayList<>();
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==0||visited[i][j]) continue;
				houses.add(bfs(i,j));
				totalCount++;
			}
		}
		Collections.sort(houses);
		System.out.println(totalCount);
		for(Integer i:houses) System.out.println(i);
		
	}
	
	static int bfs(int r, int c) {
		int count=1;
		Queue<P> queue = new LinkedList<>();
		queue.add(new P(r,c));
		visited[r][c]=true;
		while(!queue.isEmpty()) {
			P curP = queue.poll();
			for(int i=0;i<4;i++) {
				int nr=curP.r+dr[i];
				int nc=curP.c+dc[i];
				if(nr>=0&&nr<n&&nc>=0&&nc<n&&!visited[nr][nc]&&map[nr][nc]==1) {
					visited[nr][nc]=true;
					queue.add(new P(nr,nc));
					count++;
				}
			}
		}
		return count;
		
	}
	
	static class P{
		int r,c;
		public P(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
}
