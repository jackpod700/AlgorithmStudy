import java.util.*;
import java.io.*;

public class Main {
	static int N,W;
	static int[][] cases,d;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		W=Integer.parseInt(br.readLine());
		cases=new int[W+1][2];
		d=new int[W+1][W+1];//d[a][b] 1번이 a번 장소, 2번이 b번 장소에 있을때의 최솟값
		for(int i=0;i<=W;i++)Arrays.fill(d[i], Integer.MAX_VALUE);
		
		for(int i=1;i<=W;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cases[i][0]=Integer.parseInt(st.nextToken());
			cases[i][1]=Integer.parseInt(st.nextToken());
		}
		d[0][0]=0;
		d[0][1]=Math.abs(N-cases[1][0])+Math.abs(N-cases[1][1]);
		d[1][0]=Math.abs(1-cases[1][0])+Math.abs(1-cases[1][1]);
		int result=Integer.MAX_VALUE,minA=Integer.MAX_VALUE,minB=Integer.MAX_VALUE;
		for(int a=0;a<W;a++) {
			d[a][W]=dp(a,W);
			if(result>d[a][W]) {
				result=d[a][W];
				minA=a;minB=W;
			}
		}
		for(int b=0;b<W;b++) {
			d[W][b]=dp(W,b);
			if(result>d[W][b]) {
				result=d[W][b];
				minA=W;minB=b;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		track(minA,minB,sb);
		sb.insert(0, result+"\n");
		System.out.print(sb);
	}
	static int dp(int a,int b) {
		if(d[a][b]!=Integer.MAX_VALUE)return d[a][b];
		if(a>b) {
			if(a-b>1)d[a][b]=Math.min(d[a][b], dp(a-1,b)+Math.abs(cases[a][0]-cases[a-1][0])+Math.abs(cases[a][1]-cases[a-1][1]));
			else {
				for(int ta=b-1;ta>=1;ta--) {
					d[a][b]=Math.min(d[a][b], dp(ta,b)+Math.abs(cases[a][0]-cases[ta][0])+Math.abs(cases[a][1]-cases[ta][1]));
				}
				d[a][b]=Math.min(d[a][b], dp(0,b)+Math.abs(cases[a][0]-1)+Math.abs(cases[a][1]-1));
			}
		}
		else {
			if(b-a>1)d[a][b]=Math.min(d[a][b], dp(a,b-1)+Math.abs(cases[b][0]-cases[b-1][0])+Math.abs(cases[b][1]-cases[b-1][1]));
			else {
				for(int tb=a-1;tb>=1;tb--) {
					d[a][b]=Math.min(d[a][b], dp(a,tb)+Math.abs(cases[b][0]-cases[tb][0])+Math.abs(cases[b][1]-cases[tb][1]));
				}
				d[a][b]=Math.min(d[a][b], dp(a,0)+Math.abs(cases[b][0]-N)+Math.abs(cases[b][1]-N));
			}
		}
		return d[a][b];
	}
	
	static void track(int a,int b, StringBuilder sb) {
		while(a>0||b>0) {
			if(a>b) {
				if(a-b>1) {
					sb.insert(0, "1\n");
					a--;
				}
				else {
					for(int ta=b-1;ta>=1;ta--) {
						if(d[ta][b]+Math.abs(cases[a][0]-cases[ta][0])+Math.abs(cases[a][1]-cases[ta][1])==d[a][b]) {
							sb.insert(0, "1\n");
							a=ta;
							break;
						}
					}
					if(d[0][b]+Math.abs(cases[a][0]-1)+Math.abs(cases[a][1]-1)==d[a][b]) {
						sb.insert(0, "1\n");
						a=0;
					}
				}
			}
			else {
				if(b-a>1) {
					sb.insert(0, "2\n");
					b--;
				}
				else {
					for(int tb=a-1;tb>=1;tb--) {
						if(d[a][tb]+Math.abs(cases[b][0]-cases[tb][0])+Math.abs(cases[b][1]-cases[tb][1])==d[a][b]) {
							sb.insert(0, "2\n");
							b=tb;
							break;
						}
					}
					if(d[a][0]+Math.abs(cases[b][0]-N)+Math.abs(cases[b][1]-N)==d[a][b]) {
						sb.insert(0, "2\n");
						b=0;
					}
				}
			}
		}

	}
}
