import java.util.*;
import java.io.*;

public class Main {
	static int k;
	static int[][] gears=new int[4][8],rotation;
	static final int matchF=6,matchB=2;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        for(int i=0;i<4;i++) {
            String s = br.readLine();
            for(int j=0;j<8;j++) {
                gears[i][j]=Integer.parseInt(s.substring(j,j+1));
            }
        }
        k=Integer.parseInt(br.readLine());
        rotation=new int[k][2];
        for(int i=0;i<k;i++) {
            st=new StringTokenizer(br.readLine());
            rotation[i][0]=Integer.parseInt(st.nextToken())-1;
            rotation[i][1]=Integer.parseInt(st.nextToken());
        }
        System.out.println(solve());
	}
	static int solve() {
		for(int i=0;i<k;i++) {
			visited=new boolean[4];
			rotate(rotation[i][0],rotation[i][1]);
		}
		int result=0;
		for(int i=0;i<4;i++) {
			if(gears[i][0]==1)result+=Math.pow(2, i);
		}
		return result;
	}
	
	static void rotate(int index,int dir) {
		visited[index]=true;
		if(dir==1)rotateCW(index);
		else rotateCCW(index);
		
		if(index-1>=0&&gears[index-1][matchB]!=gears[index][matchF+dir]&&!visited[index-1]) {
			rotate(index-1,dir*-1);
		}
		if(index+1<4&&gears[index+1][matchF]!=gears[index][matchB+dir]&&!visited[index+1]) {
			rotate(index+1,dir*-1);
		}
	}
	static void rotateCCW(int index) {
		int first = gears[index][0];
		for(int i=0;i<7;i++) {
			gears[index][i]=gears[index][i+1];
		}
		gears[index][7]=first;
	}
	static void rotateCW(int index) {
		int last = gears[index][7];
		for(int i=7;i>0;i--) {
			gears[index][i]=gears[index][i-1];
		}
		gears[index][0]=last;
	}
}
