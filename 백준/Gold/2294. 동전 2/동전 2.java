import java.util.*;
import java.io.*;
public class Main {
	static int N,K;
	static int[] coins,d;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		coins=new int[N];
		d=new int[K+1];
		for(int i=0;i<N;i++) {
			int val=coins[i]=Integer.parseInt(br.readLine());
			if(val<=K) d[val]=1;
		}
		dp();
		if(d[K]==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(d[K]);
	}
	
	static void dp() {
		for(int i=1;i<=K;i++) {
			d[i]=Integer.MAX_VALUE;
			for(int c:coins) {
				if(i-c>=0&&d[i-c]!=Integer.MAX_VALUE) {
					d[i]=Math.min(d[i], d[i-c]+1);
				}
			}
		}
	}
}
