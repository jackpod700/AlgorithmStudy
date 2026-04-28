import java.util.*;
import java.io.*;

public class Main {
	static int N,tail=0;
	static int[] A,longest;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		A=new int[N];
		longest=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) A[i]=Integer.parseInt(st.nextToken());
		longest[0]=A[0];
		for(int i=1;i<N;i++) {
			if(longest[tail]<A[i]) {
				longest[++tail]=A[i];
				continue;
			}
			int replaceIndex=lowerBound(A[i]);
			longest[replaceIndex]=A[i];
		}
		StringBuilder sb = new StringBuilder();
		System.out.println(tail+1);
	}
	
	static int lowerBound(int value) {
		int l=0,r=tail+1,m;
		while(l<r) {
			m=(l+r)/2;
			if(longest[m]>=value)r=m;
			else l=m+1;
		}
		return l;
	}
}
