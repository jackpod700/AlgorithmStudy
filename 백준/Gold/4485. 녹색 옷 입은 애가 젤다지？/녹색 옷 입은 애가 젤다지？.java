import java.util.*;
import java.io.*;

public class Main {
	static int[] dr= {-1,0,0,1},dc= {0,-1,1,0};
	static int N,problem=1;
	static int[][] map;
	static int[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			N=Integer.parseInt(br.readLine());
			if(N==0)return;
			visited=new int[N][N];
			for(int i=0;i<N;i++) Arrays.fill(visited[i], 1000000);
			map = new int[N][N];
			StringTokenizer st;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			Queue<Node> queue = new PriorityQueue<>();
			queue.add(new Node(0,0,map[0][0]));
			visited[0][0]=map[0][0];
			while(!queue.isEmpty()) {
				Node curNode = queue.poll();
				if(curNode.r==N-1&&curNode.c==N-1) {
					System.out.println("Problem "+problem+": "+curNode.w);
					problem++;
					break;
				}
				for(int i=0;i<4;i++) {
					int nr=curNode.r+dr[i];
					int nc=curNode.c+dc[i];
					if(check(nr,nc)&&(curNode.w+map[nr][nc]<visited[nr][nc])) {
						queue.add(new Node(nr,nc,curNode.w+map[nr][nc]));
						visited[nr][nc]=curNode.w+map[nr][nc];
					}
				}
				
			}
		}


	}
	
	static boolean check(int nr,int nc) {
		return (nr>=0&&nr<N&&nc>=0&&nc<N);
	}
	
	static class Node implements Comparable<Node>{
		int r,c,w;
		public Node(int r,int c,int w) {
			this.r=r;
			this.c=c;
			this.w=w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
}
