import java.util.*;
import java.io.*;

public class Main {
	static int N,M,K;
	static int[][] mat,commands;
	static int[] dr= {1,0,-1,0};
	static int[] dc= {0,1,0,-1};
	
	static boolean[] visited;
	static int[] nums;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());

		visited = new boolean[K];
		nums = new int[K];
		mat=new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				mat[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		commands = new int[K][3];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			commands[i][0]=Integer.parseInt(st.nextToken())-1;
			commands[i][1]=Integer.parseInt(st.nextToken())-1;
			commands[i][2]=Integer.parseInt(st.nextToken());
		}
		
		System.out.println(perm(0));
	}
	
	static void rotate(int[][]mat, int r, int c, int s) {
		for(int depth=s;depth>0;depth--) {
			int boundRs=r-depth,boundCs=c-depth;
			int curR=boundRs, curC=boundCs,start=mat[curR][curC];
			for(int i=0;i<4;i++) {
				for(int j=0;j<depth*2;j++) {
					mat[curR][curC]=mat[curR+dr[i]][curC+dc[i]];
					curR+=dr[i];curC+=dc[i];
				}
			}
			mat[boundRs][boundCs+1]=start;
		}
	}
	
	static int findMin(int[][] mat) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			int sum=0;
			for(int j=0;j<M;j++) {
				sum+=mat[i][j];
			}
			min=Math.min(sum, min);
		}
		return min;
	}
	
	private static int perm(int cnt) {
		int min=Integer.MAX_VALUE;
		if(cnt==K) {
			int[][] temp=new int[N][M];
			for(int i=0;i<N;i++) {
				temp[i]=mat[i].clone();
			}
			for(int i=0;i<K;i++) {
				rotate(temp,commands[nums[i]][0],commands[nums[i]][1],commands[nums[i]][2]);
			}
			return findMin(temp);
		}
		
		for(int i=0;i<K;i++) {
			if(visited[i]==true)continue;
			visited[i]=true;
			nums[cnt]=i;
			min=Math.min(min,perm(cnt+1));
			visited[i]=false;
		}
		return min;
	}
}
