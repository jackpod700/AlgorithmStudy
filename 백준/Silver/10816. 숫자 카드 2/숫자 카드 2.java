import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static int[] A;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		A=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) A[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		M=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) { 
			int value=Integer.parseInt(st.nextToken());
			sb.append(upperBound(value)-lowerBound(value)).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	static int lowerBound(int value) {
		int l=0,r=N,m;
		while(l<r) {
			m=(l+r)/2;
			if(A[m]>=value)r=m;
			else l=m+1;
		}
		return l;
	}
	
	static int upperBound(int value) {
		int l=0,r=N,m;
		while(l<r) {
			m=(l+r)/2;
			if(A[m]>value)r=m;
			else l=m+1;
		}
		return l;
	}
}
