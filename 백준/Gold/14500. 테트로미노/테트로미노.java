import java.util.*;
import java.io.*;

public class Main {
	static int[][][] tetromino= {
			{{0,0},{0,1},{0,2},{0,3}},//1자
			{{0,0},{1,0},{2,0},{3,0}},
			{{0,0},{0,1},{1,0},{1,1}},//사각형
			{{0,0},{1,0},{2,0},{2,1}},//ㄱ자
			{{0,0},{1,0},{0,1},{0,2}},
			{{0,0},{0,1},{1,1},{2,1}},
			{{0,0},{0,1},{0,2},{-1,2}},
			{{0,0},{1,0},{2,0},{2,-1}},//ㄱ자 대칭
			{{0,0},{1,0},{1,1},{1,2}},
			{{0,0},{1,0},{2,0},{0,1}},
			{{0,0},{0,1},{0,2},{1,2}},
			{{0,0},{1,0},{1,1},{2,1}},//ㄹ자
			{{0,0},{0,1},{-1,1},{-1,2}},
			{{0,0},{1,0},{0,1},{-1,1}},//ㄹ자 대칭
			{{0,0},{0,1},{1,1},{1,2}},
			{{0,0},{0,1},{0,2},{1,1}},//ㅜ자
			{{0,0},{0,1},{1,1},{-1,1}},
			{{0,0},{0,1},{0,2},{-1,1}},
			{{0,0},{0,1},{-1,0},{1,0}}};
	static int N,M,result=-1;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int t=0;t<tetromino.length;t++) {
			int[] t1=tetromino[t][0];
			int[] t2=tetromino[t][1];
			int[] t3=tetromino[t][2];
			int[] t4=tetromino[t][3];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					try {
						int tresult=map[i+t1[0]][j+t1[1]];
						tresult+=map[i+t2[0]][j+t2[1]];
						tresult+=map[i+t3[0]][j+t3[1]];
						tresult+=map[i+t4[0]][j+t4[1]];
						result=Math.max(result, tresult);
					}catch(ArrayIndexOutOfBoundsException e) {
						
					}

				}
			}
		}
		
		System.out.println(result);
	}
}
