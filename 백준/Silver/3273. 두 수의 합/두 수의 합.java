import java.io.*;
import java.util.*;

public class Main {
	static int n,x;
	static int a[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		a = new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		x=Integer.parseInt(br.readLine());
		Arrays.sort(a);
		int s=0,e=a.length-1,count=0;
		while(s!=e) {
			int sum=a[s]+a[e];
			if(sum>x) {
				e--;
				continue;
			}
			if(sum==x)count++;
			s++;
		}
		System.out.println(count);
	}
}
