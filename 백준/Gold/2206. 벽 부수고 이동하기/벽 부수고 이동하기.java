import java.util.*;
import java.io.*;

public class Main {
	static int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
	static int N,M;
	static char[][] map;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		visited=new boolean[N][M][2];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		Queue<P> queue=new ArrayDeque<>();
		queue.offer(new P(0,0,1,0));
		visited[0][0][0]=true;
		while(!queue.isEmpty()) {
			P curP = queue.poll();
			if(curP.r==N-1&&curP.c==M-1) {
				System.out.println(curP.time);
				return;
			}
			for(int i=0;i<4;i++) {
				int nr=curP.r+dr[i];
				int nc=curP.c+dc[i];
				if(check(nr,nc)) {
					if(map[nr][nc]=='1'&&curP.broke==0&&!visited[nr][nc][1]) {
						queue.offer(new P(nr,nc,curP.time+1,1));
						visited[nr][nc][1]=true;
					}
					else if(map[nr][nc]=='0'&&!visited[nr][nc][curP.broke]) {
						queue.offer(new P(nr,nc,curP.time+1,curP.broke));
						visited[nr][nc][curP.broke]=true;
					}
				}
			}
		}
		System.out.println(-1);
	}
	
	static boolean check(int nr,int nc) {
		return (nr>=0&&nr<N&&nc>=0&&nc<M);
	}
	
	static class P{
		int r,c,time;
		int broke;
		public P(int r,int c,int time,int broke) {
			this.r=r;
			this.c=c;
			this.time=time;
			this.broke=broke;
		}
	}
}
