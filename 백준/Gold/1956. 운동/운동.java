import java.util.*;
import java.io.*;
public class Main {
	static int V,E;
	static int[][] dist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		dist=new int[V+1][V+1];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int src=Integer.parseInt(st.nextToken());
			int dest=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			dist[src][dest]=w;
		}
		for(int k=1;k<=V;k++) {
			for(int i=1;i<=V;i++) {
				for(int j=1;j<=V;j++) {
					if(i==j||dist[i][k]==0||dist[k][j]==0)continue;
					if(dist[i][j]==0)dist[i][j]=dist[i][k]+dist[k][j];
					else dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
				}
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i=1;i<=V;i++) {
			for(int j=1;j<=V;j++) {
				if(i==j||dist[i][j]==0||dist[j][i]==0)continue;
				min=Math.min(min, dist[i][j]+dist[j][i]);
			}
		}
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
}
