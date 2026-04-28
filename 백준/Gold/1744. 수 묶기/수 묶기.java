import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()),result=0;
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(a);
		
		for(int i=n-1;i>=0;i-=2) {
			if(i==0) {
				if(a[i]>0)result+=a[i];
				continue;
			}
			int _1=a[i-1],_2=a[i];
			if(_1<=0&&_2<=0)break;
			
			if(_1>1&&_2>1) {
				result+=_1*_2;
				continue;
			}
			if(_1<0&&_2>0) {
				result+=_2;
				break;
			}
			result+=_1+_2;
		}
		for(int i=0;i<n;i+=2) {
			if(i==n-1) {
				if(a[i]<0)result+=a[i];
				continue;
			}
			
			int _1=a[i],_2=a[i+1];
			if(_1>=0&&_2>=0)break;
			if(_1<0&&_2<0) {
				result+=_1*_2;
				continue;
			}
			if(_1<0&&_2==0)continue;
			if(_1<0&&_2>0)result+=_1;
			
		}
		System.out.println(result);
	}
}
