import java.util.*;
import java.io.*;
public class Main{
	static int N,M,K,result=0;
	static String[] inputs;
	static long[] map;
	static long filter;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		for(int i=0;i<M;i++)filter = (filter|1)<<1;
		map=new long[N];
		inputs=new String[N];
		for(int i=0;i<N;i++) {
			inputs[i]=br.readLine();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int bit=inputs[i].charAt(j)-'0';
				map[i]=((map[i]|bit)<<1);
			}
		}
		K=Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int tresult=0;
			long change = ~map[i];
			int zeros=M-Long.bitCount(map[i]);
			if(zeros>K || (K-zeros)%2==1)continue;
			for(int j=0;j<N;j++) {
				if(((map[j]^change)&filter)==filter) tresult++;
			}
			result=Math.max(result,tresult);
		}
		System.out.println(result);
		
	}
}
