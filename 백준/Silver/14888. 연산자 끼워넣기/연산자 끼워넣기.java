import java.util.*;
import java.io.*;

public class Main {
	static int N,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
	static int[] numbers,opers=new int[4];
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		numbers=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			opers[i]=Integer.parseInt(st.nextToken());
		}
		
		dfs(1,numbers[0]);
		System.out.println(max+"\n"+min);
	}
	
	static void dfs(int depth, int val) {
		
		if(depth==N) {
			min=Math.min(min,val);
			max=Math.max(max,val);
			return;
		}
		
		if(opers[0]>0) {
			opers[0]--;
			dfs(depth+1,val+numbers[depth]);
			opers[0]++;
		}
		if(opers[1]>0) {
			opers[1]--;
			dfs(depth+1,val-numbers[depth]);
			opers[1]++;
		}
		if(opers[2]>0) {
			opers[2]--;
			dfs(depth+1,val*numbers[depth]);
			opers[2]++;
		}
		if(opers[3]>0) {
			opers[3]--;
			dfs(depth+1,val/numbers[depth]);
			opers[3]++;
		}
	}
}
