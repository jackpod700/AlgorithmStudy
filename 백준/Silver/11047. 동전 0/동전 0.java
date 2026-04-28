import java.util.*;
import java.io.*;
public class Main {
	static int N,K,result;
	static int[] A;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		A=new int[N];
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(br.readLine());
		}
		for(int i=N-1;i>=0;i--) {
			int coin=A[i];
			if(K>=coin) {
				result+=K/coin;
				K=K%coin;
			}
			if(K==0) break;
		}
		System.out.println(result);
	}
}
