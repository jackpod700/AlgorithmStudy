
import java.util.*;
import java.io.*;

public class Main {
	static int[] dr= {-1,0,0,1};
	static int[] dc= {0,-1,1,0};
	static int R,C,T;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int ACDR=0;
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					ACDR=i;
				}
			}
		}
		for(int i=0;i<T;i++) {
			spread();
			ACUrotate(ACDR-1);
			ACDrotate(ACDR);
		}
		System.out.println(calcDust());
		
	}
	
	public static void spread() {
		int[][] dMap = new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==-1)continue;
				int dust=map[i][j]/5;
				if(dust==0)continue;
				
				for(int k=0;k<4;k++) {
					int nr=i+dr[k],nc=j+dc[k];
					if(nr>=0&&nr<R&&nc>=0&&nc<C&&map[nr][nc]!=-1) {
						dMap[nr][nc]+=dust;
						dMap[i][j]-=dust;
					}
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]+=dMap[i][j];
			}
		}
		
	}
	public static void ACUrotate(int rowBound) {
		int[] dr= {-1,0,1,0},dc= {0,1,0,-1};
		int curR=rowBound-1,curC=0,i=0;
		while(curR!=rowBound||curC!=0) {
			int nr=curR+dr[i], nc=curC+dc[i];
			if(nr<0||nr>rowBound||nc<0||nc>C-1) i++;
			nr=curR+dr[i]; nc=curC+dc[i];
			map[curR][curC]=map[nr][nc];
			curR=nr;curC=nc;
		}
		map[rowBound][1]=0;
	}
	
	public static void ACDrotate(int rowBound) {
		int[] dr= {1,0,-1,0},dc= {0,1,0,-1};
		int curR=rowBound+1,curC=0,i=0;
		while(curR!=rowBound||curC!=0) {
			int nr=curR+dr[i], nc=curC+dc[i];
			if(nr<rowBound||nr>R-1||nc<0||nc>C-1) i++;
			nr=curR+dr[i]; nc=curC+dc[i];
			map[curR][curC]=map[nr][nc];
			curR=nr;curC=nc;
		}
		map[rowBound][1]=0;
	}
	
	public static int calcDust() {
		int count=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==-1) continue;
				count+=map[i][j];
			}
		}
		return count;
	}
}