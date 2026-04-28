import java.util.*;
import java.io.*;

public class Main {
	static int R,C,M,result=0;
	static Shark[][] map;
	static List<Shark> sharks=new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new Shark[R][C];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			Shark s=new Shark(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			sharks.add(s);
			map[s.r][s.c]=s;
		}
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				if(map[j][i]!=null) {
					result+=map[j][i].z;
					map[j][i].valid=false;
					map[j][i]=null;
					break;
				}
			}
			sharksMove();
		}
		System.out.println(result);
	}
	
	static void sharksMove() {
		Shark[][] newMap=new Shark[R][C];
		for(Shark s:sharks) {
			if(s.valid) {
				s.move();
				if(newMap[s.r][s.c]==null||newMap[s.r][s.c].z<s.z) {
					if(newMap[s.r][s.c]!=null)newMap[s.r][s.c].valid=false;
					newMap[s.r][s.c]=s;
				}
				else s.valid=false;
			}
		}
		map=newMap;
	}
	
	static class Shark{
		static int[] sdr= {-1,1,0,0},sdc= {0,0,1,-1};
		boolean valid;
		int r,c,s,z,dr,dc;
		public Shark(int r,int c,int s,int d,int z) {
			this.r=r-1;
			this.c=c-1;
			this.s=s;
			this.z=z;
			dr=sdr[d-1];
			dc=sdc[d-1];
			valid=true;
		}
		
		public void move() {
			for(int i=0;i<s;i++) {
				r=r+dr;
				c=c+dc;
				if(r==-1) {
					r=1;
					dr=-1*dr;
				}
				if(r==R) {
					r=R-2;
					dr=-1*dr;
				}
				if(c==-1) {
					c=1;
					dc=-1*dc;
				}
				if(c==C) {
					c=C-2;
					dc=-1*dc;
				}
			}
		}
		
	}
}
