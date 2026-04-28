import java.util.*;
import java.io.*;

public class Main{
	static int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
	static int R,C,max;
	static int[][] map,memo;
	static int visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map = new int[R][C];
		memo = new int[R][C];
		visited=0;
		for(int i=0;i<R;i++) {
			String s=br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=1<<(s.charAt(j)-'A');
			}
		}
		travel(0,0);
		System.out.println(max);
	}
	
	static void travel(int r, int c) {
		visited|=map[r][c];
		if(visited==memo[r][c])return;
		memo[r][c]=visited;
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			if(check(nr,nc)&&(visited & map[nr][nc])==0) {
				travel(nr,nc);
				visited=visited&(~map[nr][nc]);
			}
		}
		max=Math.max(max, Integer.bitCount(visited));
	}

	static boolean check(int nr, int nc) {
		return (nr>=0&&nr<R&&nc>=0&&nc<C);
	}
}
