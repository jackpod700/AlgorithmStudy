import java.util.*;
import java.io.*;

public class Main {
	static int V,E,start,edgePtr=0;
	static int[] to,w,next,head;
	static long[] dist;
	public static void main(String[] args) throws IOException{
		FastScanner fs = new FastScanner(System.in);
		V=fs.nextInt();
		E=fs.nextInt();
		head = new int[V+1];
		dist = new long[V+1];
		to = new int[E];
		w = new int[E];
		next = new int[E];
		final int INF=1_000_000;
		Arrays.fill(dist,INF);
		Arrays.fill(head, -1);
		start = fs.nextInt();
		for(int i=0;i<E;i++) {
			int u=fs.nextInt();
			int v=fs.nextInt();
			int ww=fs.nextInt();
			to[edgePtr]=v;
			w[edgePtr]=ww;
			next[edgePtr]=head[u];
			head[u]=edgePtr++;
		}
		dist[start]=0;
		
		Queue<Long> queue = new PriorityQueue<>();
		queue.offer((long)start);
		while(!queue.isEmpty()) {
			long curV = queue.poll();
			int u=(int)curV;
			int d=(int)(curV>>>32);
			if(d!=dist[u]) continue;
			for(int e=head[u];e!=-1;e=next[e]) {
				int nextv=to[e];
				if(dist[nextv]>dist[u]+w[e]) {
					dist[nextv]=dist[u]+w[e];
					queue.offer((dist[nextv]<<32)|nextv);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=V;i++) {
			if(dist[i]==INF) sb.append("INF").append("\n");
			else sb.append(dist[i]).append("\n");
		}
		System.out.print(sb);
	}
	
    // ---- FastScanner (byte 단위) ----
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            do c = read(); while (c <= 32);
            if (c == '-') { s = -1; c = read(); }
            while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
    }
}
