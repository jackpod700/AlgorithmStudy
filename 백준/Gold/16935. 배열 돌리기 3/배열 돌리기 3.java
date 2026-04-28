import java.util.*;
import java.io.*;
public class Main {
	static int N,M,R;
	static int[][] mat;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		mat=new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				mat[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			int command=Integer.parseInt(st.nextToken());
			switch(command) {
			case 1:
				_1();
				break;
			case 2:
				_2();
				break;
			case 3:
				_3();
				break;
			case 4:
				_4();
				break;
			case 5:
				_5();
				break;
			case 6:
				_6();
				break;
			}
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
	
	static void _1() {
		int[][] newMat = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				newMat[N-1-i][j]=mat[i][j];
			}
		}
		mat=newMat;
	}
	static void _2() {
		int[][] newMat = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				newMat[i][M-1-j]=mat[i][j];
			}
		}
		mat=newMat;
	}
	static void _3() {
		int[][] newMat = new int[M][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				newMat[j][N-1-i]=mat[i][j];
			}
		}
		mat=newMat;
		int temp=N;
		N=M;
		M=temp;
	}
	static void _4() {
		_3();_3();_3();
	}
	
	static void _5() {
		int[][] newMat = new int[N][M];
		//좌상
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				newMat[i][j+M/2]=mat[i][j];
			}
		}
		//우상
		for(int i=0;i<N/2;i++) {
			for(int j=M/2;j<M;j++) {
				newMat[i+N/2][j]=mat[i][j];
			}
		}
		//좌하
		for(int i=N/2;i<N;i++) {
			for(int j=0;j<M/2;j++) {
				newMat[i-N/2][j]=mat[i][j];
			}
		}
		//우하
		for(int i=N/2;i<N;i++) {
			for(int j=M/2;j<M;j++) {
				newMat[i][j-M/2]=mat[i][j];
			}
		}
		mat=newMat;
	}
	static void _6() {
		int[][] newMat = new int[N][M];
		//좌상
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				newMat[i+N/2][j]=mat[i][j];
			}
		}
		//우상
		for(int i=0;i<N/2;i++) {
			for(int j=M/2;j<M;j++) {
				newMat[i][j-M/2]=mat[i][j];
			}
		}
		//좌하
		for(int i=N/2;i<N;i++) {
			for(int j=0;j<M/2;j++) {
				newMat[i][j+M/2]=mat[i][j];
			}
		}
		//우하
		for(int i=N/2;i<N;i++) {
			for(int j=M/2;j<M;j++) {
				newMat[i-N/2][j]=mat[i][j];
			}
		}
		mat=newMat;
	}
}
