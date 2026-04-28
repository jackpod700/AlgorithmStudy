import java.util.*;
import java.io.*;

public class Main {
	static int N,min=Integer.MAX_VALUE;
	static int[][] ingr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		ingr = new int[N][2];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			ingr[i][0]=Integer.parseInt(st.nextToken());
			ingr[i][1]=Integer.parseInt(st.nextToken());
		}
		subset(0,0,1);
		System.out.println(min);
	}
	
	static void subset(int depth, int tot, int mul) {
		if (depth == N) {
			if (tot == 0) return;
			
			min = Math.min(min, Math.abs(tot - mul));
			return;
		}
		
		subset(depth + 1, tot + ingr[depth][1], mul * ingr[depth][0]);
		subset(depth + 1, tot, mul);
	}
}
