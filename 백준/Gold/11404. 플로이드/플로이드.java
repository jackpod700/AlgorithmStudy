import java.util.*;
import java.io.*;
public class Main {
	static int N,M;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		dist = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if(dist[a][b]==0)dist[a][b]=c;
			else dist[a][b]=Math.min(dist[a][b], c);
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(i==j||dist[i][k]==0||dist[k][j]==0)continue;
					if(dist[i][j]==0) dist[i][j]=dist[i][k]+dist[k][j];
					else dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				sb.append(dist[i][j]).append(" ");
			}
			sb.replace(sb.length()-1, sb.length(), "\n");
		}
		System.out.println(sb);
	}
}