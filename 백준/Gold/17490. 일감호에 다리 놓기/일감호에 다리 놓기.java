import java.util.*;
import java.io.*;

public class Main{
	static int N,M;
	static long K,totalRock;
	static int[] rocks;
	static boolean[] visited;
	static Building[] buildings;
	public static void main(String[] args) throws Exception{
		Reader in = new Reader();
		N=in.nextInt();
		M=in.nextInt();
		if(M<2) {
			System.out.println("YES");
			return;
		}
		K=in.nextLong();
		
		rocks = new int[N+1];
		buildings = new Building[N+1];
		for(int i=1;i<=N;i++) {
			totalRock+=rocks[i]=in.nextInt();
			buildings[i]=new Building(i,buildings[i-1],null);
			if(i==1) continue;
			buildings[i-1].next=buildings[i];
			
		}
		buildings[1].before=buildings[N];
		buildings[N].next=buildings[1];
		if(totalRock<=K) {
			System.out.println("YES");
			return;
		}
		int start=0,cnt=0;
		for(int i=0;i<M;i++) {
			int s=in.nextInt();
			int d=in.nextInt();
			if(s<d) {
				buildings[s].next=null;
				buildings[d].before=null;
				if(i==M-1) start=d;
			}
			else {
				if(s==N&&d==1) {
					buildings[s].next=null;
					buildings[d].before=null;
					if(i==M-1) start=1;
				}
				else {
					buildings[s].before=null;
					buildings[d].next=null;
					if(i==M-1) start=s;
				}
			}
		}
		totalRock=0;
		while(cnt!=N) {
			int index=start;
			int min=rocks[index];
			cnt++;
			while(buildings[index].next!=null) {
				cnt++;
				index=(index+1)%(N+1)==0?1:(index+1)%(N+1);
				min=Math.min(min, rocks[index]);
			}
			totalRock+=min;
			start=(index+1)%(N+1)==0?1:(index+1)%(N+1);
		}
		if(totalRock<=K) System.out.println("YES");
		else System.out.println("NO");
	}
	
	static class Building{
		int index;
		Building before,next;
		public Building(int index, Building before, Building next) {
			this.index = index;
			this.before = before;
			this.next = next;
		}
	}
	static class Reader {
	    final int SIZE = 1 << 13;
	    byte[] buffer = new byte[SIZE];
	    int index, size;

	    int nextInt() throws Exception {
	        int n = 0;
	        byte c;
	        boolean isMinus = false;
	        while ((c = read()) <= 32) { if (size < 0) return -1; }
	        if (c == 45) { c = read(); isMinus = true; }
	        do n = (n << 3) + (n << 1) + (c & 15);
	        while (isNumber(c = read()));
	        return isMinus ? ~n + 1 : n;
	    }
	    long nextLong() throws Exception {
	        long n = 0;
	        byte c;
	        boolean isMinus = false;
	        while ((c = read()) <= 32);
	        if (c == 45) { c = read(); isMinus = true; }
	        do n = (n << 3) + (n << 1) + (c & 15);
	        while (isNumber(c = read()));
	        return isMinus ? ~n + 1 : n;
	    }
	    boolean isNumber(byte c) {
	        return 47 < c && c < 58;
	    }
	    byte read() throws Exception {
	        if (index == size) {
	            size = System.in.read(buffer, index = 0, SIZE);
	            if (size < 0) buffer[0] = -1;
	        }
	        return buffer[index++];
	    }
	}
}
