import java.util.*;
import java.io.*;

public class Main{
	static int N,Q;
	static long[] tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		tree = new long[4*N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) tree[3*N+i]=Integer.parseInt(st.nextToken());
		init(0,N-1,1);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken());
			if(x>y) {
				x^=y;
				y^=x;
				x^=y;
			}
			sb.append(find(0,N-1,1,x,y)).append("\n");
			update(0,N-1,1,a,b);
			tree[3*N+a]=b;
		}
		System.out.print(sb);
	}
	
	static long init(int start,int end,int node) {
		if(start==end) return tree[node]=tree[3*N+start];
		int mid = (start+end)/2;
		return tree[node]=init(start,mid,node*2)+init(mid+1,end,node*2+1);
	}
	
	static long find(int start,int end,int node, int left,int right) {
		if(left>end||right<start) return 0;
		if(left<=start&&end<=right) return tree[node];
		int mid = (start+end)/2;
		return find(start,mid,node*2,left,right)+find(mid+1,end,node*2+1,left,right); 
	}
	
	static void update(int start,int end,int node,int index,int value) {
		if(index<start||index>end)return;
		tree[node]+=value-tree[3*N+index];
		if(start==end)return;
		int mid=(start+end)/2;
		update(start,mid,node*2,index,value);
		update(mid+1,end,node*2+1,index,value);
	}
}
