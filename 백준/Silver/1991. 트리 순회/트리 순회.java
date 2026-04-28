import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static char[][] nodes;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		nodes=new char[N][2];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int index = st.nextToken().charAt(0)-'A';
			nodes[index][0]=st.nextToken().charAt(0);
			nodes[index][1]=st.nextToken().charAt(0);
		}
		sb=new StringBuilder();
		pre(0);sb.append("\n");
		in(0);sb.append("\n");
		post(0);
		System.out.println(sb);
	}
	private static void post(int cur) {
		// TODO Auto-generated method stub
		if(nodes[cur][0]!='.') post(nodes[cur][0]-'A');
		if(nodes[cur][1]!='.') post(nodes[cur][1]-'A');
		sb.append((char)(cur+'A'));
	}
	private static void in(int cur) {
		// TODO Auto-generated method stub
		if(nodes[cur][0]!='.') in(nodes[cur][0]-'A');
		sb.append((char)(cur+'A'));
		if(nodes[cur][1]!='.') in(nodes[cur][1]-'A');
	}
	private static void pre(int cur) {
		// TODO Auto-generated method stub
		sb.append((char)(cur+'A'));
		if(nodes[cur][0]!='.') pre(nodes[cur][0]-'A');
		if(nodes[cur][1]!='.') pre(nodes[cur][1]-'A');
	}
}
