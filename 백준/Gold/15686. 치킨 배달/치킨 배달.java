import java.util.*;
import java.io.*;

public class Main {
	static int N,M,min=Integer.MAX_VALUE,houseNum,storeNum;
	static List<P> houses=new ArrayList<>(),stores=new ArrayList<>();
	static Integer[] comb;
	static List<Integer[]> storeComb;
	static int[][] map,chickenDistance;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());M=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int value=Integer.parseInt(st.nextToken());
				map[i][j]=value;
				if(value==1)houses.add(new P(i,j));
				if(value==2)stores.add(new P(i,j));
			}
		}
		
		houseNum=houses.size();storeNum=stores.size();
		chickenDistance=new int[houseNum][storeNum];
		calcDistance();
		
		comb=new Integer[M];
		storeComb=new ArrayList<>();
		getStoreComb(0,0);
		
		for(Integer[] c:storeComb) {
			int tmin=0;
			for(int i=0;i<houseNum;i++) {
				int cd=Integer.MAX_VALUE;
				for(int j=0;j<c.length;j++) {
					cd = Math.min(chickenDistance[i][c[j]],cd);
				}
				tmin+=cd;
			}
			min=Math.min(min,tmin);
		}
		System.out.println(min);
	}
	static void getStoreComb(int start,int count) {
		if(count==M) {
			storeComb.add(Arrays.copyOf(comb, M));
			return;
		}
		for(int i=start;i<storeNum;i++) {
			comb[count]=i;
			getStoreComb(i+1,count+1);
		}
		
	}
	static void calcDistance() {
		for(int i=0;i<houseNum;i++) {
			P house = houses.get(i);
			for(int j=0;j<storeNum;j++) {
				P store = stores.get(j);
				chickenDistance[i][j]=Math.abs(house.r-store.r)+Math.abs(house.c-store.c);
			}
		}
	}
	static class P{
		int r,c;
		public P(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}
}
