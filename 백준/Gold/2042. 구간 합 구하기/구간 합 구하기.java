import java.util.*;
import java.io.*;

public class Main {
	static int N,M,K;
	static long[] nums,sTree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		nums=new long[N];
		for(int i=0;i<N;i++) {
			nums[i]=Long.parseLong(br.readLine());
		}
		sTree=new long[N*4];
		makeNode(0,N-1,1);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M+K;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			long b=Long.parseLong(st.nextToken())-1;
			long c=Long.parseLong(st.nextToken());
			if(a==1) {
				long diff=c-nums[(int)b];
				nums[(int)b]=c;
				update(0,N-1,1,(int)b,diff);
			}else {
				sb.append(segSum(0,N-1,(int)b,(int)c-1,1)).append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static long makeNode(int start,int end, int node) {
		if(start==end) return sTree[node]=nums[start];
		int mid = (start+end)/2;
		return sTree[node]=makeNode(start,mid,node*2)+makeNode(mid+1,end,node*2+1);
	}
	
	static long segSum(int start,int end,int left,int right,int node) {
		if(right<start||end<left) return 0;
		if(left<=start&&end<=right) return sTree[node];
		int mid=(start+end)/2;
		return segSum(start,mid,left,right,node*2)+segSum(mid+1,end,left,right,node*2+1);
	}
	
	static void update(int start,int end,int node,int index, long diff) {
		if(index<start||index>end) return;
		sTree[node]+=diff;
		if(start==end)return;
		int mid = (start+end)/2;
		update(start,mid,node*2,index,diff);
		update(mid+1,end,node*2+1,index,diff);
	}
}
