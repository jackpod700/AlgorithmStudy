import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static int[] tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		tree=new int[4*N];
		for(int i=0;i<N;i++) tree[3*N+i]=Integer.parseInt(br.readLine());
		init(0,N-1,1);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			sb.append(find(0,N-1,1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1)).append("\n");			
		}
		System.out.print(sb);
	}
	
	static int init(int start,int end, int node) {
		if(start==end) return tree[node]=tree[3*N+start];
		int mid=(start+end)/2;
		return tree[node]=Math.min(init(start,mid,node*2),init(mid+1,end,node*2+1));
	}
	
	static int find(int start,int end,int node,int left,int right) {
		if(left>end||right<start)return Integer.MAX_VALUE;
		if(left<=start&&end<=right) return tree[node];
		int mid=(start+end)/2;
		return Math.min(find(start,mid,node*2,left,right), find(mid+1,end,node*2+1,left,right));
	}
}
