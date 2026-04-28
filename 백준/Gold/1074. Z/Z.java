import java.util.*;
import java.io.*;

public class Main {
	static int N,R,C;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		System.out.println(find(R,C,(1<<N),0));
	}
	static int find(int r, int c,int size,int sum) {
		int q = size*size/4;
		if(size==2) return sum+(2*r)+c;
		
		if(r>=(size/2)) {
			if(c>=(size/2)) return find(r-(size/2),c-(size/2),size/2,sum+3*q);
			return find(r-(size/2),c,size/2,sum+2*q);
		}
		else {
			if(c>=(size/2)) return find(r,c-(size/2),size/2,sum+1*q);
			else return find(r,c,size/2,sum);
		}
	}
}
