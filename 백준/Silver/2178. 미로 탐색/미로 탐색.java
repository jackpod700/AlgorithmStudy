import java.util.*;

public class Main {
	static int n,m;
	static int[][] map;
	static int[] dr= {-1,0,0,1};
	static int[] dc= {0,-1,1,0};
	static boolean[][] visited; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		sc.nextLine();
		map=new int[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(s.substring(j,j+1));
			}
		}
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(0,0,1));
		visited[0][0]=true;
		
		while(!queue.isEmpty()) {
			Pair cur = queue.poll();
			if(cur.r==n-1&&cur.c==m-1) {
				System.out.println(cur.distance);
				break;
			}
			for(int i=0;i<4;i++) {
				int r=cur.r+dr[i];
				int c=cur.c+dc[i];
				if(r<0||r>=n||c<0||c>=m||visited[r][c]==true||map[r][c]==0) continue;
				queue.add(new Pair(r,c,cur.distance+1));
				visited[r][c]=true;
			}
		}
	}
	
}
class Pair {
	int r,c,distance;
	public Pair(int r,int c,int distance) {
		this.r=r;
		this.c=c;
		this.distance=distance;
	}
}