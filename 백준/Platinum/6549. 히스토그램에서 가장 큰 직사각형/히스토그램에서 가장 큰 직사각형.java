import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] h,htree;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		while(true) {
			N=next();
			if(N==0)break;
			h=new int[N+1];
			h[N]=Integer.MAX_VALUE;
			htree=new int[4*N];
			for(int i=0;i<N;i++) {
				h[i]=next();
			}
			initH(0,N-1,1);
			sb.append(findMaxVolume(0,N-1)).append("\n");
		}
		System.out.print(sb);
		
		
	}
	
	static int initH(int start,int end,int node) {
		if(start==end) {
			htree[node]=start;
			return htree[node];
		}
		int mid=(start+end)/2;
		int leftMinIndex=initH(start,mid,node*2);
		int rightMinIndex=initH(mid+1,end,node*2+1);
		return htree[node]=h[leftMinIndex]<h[rightMinIndex]?leftMinIndex:rightMinIndex;
	}
	
	static long findMaxVolume(int start,int end) {
		if(start==end) return h[start];
		int mid=findMinIndex(0,N-1,1,start,end);
		long maxArea=(long)h[mid]*(end-start+1);
		if(start<=mid-1) {
			maxArea = Math.max(findMaxVolume(start,mid-1), maxArea);
		}
		if(end>=mid+1) {
			maxArea = Math.max(findMaxVolume(mid+1,end),maxArea);
		}
		return maxArea;
	}
	
	static int findMinIndex(int start,int end,int node,int left,int right) {
		if(left>end||right<start) return N;
		if(left<=start&&right>=end) return htree[node];
		int mid=(start+end)/2;
		int leftMinIndex=findMinIndex(start,mid,node*2,left,right);
		int rightMinIndex=findMinIndex(mid+1,end,node*2+1,left,right);
		return h[leftMinIndex]<h[rightMinIndex]?leftMinIndex:rightMinIndex;
	}
	
    static int iidx, size, SIZE = 1 << 10;
    static byte[] ibuffer = new byte[SIZE];
	
    static int next() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = read()) > 47 && c < 58);
        return n;
    }

    static byte read() throws Exception {
        if (iidx == size) {
            size = System.in.read(ibuffer, iidx = 0, SIZE);
            if (size < 0) ibuffer[0] = -1;
        }
        return ibuffer[iidx++];
    }
}
