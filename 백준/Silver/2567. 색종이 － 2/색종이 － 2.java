import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static boolean map[][]= new boolean[100][100];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine()); 
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken()),y=Integer.parseInt(st.nextToken());
			for(int r=x;r<x+10;r++) {
				Arrays.fill(map[r], y, y+10, true);
			}
		}
		int count=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]) {
					if(i!=0&&!map[i-1][j])count++;
					if(j!=0&&!map[i][j-1])count++;
				}
				
			}
		}
		System.out.println(count*2);
	}
}
