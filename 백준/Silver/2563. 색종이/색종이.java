import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static boolean[][] color=new boolean[100][100];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()), c=Integer.parseInt(st.nextToken());;
			for(int j=r;j<r+10;j++) {
				for(int k=c;k<c+10;k++) {
					color[j][k]=true;
				}
			}
		}
		int count=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(color[i][j])count++;
			}
		}
		System.out.println(count);
	}
}
