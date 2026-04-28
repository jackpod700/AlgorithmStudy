import java.util.*;
import java.io.*;

public class Main {
	static int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
	static int R,C,nextwater,nextg;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		visited=new boolean[R][C];
		Queue<P> wq=new ArrayDeque<>();
		Queue<P> gq=new ArrayDeque<>();
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='S') {
					map[i][j]='.';
					gq.offer(new P(i,j,0));
					visited[i][j]=true;
					nextg=1;
				}
				if(map[i][j]=='*') {
					wq.offer(new P(i,j,0));
					nextwater++;
				}
			}
		}
		while(!gq.isEmpty()) {
			int count=0;
			for(int i=0;i<nextwater;i++) {
				P curW=wq.poll();
				for(int j=0;j<4;j++) {
					int nr=curW.r+dr[j];
					int nc=curW.c+dc[j];
					if(check(nr,nc)&&map[nr][nc]=='.') {
						map[nr][nc]='*';
						wq.offer(new P(nr,nc,0));
						count++;
					}
				}
			}
			nextwater=count;
			count=0;
			for(int i=0;i<nextg;i++) {
				P curP = gq.poll();
				for(int j=0;j<4;j++) {
					int nr=curP.r+dr[j];
					int nc=curP.c+dc[j];
					if(check(nr,nc)&&!visited[nr][nc]) {
						if(map[nr][nc]=='D') {
							System.out.println(curP.time+1);
							return;
						}
						if(map[nr][nc]=='.') {
							gq.offer(new P(nr,nc,curP.time+1));
							visited[nr][nc]=true;
							count++;
						}
					}
				}
			}
			nextg=count;
		}
		System.out.println("KAKTUS");
		
	}
	
	static boolean check(int nr,int nc) {
		return (nr>=0&&nr<R&&nc>=0&&nc<C);
	}
	
	static class P{
		int r,c,time;
		public P(int r,int c,int time) {
			this.r=r;
			this.c=c;
			this.time=time;
		}
	}
}
