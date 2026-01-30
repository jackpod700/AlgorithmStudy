import java.util.*;
import java.io.*;
public class Main {
	static int N,M,R;
	static int[][] mat;
	static int[][][] qmat;
	static int[][] reducedMap= {{0,1},{2,3}};
	static int[][] rotate = {{3,1,4,6},{0,2,7,5},{1,3,6,4},{2,0,5,7},{7,5,0,2},{4,6,3,1},{5,7,2,0},{6,4,1,3}};//시계,반시계,좌우,상하
	static int rotateStat=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		mat=new int[N][M];
		qmat=new int[4][N/2][M/2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				mat[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		fill_qmat();
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
		makeMat();
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
		rotateStat=rotate[rotateStat][3];
		int[][] newMat = {{reducedMap[1][0],reducedMap[1][1]},{reducedMap[0][0],reducedMap[0][1]}};
		reducedMap=newMat;
	}
	static void _2() {
		rotateStat=rotate[rotateStat][2];
		int[][] newMat = {{reducedMap[0][1],reducedMap[0][0]},{reducedMap[1][1],reducedMap[1][0]}};
		reducedMap=newMat;
	}
	static void _3() {
		rotateStat=rotate[rotateStat][0];
		_5();
	}
	static void _4() {
		rotateStat=rotate[rotateStat][1];
		_6();
	}
	static void _5() {
		int[][] newMat = {{reducedMap[1][0],reducedMap[0][0]},{reducedMap[1][1],reducedMap[0][1]}};
		reducedMap=newMat;
	}
	static void _6() {
		int[][] newMat = {{reducedMap[0][1],reducedMap[1][1]},{reducedMap[0][0],reducedMap[1][0]}};
		reducedMap=newMat;
	}
	
	static void fill_qmat() {
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) {
				qmat[0][i][j]=mat[i][j];
				qmat[1][i][j]=mat[i][j+M/2];
				qmat[2][i][j]=mat[i+N/2][j];
				qmat[3][i][j]=mat[i+N/2][j+M/2];
			}
		}
	}
	
	static void makeMat() {
		if(rotateStat%2==0) {
			int[] startR= {0,N/2-1,0,N/2-1};
			int[] startC= {0,M/2-1,M/2-1,0};
			int[] dr= {1,-1,1,-1};
			int[] dc= {1,-1,-1,1};
			int rotateIndex=rotateStat/2;
			int curR=startR[rotateIndex],curC=startC[rotateIndex];
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					mat[i][j]=qmat[reducedMap[0][0]][curR][curC];
					mat[i][j+M/2]=qmat[reducedMap[0][1]][curR][curC];
					mat[i+N/2][j]=qmat[reducedMap[1][0]][curR][curC];
					mat[i+N/2][j+M/2]=qmat[reducedMap[1][1]][curR][curC];
					curC+=dc[rotateIndex];
				}
				curC=startC[rotateIndex];
				curR+=dr[rotateIndex];
			}
		}else {
			int[] startR= {0,N/2-1,0,N/2-1};
			int[] startC= {M/2-1,0,0,M/2-1};
			int[] dr= {1,-1,1,-1};
			int[] dc= {-1,1,1,-1};
			int rotateIndex=(rotateStat-1)/2;
			int curR=startR[rotateIndex],curC=startC[rotateIndex];
			int temp = N;
			N=M;
			M=temp;
			mat = new int[N][M];
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					mat[i][j]=qmat[reducedMap[0][0]][curR][curC];
					mat[i][j+M/2]=qmat[reducedMap[0][1]][curR][curC];
					mat[i+N/2][j]=qmat[reducedMap[1][0]][curR][curC];
					mat[i+N/2][j+M/2]=qmat[reducedMap[1][1]][curR][curC];
					curR+=dr[rotateIndex];
				}
				curR=startR[rotateIndex];
				curC+=dc[rotateIndex];
			}
		}
	}
}
