import java.util.*;
import java.io.*;

public class Main{
	static int n;
	static int a[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		a=new int[n];
		
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		
		int s=0,e=n-1,min1=a[0],min2=a[n-1],min=Math.abs(min1+min2);
		while(s!=e) {
			if(min==0)break;
			int sum=a[s]+a[e];
			if(Math.abs(sum)<min) {
				min=Math.abs(sum);min1=a[s];min2=a[e];
			}
			if(sum<0)s++;
			else e--;
		}
		System.out.println(min1+" "+min2);
	}
}
