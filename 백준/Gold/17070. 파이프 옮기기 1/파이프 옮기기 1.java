import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int[][][] d;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		d=new int[N][N][3];//0:가로,1:세로,2:대각선
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int wall = Integer.parseInt(st.nextToken());
				if(wall==1) d[i][j][0]=d[i][j][1]=d[i][j][2]=-1;
			}
		}
		d[0][1][0]=1;
		System.out.println(dp(N-1,N-1,0)+dp(N-1,N-1,1)+dp(N-1,N-1,2));
	}
	
	static int dp(int r,int c,int stat) {
		if(r<0||r>=N||c<0||c>=N||d[r][c][stat]==-1)return 0;
		if(d[r][c][stat]!=0||(r==0&&c==0))return d[r][c][stat];
		if(stat==0) {
			d[r][c][stat]=dp(r,c-1,0)+dp(r,c-1,2);
		}
		else if(stat==1) {
			d[r][c][stat]=dp(r-1,c,1)+dp(r-1,c,2);
		}
		else {
			if((check(r,c-1)&&d[r][c-1][stat]==-1)||(check(r-1,c)&&d[r-1][c][stat]==-1))return 0;
			d[r][c][stat]=dp(r-1,c-1,0)+dp(r-1,c-1,1)+dp(r-1,c-1,2);
		}
		return d[r][c][stat];
	}
	
	static boolean check(int r,int c) {
		return r>=0&&r<N&&c>=0&&c<N;
	}
}
