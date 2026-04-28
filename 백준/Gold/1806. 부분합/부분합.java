import java.util.*;
import java.io.*;

public class Main {
	static int n,S;
	static int[] a;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());S=Integer.parseInt(st.nextToken());
		a=new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		
		int min=Integer.MAX_VALUE,s=0,e=0,sum=a[0];
		while(e<n&&min!=1) {
			if(sum<S) {
				sum+=a[++e];
				continue;
			}
			min=Math.min(e-s+1,min);
			sum-=a[s++];
		}
		if(min==Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(min);
	}
}
