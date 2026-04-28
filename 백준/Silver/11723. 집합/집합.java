import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] set=new boolean[21];
		int M=Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			String command = st.nextToken();
			Integer in;
			switch(command) {
			case "add":
				in=Integer.parseInt(st.nextToken());
				if(!set[in]) set[in]=true;
				break;
			case "remove":
				in=Integer.parseInt(st.nextToken());
				if(set[in]) set[in]=false;
				break;
			case "check":
				in=Integer.parseInt(st.nextToken());
				if(set[in]) { 
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}
				break;
			case "toggle":
				in=Integer.parseInt(st.nextToken());
				set[in]=!set[in];
				break;
			case "all":
				Arrays.fill(set, true);
				break;
			case "empty":
				set=new boolean[21];
				break;
			}
		}
		System.out.println(sb);
	}
}