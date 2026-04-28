import java.util.*;
import java.io.*;
public class Main {
	static int N,K,l,r;
	static int[] ks;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		ks = new int[K];
		for(int i=0;i<K;i++) {
			ks[i]=Integer.parseInt(br.readLine());
			r=Math.max(r, ks[i]);
		}
		System.out.println(search());
	}
	static int search() {
		int m;
		while(l<r) {
			m=((l+r)>>>1)+1;
			int result=0;
			boolean able=false;
			for(int i=0;i<K;i++) {
				result+=ks[i]/m;
				if(result>=N) {
					able=true;
					break;
				}
			}
			if(able) l=m;
			else r=m-1;
		}
		return l;
	}
}
