import java.util.*;
import java.io.*;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine()," ");
		int r=Integer.parseInt(st.nextToken()),g=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken());
		int nr,ng,nb;
		for(int i=0;i<n-1;i++) {
			st=new StringTokenizer(br.readLine()," ");
			nr=Integer.parseInt(st.nextToken())+Math.min(g, b);
			ng=Integer.parseInt(st.nextToken())+Math.min(r, b);
			nb=Integer.parseInt(st.nextToken())+Math.min(g, r);
			r=nr;g=ng;b=nb;
		}
		System.out.println(Math.min(Math.min(r, g),b));
	}
}
