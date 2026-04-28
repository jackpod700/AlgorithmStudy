import java.util.*;
import java.io.*;

public class Main {
	static int N,result;
	static int[] A;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		if(N<=2) {
			System.out.println(result);
			return;
		}
		A=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		for(int i=0;i<N;i++) {
			int s=0,e=N-1;
			if(i==0) s=1;
			if(i==N-1) e=N-2;
			while(true) {
				if(s>=e)break;
				if(A[s]+A[e]==A[i]) {
					result++;
					break;
				}
				
				if(A[s]+A[e]>A[i]) e--;
				else s++;
				if(i==s) s++;
				if(i==e) e--;
			}
		}
		System.out.println(result);
	}
}
