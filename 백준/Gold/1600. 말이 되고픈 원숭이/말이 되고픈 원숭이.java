import java.util.*;
import java.io.*;
public class Main {
	static int[] Mdr= {-1,0,0,1},Mdc= {0,-1,1,0},Hdr={-1,-2,-2,-1,1,2,2,1},Hdc= {-2,-1,1,2,2,1,-1,-2};
	static int K,W,H;
	static int[][] map;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		map=new int[H][W];
		visited=new boolean[H][W][K+1];
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<P> queue = new ArrayDeque<>();
		queue.add(new P(0,0,0,0));
		visited[0][0][0]=true;
		while(!queue.isEmpty()) {
			P curP = queue.poll();
			if(curP.r==H-1&&curP.c==W-1) {
				System.out.println(curP.time);
				return;
			}
			if(curP.k<K) {
				for(int i=0;i<8;i++) {
					int nr=curP.r+Hdr[i];
					int nc=curP.c+Hdc[i];
					if(check(nr,nc,curP.k+1)) {
						queue.add(new P(nr,nc,curP.k+1,curP.time+1));
						visited[nr][nc][curP.k+1]=true;
					}
				}
			}
			for(int i=0;i<4;i++) {
				int nr=curP.r+Mdr[i];
				int nc=curP.c+Mdc[i];
				if(check(nr,nc,curP.k)) {
					queue.add(new P(nr,nc,curP.k,curP.time+1));
					visited[nr][nc][curP.k]=true;
				}
			}
		}
		System.out.println(-1);
	}
	
	static boolean check(int nr,int nc,int k) {
		return (nr>=0&&nr<H&&nc>=0&&nc<W&&!visited[nr][nc][k]&&map[nr][nc]==0);
	}
	
	static class P{
		int r,c,k,time;
		public P(int r, int c,int k,int time) {
			this.r=r;
			this.c=c;
			this.k=k;
			this.time=time;
		}
	}
}
