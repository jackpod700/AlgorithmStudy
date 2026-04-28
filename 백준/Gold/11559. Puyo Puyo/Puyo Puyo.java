import java.util.*;
import java.io.*;

public class Main {
	static char[][] map=new char[12][6];
	static boolean changed;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<12;i++) {
			String s = br.readLine();
			for(int j=0;j<6;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		int count=0;
		bfs();
		while(changed) {
			for(int i=0;i<6;i++) {
				for(int j=0;j<12;j++) {
					if(map[j][i]=='-') {
						for(int k=j;k>0;k--) {
							map[k][i]=map[k-1][i];
						}
						map[0][i]='.';
					}
				}
			}
			count++;
			changed=false;
			bfs();
		}
		System.out.println(count);
	}
	static void bfs() {
		boolean[][] visited = new boolean[12][6];
		
		int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
		for(int r=0;r<12;r++) {
			for(int c=0;c<6;c++) {
				visited[r][c]=true;
				if(map[r][c]=='.'||map[r][c]=='-') continue;
				Queue<P> queue = new ArrayDeque<>();
				List<P> found = new ArrayList<>();
				queue.offer(new P(r,c));
				found.add(new P(r,c));

				char color = map[r][c];
				
				while(!queue.isEmpty()) {
					P curP = queue.poll();
					for(int i=0;i<4;i++) {
						int nr=curP.r+dr[i];
						int nc=curP.c+dc[i];
						if(nr>=0&&nr<12&&nc>=0&&nc<6&&!visited[nr][nc]&&map[nr][nc]==color) {
							P np = new P(nr,nc);
							queue.offer(np);
							visited[nr][nc]=true;
							found.add(np);
						}
					}
				}
				if(found.size()>3) {
					changed=true;
					for(P p:found) {
						map[p.r][p.c]='-';
					}
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
