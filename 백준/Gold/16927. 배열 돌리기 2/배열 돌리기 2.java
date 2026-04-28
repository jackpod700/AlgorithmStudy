import java.util.*;
import java.io.*;

public class Main {
	static int N,M,R;
	static int[][] mat;
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				mat[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		int min=Math.min(N, M);
		for(int i=0;2*i<min;i++) {
			putList(mat,rotateArray(getArray(mat,i),R),i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(mat[i][j]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.print(sb);
	}
	//루프 하나의 배열 추출
	static List<Integer> getArray(int map[][], int depth){
		List<Integer> result=new ArrayList<>();
		int boundRs=depth,boundRe=N-depth-1;
		int boundCs=depth,boundCe=M-depth-1;
		
		for(int i=boundCs;i<=boundCe;i++) {
			result.add(map[boundRs][i]);
		}
		for(int i=boundRs+1;i<=boundRe;i++) {
			result.add(map[i][boundCe]);
		}
		for(int i=boundCe-1;i>=boundCs;i--) {
			result.add(map[boundRe][i]);
		}
		for(int i=boundRe-1;i>boundRs;i--) {
			result.add(map[i][boundCs]);
		}
		
		return result;
	}
	
	static List<Integer> rotateArray(List<Integer> array, int rotate){
		rotate=rotate%array.size();
		for(int i=0;i<rotate;i++) {
			array.add(array.get(0));
			array.remove(0);
		}
		return array;
	}
	
	static void putList(int map[][],List<Integer> array, int depth) {
		int boundRs=depth,boundRe=N-depth-1;
		int boundCs=depth,boundCe=M-depth-1;
		
		for(int i=boundCs;i<=boundCe;i++) {
			map[boundRs][i]=array.get(0);
			array.remove(0);
		}
		for(int i=boundRs+1;i<=boundRe;i++) {
			map[i][boundCe]=array.get(0);
			array.remove(0);
		}
		for(int i=boundCe-1;i>=boundCs;i--) {
			map[boundRe][i]=array.get(0);
			array.remove(0);
		}
		for(int i=boundRe-1;i>boundRs;i--) {
			map[i][boundCs]=array.get(0);
			array.remove(0);
		}
	}
}
