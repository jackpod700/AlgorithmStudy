import java.util.*;
import java.io.*;

public class Main {
	static int k;
	static int[] move= {4,2,3,1};
	static int[][] input = new int[6][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int cur=0,prev=0;
		for(int i=0;i<6;i++) {
			st=new StringTokenizer(br.readLine());
			input[i][0]=Integer.parseInt(st.nextToken());
			input[i][1]=Integer.parseInt(st.nextToken());
			if(input[i][0]==4) {
				cur=i;
				prev=(i+5)%6;
			}
		}
		int moveIndex=0;
		while(true) {
			if(!(input[cur][0]==move[moveIndex]&&input[prev][0]==move[(moveIndex+3)%4])) {
				int w = input[cur][1]+input[(prev+5)%6][1];
				int h = input[prev][1]+input[(cur+1)%6][1];
				int subArea=input[cur][1]*input[prev][1];
				System.out.println(k*(w*h-subArea));
				return;
			}
			prev=cur;
			cur=(cur+1)%6;
			moveIndex=(moveIndex+1)%4;
		}
		
	}
}
