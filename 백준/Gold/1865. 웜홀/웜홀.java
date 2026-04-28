import java.util.*;
import java.io.*;

public class Main {
	static int N,M,W;
	static int[] dist;
	static int[][] edges;
	public static void main(String[] args) throws IOException{
		int TC=readInt();
		while(TC-->0) {
			N=readInt();
			M=readInt();
			W=readInt();
			dist=new int[N+1];
			edges=new int[M+W][3];
			for(int i=0;i<M+W;i++) {
				edges[i][0]=readInt();
				edges[i][1]=readInt();
				edges[i][2]=(i<M)?readInt():-1*readInt();
			}
			boolean able=false;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M+W;j++) {
					int S=edges[j][0];
					int E=edges[j][1];
					int T=edges[j][2];
					if(dist[E]>dist[S]+T) {
						if(i==N-1) {
							able=true;
							break;
						}
						dist[E]=dist[S]+T;
					}
					if(j<M) {
						S=edges[j][1];
						E=edges[j][0];
						if(dist[E]>dist[S]+T) {
							if(i==N-1) {
								able=true;
								break;
							}
							dist[E]=dist[S]+T;
						}
					}
				}
			}
			if(able) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
    private static final int BUF_SIZE = 1 << 13;
    private static final byte[] buf = new byte[BUF_SIZE];
    private static int cursor = -1;
    private static int max;
    private static byte read() throws IOException {
        if (++cursor == max) {
            max = System.in.read(buf, 0, BUF_SIZE);
            cursor = 0;
        }
        return buf[cursor];
    }
    
    private static int readInt() throws IOException {
        int res = 0;
        byte in = read();
        while (in > 32) {
            res = (res << 3) + (res << 1) + (in & 15);
            in = read();
        }
        return res;
    }
}
