import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),fn=sc.nextInt(),fnr=-1,fnc=-1;
		int[][] map = makeMap(n);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(map[i][j]+" ");
				if(map[i][j]==fn) {
					fnr=i;fnc=j;
				}
			}
            sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.print(sb);
		System.out.println(fnr+1+" "+(fnc+1));
	}
	
	static int[][] makeMap(int n){
		int[][] map = new int[n][n];
		int[] dr= {-1,0,1,0};
		int[] dc= {0,1,0,-1};
		int dCnt=0;
		int r=n/2, c=n/2,curDR=dr[dCnt], curDC=dc[dCnt],count=1;
		map[r][c]=count++;
		for(int length=1;length<n;length++) {
			int limit=2;
			if(length==n-1) limit=3;
			for(int i=0;i<limit;i++) {
				for(int j=0;j<length;j++) {
					r=r+curDR;
					c=c+curDC;
					map[r][c]=count++;
				}
				dCnt=(dCnt+1)%4;
				curDR=dr[dCnt];curDC=dc[dCnt];
			}
		}
		return map;
	}
}
