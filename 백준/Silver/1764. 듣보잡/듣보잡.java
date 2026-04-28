import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken()),M=Integer.parseInt(st.nextToken());
		Set<String> listen=new HashSet<String>();
		for(int i=0;i<N;i++) {
			listen.add(br.readLine());
		}
		StringBuilder sb = new StringBuilder();
		List<String> list=new ArrayList<>();
		for(int i=0;i<M;i++) {
			String name=br.readLine();
			if(listen.contains(name)) {
				list.add(name);
			}
		}
		list.sort(null);
		for(String s:list) {
			sb.append(s+"\n");
		}
		System.out.println(list.size()+"\n"+sb);
	}
}
