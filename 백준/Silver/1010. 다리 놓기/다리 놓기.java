import java.util.*;
import java.io.*;

public class Main{
	static int[][] combination=new int[30][30];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(st.nextToken());
			System.out.println(combi(n,r));
		}
	}
	
	static int combi(int n,int r) {
		if(combination[n][r]!=0)return combination[n][r];
		if(n==r||r==0) return combination[n][r]=1;
		if(r==1) return combination[n][r]=n;
		return combination[n][r]=combi(n-1,r-1)+combi(n-1,r);
	}
}
