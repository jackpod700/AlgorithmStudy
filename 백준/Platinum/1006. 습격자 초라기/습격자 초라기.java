import java.util.*;
import java.io.*;
public class Main {
	static int T,N,W,result;
	static int[][] e;
	static int[] a,b,c;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			e = new int[N][2];
			for(int i=0;i<2;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) e[j][i]=Integer.parseInt(st.nextToken());
			}
			a=new int[N+1];
			b=new int[N+1];
			c=new int[N+1];
			solve();
			System.out.println(result);
		}
	}
	static void solve() {
		//case1 0과 N-1이 연결되지 않는 경우
		a[0]=0;
		b[0]=1;
		c[0]=1;
		dp(0);
		result=a[N];
		if(N>1) {
			//case2 내부(0)의 0과 N-1이 연결되는 경우
			if(e[0][0]+e[N-1][0]<=W) {
				a[1]=1;
				b[1]=2;
				if(e[0][1]+e[1][1]<=W)c[1]=1;
				else c[1]=2;
				dp(1);
				result=Math.min(result, c[N-1]+1);
			}

			//case3 외부(1)의 0과 N-1이 연결되는 경우
			if(e[0][1]+e[N-1][1]<=W) {
				a[1]=1;
				c[1]=2;
				if(e[0][0]+e[1][0]<=W)b[1]=1;
				else b[1]=2;
				dp(1);
				result=Math.min(result, b[N-1]+1);
			}

			//case4 내외부의 0과 N-1이 연결되는 경우
			if(e[0][0]+e[N-1][0]<=W&&e[0][1]+e[N-1][1]<=W) {
				a[1]=0;
				b[1]=1;
				c[1]=1;
				dp(1);
				result=Math.min(result, a[N-1]+2);
			}
		}
	}
	
	static void dp(int start) {
		for(int i=start;i<N;i++) {
			a[i+1]=Math.min(b[i], c[i])+1;
			if(e[i][0]+e[i][1]<=W) {
				a[i+1]=Math.min(a[i+1], a[i]+1);
			}
			if(i>0&&e[i-1][0]+e[i][0]<=W&&e[i-1][1]+e[i][1]<=W) {
				a[i+1]=Math.min(a[i+1], a[i-1]+2);
			}
			if(i==N-1) break;
			b[i+1]=a[i+1]+1;
			if(e[i+1][0]+e[i][0]<=W) b[i+1]=Math.min(c[i]+1, b[i+1]);
			c[i+1]=a[i+1]+1;
			if(e[i+1][1]+e[i][1]<=W) c[i+1]=Math.min(b[i]+1, c[i+1]);
		}
	}
}
