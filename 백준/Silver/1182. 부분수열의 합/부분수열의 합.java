import java.util.*;
import java.io.*;

public class Main{
	static int N,S,result;
	static int[] stones;
	static int sum,setNum;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		stones = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			stones[i]=Integer.parseInt(st.nextToken());
		}
		subset(0,true);
		subset(0,false);
		System.out.println(result);
	}
	
	static void subset(int depth,boolean TF) {
		if(depth==N) {
			if(sum==S&&setNum>0) result++;
			return;
		}
		
		if(TF) {
			sum+=stones[depth];
			setNum++;
		}
		subset(depth+1,true);
		if(depth<N-1)subset(depth+1,false);
		if(TF) {
			sum-=stones[depth];
			setNum--;
		}
	}
}