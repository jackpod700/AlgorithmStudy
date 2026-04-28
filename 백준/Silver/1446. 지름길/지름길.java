import java.io.*;
import java.util.*;

public class Main {
	static int N,D;
	static int[] d;
	static List<HW>[] highways;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		highways=new ArrayList[D+1];
		for(int i=0;i<=D;i++) highways[i]=new ArrayList<>();
		d=new int[D+1];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int src=Integer.parseInt(st.nextToken());
			int dest=Integer.parseInt(st.nextToken());
			int dist=Integer.parseInt(st.nextToken());
			if(dest>D)continue;
			highways[dest].add(new HW(src,dist));
		}
		for(int i=1;i<=D;i++) {
			d[i]=d[i-1]+1;
			int hwNum=highways[i].size();
			for(int j=0;j<hwNum;j++) {
				HW hw=highways[i].get(j);
				d[i]=Math.min(d[i], d[hw.src]+hw.dist);
			}
		}
		System.out.println(d[D]);
	}
	
	static class HW{
		int src,dist;
		public HW(int src,int dist) {
			this.src=src;
			this.dist=dist;
		}
	}
}
