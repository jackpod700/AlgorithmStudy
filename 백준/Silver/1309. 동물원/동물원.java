import java.io.*;
public class Main {
	static final int DIV=9901;
	static int N,result;
	static int[][] d;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		d=new int[N][3];//d[a][b]:a번째 우리에 b=0->넣지 않음, b=1->왼쪽, d=2->오른쪽에넣음
		d[0][0]=1;
		d[0][1]=1;
		d[0][2]=1;
		result+=dp(N-1,0)%DIV;
		result+=dp(N-1,1)%DIV;
		result+=dp(N-1,2)%DIV;
		result%=DIV;
		System.out.println(result);
	}
	static int dp(int n,int b) {
		if(d[n][b]!=0)return d[n][b];
		d[n][b]=dp(n-1,0)+dp(n-1,1)+dp(n-1,2);
		if(b==1) d[n][b]-=dp(n-1,1);
		else if(b==2) d[n][b]-=dp(n-1,2);
		d[n][b]%=DIV;
		return d[n][b];
	}
}
