import java.util.*;

public class Main {
	static int n,m,max=Integer.MIN_VALUE;
	static int[][] map;
	static List<Area> blank;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		map = new int[n][m];
		blank = new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==0) blank.add(new Area(i,j));
			}
		}
		
		for(int i=0;i<blank.size()-2;i++) {
			for(int j=i+1;j<blank.size()-1;j++) {
				for(int k=j+1;k<blank.size();k++) {
					int[][] tempMap = new int[n][m];
					for(int r=0;r<n;r++) {
						tempMap[r]=map[r].clone();
					}
					
					tempMap[blank.get(i).r][blank.get(i).c]=1;
					tempMap[blank.get(j).r][blank.get(j).c]=1;
					tempMap[blank.get(k).r][blank.get(k).c]=1;
					max=Math.max(max, calcArea(tempMap));
//					int calc = calcArea(tempMap);
//					if(calc>max) {
//						System.out.println("=============================================");
//						System.out.printf("벽 위치:(%d,%d),(%d,%d),(%d,%d)\n안전구역: %d\n",blank.get(i).r,blank.get(i).c,blank.get(j).r,blank.get(j).c,blank.get(k).r,blank.get(k).c,calc);
//						System.out.println("=============================================");
//					}
//					max=Math.max(max, calc);
				}	
			}
		}
		System.out.println(max);
	}
	
	//임의의 벽 3개를 채운 tempMap에 대해 바이러스가 퍼진 후 남은 0구역의 개수를 반환하는 함수
	static int calcArea(int[][] tempMap) {
		boolean[][] visited = new boolean[n][m];
		int[] dr= {-1,0,0,1};
		int[] dc= {0,-1,1,0};
		//tempMap의 (0,0)부터 (n,m)까지 돌아보면서
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				//현재 위치가 2가 아니거나 이미 방문했다면 건너뛴다
				if(tempMap[i][j]!=2||visited[i][j]==true)continue;
				//현재위치가 2이고 방문한적이 없다면 BFS를 진행하여 빈공간에 바이러스를 채운다.
				Queue<Area> queue = new ArrayDeque<>();
				queue.add(new Area(i,j));	//현재 보고있는(i,j)를 시작점으로 하여 큐에 넣는다
				while(!queue.isEmpty()) {	//큐가 비면 접근가능한 영역이 없다는 뜻
					Area curArea = queue.poll();
					visited[curArea.r][curArea.c]=true;
					tempMap[curArea.r][curArea.c]=2;
					for(int k=0;k<4;k++) {
						int newR=curArea.r+dr[k];
						int newC=curArea.c+dc[k];
						if(newR>=0&&newR<n&&newC>=0&&newC<m&&tempMap[newR][newC]==0) {
							queue.add(new Area(newR,newC));
						}
					}
				}
				
			}
		}
		
		//영역 채우기가 끝났으니 0의 개수를 센다
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(tempMap[i][j]==0)count++;
			}
		}
		return count;
	}
}

class Area{
	int r,c;
	public Area(int r, int c) {
		this.r=r;
		this.c=c;
	}
}