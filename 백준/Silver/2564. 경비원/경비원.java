import java.util.*;
import java.io.*;

public class Main {
	static int n,m,store;
	static int[][] coords;//상점,동근의 위치
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken());
		store=Integer.parseInt(br.readLine());
		coords=new int[store][2];
		for(int i=0;i<store;i++) {
			st = new StringTokenizer(br.readLine());
			coords[i][0]=Integer.parseInt(st.nextToken());
			coords[i][1]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int dd=Integer.parseInt(st.nextToken()), di=Integer.parseInt(st.nextToken());
		boolean isNS=(dd==1||dd==2)?true:false;
		int sum=0;
		for(int i=0;i<store;i++) {
			if(dd==coords[i][0]) {
				sum+=Math.abs(di-coords[i][1]);
				continue;
			}
			if(isNS) {//동근이가 남북 중 하나
				if(coords[i][0]==1||coords[i][0]==2) {//상점이 남북중 하나
					sum+=m+Math.min(di+coords[i][1],2*n-di-coords[i][1]);
				}
				else if(coords[i][0]==3) {//상점이 서
					int d=dd==1?coords[i][1]:m-coords[i][1];
					sum+=di+d;
				}
				else {//상점이 동
					int d=dd==1?coords[i][1]:m-coords[i][1];
					sum+=n-di+d;
				}
				
			}else {//동근이가 동서중 하나
				if(coords[i][0]==3||coords[i][0]==4) {//상점이 동서중 하나
					sum+=n+Math.min(di+coords[i][1],2*m-di-coords[i][1]);
				}
				else if(coords[i][0]==1) {//상점이 북
					int d=dd==3?coords[i][1]:n-coords[i][1];
					sum+=di+d;
				}
				else {//상점이 남
					int d=dd==3?coords[i][1]:n-coords[i][1];
					sum+=m-di+d;
				}
			}
			
		}
		System.out.println(sum);
	}
}
