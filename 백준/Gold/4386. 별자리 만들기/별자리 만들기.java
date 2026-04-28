import java.util.*;
import java.io.*;

public class Main{
	static int n;
	static double result=0.0;
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	static double[][] stars;
	static boolean[] in;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		in=new boolean[n+1];
		stars=new double[n+1][2];
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			stars[i][0]=Double.parseDouble(st.nextToken());
			stars[i][1]=Double.parseDouble(st.nextToken());
		}
		
		int curI=1;
		in[curI]=true;
		for(int i=2;i<=n;i++) {
			double dist = Math.sqrt(Math.pow(stars[curI][0]-stars[i][0],2)+Math.pow(stars[curI][1]-stars[i][1],2));
			queue.offer(new Edge(curI,i,dist));
		}
		for(int i=0;i<n-1;i++) {
			Edge curE=queue.poll();
			while(true) {
				if(in[curE.b]) curE=queue.poll();
				else break;
			}
			result+=curE.w;
			curI=curE.b;
			in[curI]=true;
			for(int j=1;j<=n;j++) {
				double dist = Math.sqrt(Math.pow(stars[curI][0]-stars[j][0],2)+Math.pow(stars[curI][1]-stars[j][1],2));
				queue.offer(new Edge(curI,j,dist));
			}
		}
		System.out.printf("%.2f",result);
	}
	
	static class Edge implements Comparable<Edge>{
		int a,b;
		double w;
		public Edge(int a,int b,double w) {
			this.a=a;
			this.b=b;
			this.w=w;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.w, o.w);
		}
		
	}
}
