import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static int[] minTree,maxTree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		minTree=new int[2*N];
		maxTree=new int[2*N];
		for(int i=0;i<N;i++) {
			maxTree[N+i]=minTree[N+i]=Integer.parseInt(br.readLine());
		}
		for(int i=N-1;i>0;i--) {
			minTree[i]=Math.min(minTree[i<<1],minTree[i<<1|1]);
			maxTree[i]=Math.max(maxTree[i<<1],maxTree[i<<1|1]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			sb.append(findMin(a,b)).append(" ").append(findMax(a,b)).append("\n");
		}
		System.out.print(sb);
	}
	
	static int findMin(int left,int right) {
		int result=Integer.MAX_VALUE;
		left+=N;
		right+=N;
		while(left<=right) {
			if((left&1)==1) result=Math.min(result, minTree[left++]);
			if((right&1)==0) result=Math.min(result, minTree[right--]);
			left=left>>1;
			right=right>>1;
		}
		return result;
	}
	
	static int findMax(int left,int right) {
		int result=Integer.MIN_VALUE;
		left+=N;
		right+=N;
		while(left<=right) {
			if((left&1)==1) result=Math.max(result, maxTree[left++]);
			if((right&1)==0) result=Math.max(result, maxTree[right--]);
			left=left>>1;
			right=right>>1;
		}
		return result;
	}
}
