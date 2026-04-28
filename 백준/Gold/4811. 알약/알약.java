import java.util.*;
import java.io.*;

public class Main {
	static int N=1;
	static long[] d=new long[31];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		d[0]=1;
		d[1]=1;
		d[2]=2;
		while(true) {
			N=Integer.parseInt(br.readLine());
			if(N==0)break;
			System.out.println(dp(N));
		}
	}
	
	static long dp(int n) {
		if(d[n]!=0)return d[n];
		for(int i=0;i<=n-1;i++) {
			d[n]+=dp(i)*dp(n-1-i);
		}
		return d[n];
	}
}
