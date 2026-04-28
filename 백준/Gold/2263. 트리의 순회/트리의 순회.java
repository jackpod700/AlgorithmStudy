import java.util.*;
import java.io.*;
public class Main {
	static int N,k=0;
	static int[] in,post,pre,root;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		in=new int[N];
		post=new int[N];
		pre=new int[N];
		root=new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			in[i]=Integer.parseInt(st.nextToken());
			root[in[i]]=i;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			post[i]=Integer.parseInt(st.nextToken());
		}
		recur(0,N-1,0,N-1);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) sb.append(pre[i]).append(" ");
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	static void recur(int inS,int inE,int postS,int postE) {
		pre[k++]=post[postE];
		if(inS==inE) return;
		int rootIndex=root[post[postE]];
		if(rootIndex!=inS)recur(inS,rootIndex-1,postS,postS+rootIndex-inS-1);
		if(rootIndex!=inE)recur(rootIndex+1,inE,postS+rootIndex-inS,postE-1);
	}
}
