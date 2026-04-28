import java.io.*;
import java.util.*;

public class Main {
	static int N,cnt=0;
	static Map<String,Integer> in=new HashMap<>();
	static Map<String,List<String>> adj=new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String src = st.nextToken();
			String dest = st.nextToken();
			if(!in.containsKey(dest))in.put(dest, 0);
			if(!in.containsKey(src))in.put(src, 0);
			if(!adj.containsKey(dest))adj.put(dest, new ArrayList<>());
			if(!adj.containsKey(src))adj.put(src, new ArrayList<>());
			in.put(dest, in.get(dest)+1);
			adj.get(src).add(dest);
		}
		
		Queue<String> queue = new PriorityQueue<>();
		List<String> next=new ArrayList<>();
		in.forEach((key,value)->{
			if(value==0)next.add(key);
		});
		StringBuilder sb = new StringBuilder();
		while(!next.isEmpty()) {
			queue.addAll(next);
			next.clear();
			while(!queue.isEmpty()) {
				String cur=queue.poll();
				sb.append(cur).append("\n");
				cnt++;
				if(adj.get(cur).isEmpty()) continue;
				for(String n:adj.get(cur)) {
					in.put(n, in.get(n)-1);
					if(in.get(n)==0) next.add(n);
				}
			}
		}

		
		if(cnt!=in.keySet().size()) System.out.println(-1);
		else System.out.print(sb);
	}
}
