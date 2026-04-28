import java.util.*;
import java.io.*;

public class Main {
	static int N,w,b;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		recur(0,0,N);
		System.out.println(w+"\n"+b);
	}
	
	static void recur(int r,int c,int size) {
		if(!check(r,c,size)){
			recur(r,c,size/2);
			recur(r+(size/2),c,size/2);
			recur(r,c+(size/2),size/2);
			recur(r+(size/2),c+(size/2),size/2);
		}
	}
	
	static boolean check(int r,int c,int size) {
		int value=map[r][c];
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(map[i][j]!=value)return false;
			}
		}
		if(value==0)w++;
		else b++;
		return true;
	}
}
