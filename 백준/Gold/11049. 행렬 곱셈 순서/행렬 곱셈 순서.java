import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] matrices;
	static int[] calc;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		matrices = new int[n*(n+1)/2][2];
		calc = new int[n*(n+1)/2];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			matrices[i][0]=Integer.parseInt(st.nextToken());
			matrices[i][1]=Integer.parseInt(st.nextToken());
		}
		System.out.println(dp(0,1));
	}
	private static int dp(int i, int depth) {
		// TODO Auto-generated method stub
		int curIndex = getIndex(i,depth);
		
		if(depth==n) return 0;
		if(calc[curIndex]!=0)return calc[curIndex];
		int min=Integer.MAX_VALUE;
		for(int j=0;j<n-depth;j++) {
			int _1MatrixDepth = n-j;
			int _2MatrixDepth = depth+j+1;
			int _1MatrixCalcIndex = i;
			int _2MatrixCalcIndex = i+j+1;
			int _1MatrixIndex = getIndex(_1MatrixCalcIndex,_1MatrixDepth);
			int _2MatrixIndex = getIndex(_2MatrixCalcIndex,_2MatrixDepth);
			
			int calcResult = dp(_1MatrixCalcIndex,_1MatrixDepth)+dp(_2MatrixCalcIndex,_2MatrixDepth);
			calcResult+=matrices[_1MatrixIndex][0]* matrices[_1MatrixIndex][1]*matrices[_2MatrixIndex][1];
			if(min>calcResult) {
				min=calcResult;
				matrices[curIndex][0]=matrices[_1MatrixIndex][0];
				matrices[curIndex][1]=matrices[_2MatrixIndex][1];
			}
		}
        calc[curIndex]=min;
		return min;
	}
	static int getIndex(int index,int depth) {
		int baseIndex = (n*(n+1)/2)-(depth*(depth+1)/2);
		return baseIndex+index;
	}
}
