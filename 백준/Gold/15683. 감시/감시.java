import java.util.*;
import java.io.*;

public class Main {
	static int[] dr= {-1,0,1,0},dc= {0,1,0,-1};
	static int N,M,result=0;
	static int[][] map;
	static List<Camera> cameras=new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int value=Integer.parseInt(st.nextToken());
				map[i][j]=value;
				if(value==0) result++;
				else if(value>0&&value<6) cameras.add(new Camera(i,j,value));		
			}
		}
		Collections.sort(cameras);
		bt(0,result);
		System.out.println(result);
		
	}
	
	static void bt(int depth,int zeros) {
		if(depth==cameras.size()) {
			result=Math.min(result, zeros);
			return;
		}
		Camera curC=cameras.get(depth);
		int r=curC.r,c=curC.c,count=0;
		if(curC.type==5) {
			count=count(curC.type,r,c,0);
			bt(depth+1,zeros-count);
		}
		else if(curC.type==2) {
			for(int i=1;i<=2;i++) {
				count=count(curC.type,r,c,i);
				bt(depth+1,zeros-count);
				revert(curC.type,r,c,i);
			}
		}
		else{
			for(int i=0;i<4;i++) {
				count=count(curC.type,r,c,i);
				bt(depth+1,zeros-count);
				revert(curC.type,r,c,i);
			}
		}
		
	}
	
	static int count(int type,int r,int c,int i) {
		int count=0;
		for(int j=0;j<4;j++) {
			if(type==4&&j==i)continue;
			if(type==3&&(j==i||j==(i+1)%4))continue;
			if(type==2&&(j==i-1||j==i+1))continue;
			if(type==1&&j!=i)continue;
			int nr=r+dr[j],nc=c+dc[j];
			while(true) {
				if(check(nr,nc)&&map[nr][nc]<6) {
					if(map[nr][nc]==0)count++;
					if(map[nr][nc]<1)map[nr][nc]-=1;
				}
				else break;
				nr=nr+dr[j];
				nc=nc+dc[j];
			}
		}
		return count;
	}
	
	static void revert(int type,int r,int c,int i) {
		for(int j=0;j<4;j++) {
			if(type==4&&j==i)continue;
			if(type==3&&(j==i||j==(i+1)%4))continue;
			if(type==2&&(j==i-1||j==i+1))continue;
			if(type==1&&j!=i)continue;
			int nr=r+dr[j],nc=c+dc[j];
			
			while(true) {
				if(check(nr,nc)&&map[nr][nc]<6) {
					if(map[nr][nc]<0)map[nr][nc]+=1;
				}
				else break;
				nr=nr+dr[j];
				nc=nc+dc[j];
			}
		}
	}
	
	static boolean check(int nr,int nc) {
		return (nr>=0&&nr<N&&nc>=0&&nc<M);
	}

	static class Camera implements Comparable<Camera>{
		int r,c,type;
		public Camera(int r,int c,int type) {
			this.r=r;
			this.c=c;
			this.type=type;
		}
		@Override
		public int compareTo(Camera o) {
			return -1*Integer.compare(this.type, o.type);
		}
	}
}
