import java.io.*;

public class Main {
	static final int DIV=1_000_000_000;
	static int N,result;
	static int[][] d;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		d=new int[N+1][10];//N번째 숫자가 a(0~9)인 경우
		for(int i=1;i<10;i++)d[1][i]=1;
		for(int i=0;i<10;i++) {
			result+=dp(N,i);
			result%=DIV;
		}
		System.out.println(result);
	}
	
	static int dp(int n,int a) {
		if((n==1&&a==0)||d[n][a]!=0)return d[n][a];
		if(a==0) {
			d[n][a]=dp(n-1,1);
		}
		else if(a==9) {
			d[n][a]=dp(n-1,8);
		}
		else {
			d[n][a]=(dp(n-1,a-1)+dp(n-1,a+1))%DIV;
		}
		return d[n][a];
	}
}
