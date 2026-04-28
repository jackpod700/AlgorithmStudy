import java.util.*;
import java.io.*;

public class Main {
	static int N,result,brokeCount;
	static int[][] eggs;//0:내구도 1:무게
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		eggs = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			eggs[i][0]=Integer.parseInt(st.nextToken());
			eggs[i][1]=Integer.parseInt(st.nextToken());
		}
		
		bt(0);
		System.out.println(result);
	}
	
	static void bt(int egg) {
		if(egg==N||brokeCount>=N-1) {
			result=Math.max(result, brokeCount);
			return;
		}
		if(eggs[egg][0]<=0) {
			bt(egg+1);
			return;
		}
		for(int i=0;i<N;i++) {
			if(i==egg||eggs[i][0]<=0) continue;
			eggs[i][0]-=eggs[egg][1];
			eggs[egg][0]-=eggs[i][1];
			if(eggs[i][0]<=0)brokeCount++;
			if(eggs[egg][0]<=0)brokeCount++;
			bt(egg+1);
			if(eggs[i][0]<=0)brokeCount--;
			if(eggs[egg][0]<=0)brokeCount--;
			eggs[i][0]+=eggs[egg][1];
			eggs[egg][0]+=eggs[i][1];
		}
	}
}
