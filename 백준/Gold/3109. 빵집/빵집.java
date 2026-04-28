import java.util.*;
import java.io.*;
public class Main {
	static int R,C;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken()); C=Integer.parseInt(st.nextToken());
		int count=0;
		
		map=new int[R][C];
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			char[] cs = s.toCharArray();
			for(int j=0;j<C;j++) {
				if(cs[j]=='x') map[i][j]=1;
			}
		}
		for(int i=0;i<R;i++) {
			if(dfs(i,0))count++;
		}
		System.out.println(count);
	}
	
	static boolean dfs(int r,int c) {
		if(r<0||r>R-1||c<0||c>C-1||map[r][c]==1) return false;
		if(c==C-1&&map[r][c]==0) {
			map[r][c]=1;
			return true;
		}
		map[r][c]=1;
		if(dfs(r-1,c+1)) return true;
		if(dfs(r,c+1)) return true;
		if(dfs(r+1,c+1)) return true;
		return false;
	}
	
}

